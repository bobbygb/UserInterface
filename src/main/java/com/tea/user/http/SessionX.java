package com.tea.user.http;

import java.util.HashMap;
import java.util.Map;

import com.tea.user.entity.User;

public class SessionX implements ISessionX {
	
	public static final String UserID = "___USER_KEY";
	
	public String sessionId;
	
	private Map<String, Object> maps = new HashMap<>();
	
	public Object get(String key)
	{
		return maps.get(key);
	}
	
	public void set(String key,Object obj)
	{
		maps.put(key, obj);
	}
	
	public void clear()
	{
		
	}

	@Override
	public User getUser(){
		 return (User)maps.get(UserID);
	}

	@Override
	public long getUserId() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
