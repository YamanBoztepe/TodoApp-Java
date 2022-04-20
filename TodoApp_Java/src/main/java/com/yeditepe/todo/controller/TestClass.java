package com.yeditepe.todo.controller;

import com.yeditepe.todo.dao.UserDao;

public class TestClass {

	public static void main(String[] args) {
		UserDao dao = new UserDao();
		int cevap = dao.signUp("yaman2", "yaman2", "yaman1", 1);
		System.out.println(cevap);
	}

}
