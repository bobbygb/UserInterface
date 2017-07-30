package com.tea.user.http;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.tea.common.common.IRedisService;
import com.tea.common.spring.SpringUtil;
import com.tea.common.util.Base64;
import com.tea.common.util.HttpContext;
import com.tea.common.util.SHA1Util;
import com.tea.common.util.SerializeUtil;
import com.tea.user.common.UIConstants;

public class HttpSessionUtil {
	
	public static final String SESSION_ID = "ZYXRSession";
	public static final String SESSION_NAME = "UserSession";
	public static final String TOKEN = UIConstants.TOKEN;
	private static int sessionTimeOut = 20 * 60;
	
	
	private static IRedisService redisService;

	private synchronized static IRedisService getRedisService() {
		if(redisService == null)
		{
			redisService = SpringUtil.ApplicationContext().getBean(IRedisService.class);
		}
		return redisService;
	}
	
	public static String getCurrentSessionId()
	{
		HttpServletRequest req = HttpContext.gethttpServletRequest();
		HttpServletResponse resp = HttpContext.gethttpServletResponse();
		String sessionid = getSessionId(req);
		if(StringUtils.isEmpty(sessionid))
		{
			Long l = getRedisService().incr(SESSION_ID + "_sessionId", 1l);
			// 新建一个sessionId
			sessionid = SHA1Util.getSHA1String(l.toString() + "," + System.currentTimeMillis());
			setSessionId(req, resp, sessionid);
		}
		return sessionid;
	}
	
	private static SessionX getSessionFromRedis(String sessionid)
	{
		String data = getRedisService().get(SESSION_NAME + "_"+ sessionid);
		if(data == null)
		{
			return new SessionX();
		}
		byte[] d = Base64.FromBase64String(data);
		return (SessionX)SerializeUtil.deserialize(d);	
	}
	private static ThreadLocal<ISessionX> local = new ThreadLocal<>();
	
	public static ISessionX getSession() {
		ISessionX ret = local.get();
		if(ret != null) return ret;
		
		String sid = getCurrentSessionId();
		SessionX adminuser = getSessionFromRedis(sid);
		ISessionX user =	(ISessionX) Proxy.newProxyInstance(SessionX.class.getClassLoader(),new Class<?>[]{ ISessionX.class},
				 (proxy, method, args) ->
		{
			Object o = method.invoke(adminuser, args);
			if(method.getName().startsWith("set"))
			{
				getRedisService().setObject(SESSION_NAME + "_" + sid, adminuser,sessionTimeOut);
			}else if(method.getName().startsWith("get"))
			{
				getRedisService().expire(SESSION_NAME + "_" + sid,sessionTimeOut);
			}else if(method.getName().equals("clear"))
			{
				getRedisService().del(SESSION_NAME + "_" + sid);
				HttpServletRequest req = HttpContext.gethttpServletRequest();
				HttpServletResponse resp = HttpContext.gethttpServletResponse();
				deleteCookie(req,resp);
			}
			return o;
		});
		local.set(user);
		HttpContext.addAfterHttpResponse(()->
		{
			local.remove();
		});
		return user;

	}
	
	
	
	private static String getSessionId(HttpServletRequest req) {
		Cookie[] cks = req.getCookies();
		if (cks != null && cks.length > 0) {
			for (Cookie c : cks) {
				if (SESSION_ID.equals(c.getName())) {
					return c.getValue();
				}
			}
		}
		return null;
	}

	private static void setSessionId(HttpServletRequest req, HttpServletResponse resp, String sessionId) {
		Cookie[] cks = req.getCookies();
		Cookie cc = null;
		if (cks != null && cks.length > 0) {
			for (Cookie c : cks) {
				if (SESSION_ID.equals(c.getName())) {
					cc = c;
				}
			}
		}
		if (cc == null) {
			Cookie c = new Cookie(SESSION_ID, sessionId);
			c.setPath("/");
			c.setHttpOnly(true);
			resp.addCookie(c);
		} else {
			cc.setValue(sessionId);
			cc.setPath("/");
			cc.setHttpOnly(true);
		}

	}

	private static void deleteCookie(HttpServletRequest req, HttpServletResponse resp) {

		Cookie[] cks = req.getCookies();
		List<Cookie> ccs = new ArrayList<>();
		for (Cookie c : cks) {
			if (SESSION_ID.equals(c.getName())) {
				ccs.add(c);
			}
		}
		for(Cookie cc : ccs)
		{
			cc.setValue(null);
			cc.setPath("/");
			cc.setMaxAge(0);
			resp.addCookie(cc);
		}

	}

	public static void addCookie(String name, String value) {
		HttpServletResponse resp = HttpContext.gethttpServletResponse();
		Cookie c = new Cookie(name, value);
		c.setPath("/");
		c.setHttpOnly(true);
		resp.addCookie(c);
	}
	
	public static void addCookieByPcToken(String name, String value) {
		HttpServletResponse resp = HttpContext.gethttpServletResponse();
		Cookie c = new Cookie(name, value);
		c.setPath("/");
//		c.setHttpOnly(true);
		c.setMaxAge(20 * 60);
		resp.addCookie(c);
	}
	
	public static void deleteCookieByPcToken(HttpServletRequest req, HttpServletResponse resp) {

		Cookie[] cks = req.getCookies();
		List<Cookie> ccs = new ArrayList<>();
		for (Cookie c : cks) {
			if (UIConstants.TOKEN.equals(c.getName())) {
				ccs.add(c);
			}
		}
		for(Cookie cc : ccs)
		{
			cc.setValue(null);
			cc.setPath("/");
			cc.setMaxAge(0);
			resp.addCookie(cc);
		}

	}
	
	public static String getCookieValue(String cookieName) {
		HttpServletRequest request = HttpContext.gethttpServletRequest();
		Cookie[] cks = request.getCookies();
		if (cks != null && cks.length > 0) {
			for (Cookie c : cks) {
				if (c.getName().equals(cookieName)) {
					return c.getValue();
				}
			}
		}
		return "";
	}
}
