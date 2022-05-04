package com.yeditepe.todo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import com.yeditepe.todo.helper.Database;
import com.yeditepe.todo.model.Todo;

public class TodosDao {
	private Connection databaseConnection;
	private static String SELECT_TODO = "select * from Todos where userId=?";
	private static String ADD_TODO = "INSERT INTO Todos(title, target_date, status, userId) VALUES (?,?,?,?)";
	
	public TodosDao() {
		databaseConnection = Database.getConnection();
	}
	
	public ArrayList<Todo> getTodo(Integer userId) {
		ArrayList<Todo> todos = new ArrayList<Todo>();
		try {
			PreparedStatement statement = databaseConnection.prepareStatement(SELECT_TODO);
			statement.setInt(1, userId);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				String title = result.getString("title");
				Integer status = result.getInt("status");
				Integer todoId = result.getInt("todoId");
				LocalDate date = result.getDate("target_date").toLocalDate();
				Todo todo = new Todo();
				todo.setTitle(title);
				todo.setStatus(status);
				todo.setTargetDate(date);
				todo.setTodoId(todoId);
				todo.setUserId(userId);
				todos.add(todo);
			}
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println("Connection Problem");
		}
		return todos;
	}
	
	public void addTodo(Todo todo) {
		try {
			PreparedStatement statement = databaseConnection.prepareStatement(ADD_TODO);
			statement.setString(1, todo.getTitle());
			Date date = Date.valueOf(todo.getTargetDate());
			statement.setDate(2, date);
			statement.setInt(3, todo.getStatus());
			statement.setInt(4, todo.getUserId());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println("Connection Problem");
		}
	}
}
