package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserService;
import com.entity.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User login = new User();
		
		login.setEmail(request.getParameter("email"));
		login.setPassword(request.getParameter("password"));
		
		UserService us = new UserService();
		boolean registered = us.Login(login);
		
		response.setContentType("text/html");
		
		if (registered == true) 
		{
			HttpSession s = request.getSession();
			s.setAttribute("sesname", login.getUserName());
			response.sendRedirect("dashboard.jsp");
		}else {
			response.sendRedirect("login.html");
		}
	}

}
