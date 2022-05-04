package com.yeditepe.todo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.yeditepe.todo.dao.UserDao;
import com.yeditepe.todo.helper.UserInfo;
import com.yeditepe.todo.model.User;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao = new UserDao();

	public SignUpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		goToSignUpPage(response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		addNewUser(request, response);
	}
	
	private void goToSignUpPage(HttpServletResponse response) throws IOException {
		response.sendRedirect("view/signup/signup.jsp");
	}
	
	private void addNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("select");
		int intGender = gender == "male" ? 1 : 0;
		int isSuccess = dao.signUp(username, password, name, intGender);
		Integer userId = dao.getUserId(username);
		if (isSuccess == 1 && userId != -1) {
			User user = new User(userId, username, password, name, intGender);
			UserInfo.shared.setUser(user);
			response.sendRedirect("view/todo/todo.jsp");
		} else {
			response.sendRedirect("view/signup/signupFail.jsp");
		}
	}
}
