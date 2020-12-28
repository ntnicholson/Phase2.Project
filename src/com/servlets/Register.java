package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserService;
import com.entity.User;
import com.interfaces.IUserInterface;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User register = new User();
		
		register.setUserName(request.getParameter("username"));
		register.setEmail(request.getParameter("email"));
		register.setPassword(request.getParameter("password"));
		
		UserService us = new UserService();
		boolean registered = us.Register(register);
		
		response.setContentType("text/html");
		
		if (registered == true) 
		{
			response.sendRedirect("home.html");
		}
		
	}

}
