package com.tea.user.http;

import com.tea.user.entity.User;

public interface ISessionX {
	
	User getUser();
	
	public Object get(String key);
	
	public void set(String key,Object obj);
	
	public void clear();

	public long getUserId();
}
