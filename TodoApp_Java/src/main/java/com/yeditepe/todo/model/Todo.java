package com.yeditepe.todo.model;

import java.time.LocalDate;

public class Todo {
	private String title;
	private LocalDate targetDate;
	private Integer status;
	private Integer userId;
	private Integer todoId;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTodoId() {
		return todoId;
	}
	public void setTodoId(Integer todoId) {
		this.todoId = todoId;
	}
	
}

