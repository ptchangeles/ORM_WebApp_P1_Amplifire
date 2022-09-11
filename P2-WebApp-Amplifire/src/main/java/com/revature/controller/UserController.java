package com.revature.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.UserDao;
import com.revature.model.User;

@WebServlet("/register")
public class UserController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		registerUser(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		response.sendRedirect("index.html");
}
	
	public void registerUser(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		
		userDao.createUser(user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.html");
		dispatcher.forward(request, response);
	}

}