package com.tea.user.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.dubbo.common.serialize.support.kryo.ResponseData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tea.common.common.config.IConfigService;
import com.tea.user.common.ErrorCode;
import com.tea.user.common.NoLogin;
import com.tea.user.http.HttpSessionUtil;
import com.tea.user.http.ISessionX;
import com.tea.user.entity.User;

public class CheckLoginInterceptor implements HandlerInterceptor {
	static Log logger = LogFactory.getLog(CheckLoginInterceptor.class);

	protected static Gson gs = com.tea.common.base.utils.MyGsonBuilder.createNewGson(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss"));
	
//	@Autowired
//	IRedisService redisService;
	@Autowired
    IConfigService configService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(!configService.isProduction()){
    		response.setHeader("Access-Control-Allow-Credentials", "true");
    		response.setHeader("Access-Control-Allow-Origin","*");
    	}
		
		response.setHeader("Content-type", "text/json;charset=UTF-8");  
		
		response.setCharacterEncoding("UTF-8");  
		
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		NoLogin noLogin = handlerMethod.getMethod().getAnnotation(NoLogin.class);
		if (null != noLogin) {
			if (logger.isDebugEnabled()) {
			}
			return true;
		}
		handlerMethod.getMethod().getDeclaringClass().getAnnotation(Controller.class);
		noLogin = handlerMethod.getMethod().getDeclaringClass().getAnnotation(NoLogin.class);
		if (null != noLogin) {
			if (logger.isDebugEnabled()) {
			}
			return true;
		}
		ISessionX session = HttpSessionUtil.getSession();
		User user = session.getUser();
		if (user == null) {
			ResponseData<Void> responseData = new ResponseData<Void>(ErrorCode.USER_NOT_LOGIN,"请登录");
			response.getWriter().write(gs.toJson(responseData).toString());
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
