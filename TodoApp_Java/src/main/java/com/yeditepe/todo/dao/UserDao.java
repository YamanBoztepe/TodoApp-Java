package com.yeditepe.todo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yeditepe.todo.helper.Database;
import com.yeditepe.todo.model.User;

public class UserDao {
	private Connection databaseConnection;
	private static String SELECT_USER = "select * from Users where username=? and password=?";
	private static String SELECT_USER_FOR_USERNAME = "select * from Users where username=?";
	private static String ADD_USER = "INSERT INTO Users (username, password, name, sex) VALUES (?,?,?,?);";
	

	public UserDao() {
		databaseConnection = Database.getConnection();
	}
	
	public User logIn(String username, String password) {
		User user = null;
		try {
			PreparedStatement statement = databaseConnection.prepareStatement(SELECT_USER);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int userId = result.getInt("userId");
				String name = result.getString("name");
				int sex = result.getInt("sex");
				user = new User(userId, username, password, name, sex);
			}
			
		} catch(SQLException e) {
			System.out.println("Connection Problem");
		}
		return user;
	}
	
	public int signUp(String username, String password, String name, int sex)  {
		int result = 0;
		if (isUserExists(username)) {
			return result;
		}
		
		try {
			PreparedStatement statement = databaseConnection.prepareStatement(ADD_USER);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, name);
			statement.setInt(4, sex);
			result = statement.executeUpdate();
		} catch(SQLException e) {
			System.out.println("Connection Problem");
		}
		return result;
	}
	
	public int getUserId(String username) {
		try {
			PreparedStatement statement = databaseConnection.prepareStatement(SELECT_USER_FOR_USERNAME);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			
         while(result.next()) {
        	return result.getInt("userId");
         }
        		 
		} catch(SQLException e) {
			System.out.println("Connection Problem");
		}
		System.out.println("User id is not found");
        return -1;
	}
	
	private boolean isUserExists(String username) {
		try {
			PreparedStatement statement = databaseConnection.prepareStatement(SELECT_USER_FOR_USERNAME);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			
         while(result.next()) {
        	return true;
         }
        		 
		} catch(SQLException e) {
			System.out.println("Connection Problem");
		}
        return false;
	}
	
	
}

