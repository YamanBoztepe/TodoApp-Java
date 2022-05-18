package com.yeditepe.todo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.yeditepe.todo.dao.UserDao;
import com.yeditepe.todo.helper.UserInfo;
import com.yeditepe.todo.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao = new UserDao();

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		activateCookie(request, response);
		logIn(request, response);
	}
	
	private void logIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = dao.logIn(username, password);
		if (user != null) {
			UserInfo.shared.setUser(user);
			response.sendRedirect("view/todo/todo.jsp");
		} else {
			response.sendRedirect("view/login/loginFail.jsp");
		}
	}
	
	private void activateCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String isActive = request.getParameter("rememberMe");
		if (username != null && password != null && isActive != null && isActive.equals("active")) {
			Cookie usernameCookie = new Cookie("username", username);
			Cookie passwordCookie = new Cookie("password", password);
			usernameCookie.setMaxAge(60 * 60 * 24 * 7);
			passwordCookie.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(usernameCookie);
			response.addCookie(passwordCookie);
		}
	}

}
