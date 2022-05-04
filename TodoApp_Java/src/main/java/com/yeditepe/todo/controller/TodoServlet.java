package com.yeditepe.todo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import com.yeditepe.todo.dao.TodosDao;
import com.yeditepe.todo.helper.UserInfo;
import com.yeditepe.todo.model.Todo;
import com.yeditepe.todo.model.User;

@WebServlet("/")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodosDao dao = new TodosDao();
		User user = UserInfo.shared.getUser();
		ArrayList<Todo> todos = dao.getTodo(user.getUserId());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String action = request.getServletPath();
		switch (action) {
		case "/todoForm":
			response.sendRedirect("view/todo/todo-form.jsp");
			break;
		case "/addTodo":
			Todo newTodo = new Todo();
			newTodo.setTitle(request.getParameter("title"));
			newTodo.setStatus(Integer.parseInt(request.getParameter("status")));
			newTodo.setTargetDate(LocalDate.parse(request.getParameter("targetDate")));
			newTodo.setUserId(UserInfo.shared.getUser().getUserId());
			dao.addTodo(newTodo);
			response.sendRedirect("view/todo/todo.jsp");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
