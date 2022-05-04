package com.yeditepe.todo.helper;

import com.yeditepe.todo.model.User;

public class UserInfo {
	public static UserInfo shared = new UserInfo();
	private User user = null;
	
	private UserInfo() { }
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}