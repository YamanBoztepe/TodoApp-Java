package com.yeditepe.todo.model;

public class User {
	private Integer userId;
	private String username;
	private String password;
	private String name;
	private Integer sex;
	
	
	public User(int userId, String username, String password, String name, int sex) {
		super();
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.sex = sex;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
}
