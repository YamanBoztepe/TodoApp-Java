package com.yeditepe.todo.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import com.yeditepe.todo.dao.TodosDao;
import com.yeditepe.todo.model.Todo;

public class TestCont {

	public static void main(String[] args) {
		TodosDao dao = new TodosDao();
		ArrayList<Todo> todos = dao.getTodo(4);
		
		for (Todo todo : todos) {
			System.out.println(todo.getTitle());
		}
	}

}
