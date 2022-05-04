package com.yeditepe.todo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import com.yeditepe.todo.dao.TodosDao;
import com.yeditepe.todo.helper.UserInfo;
import com.yeditepe.todo.model.Todo;

@WebServlet("/")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TodosDao dao = new TodosDao();
    
    public TodoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/todoForm":
			goToFormPage(response);
			break;
		case "/addTodo":
			addNewTodo(request, response);
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void goToFormPage(HttpServletResponse response) throws IOException {
		response.sendRedirect("view/todo/todo-form.jsp");
	}
	
	private void addNewTodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Todo newTodo = new Todo();
		newTodo.setTitle(request.getParameter("title"));
		newTodo.setStatus(Integer.parseInt(request.getParameter("status")));
		newTodo.setTargetDate(LocalDate.parse(request.getParameter("targetDate")));
		newTodo.setUserId(UserInfo.shared.getUser().getUserId());
		dao.addTodo(newTodo);
		response.sendRedirect("view/todo/todo.jsp");
	}

}
