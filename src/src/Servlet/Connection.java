package Servlet;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.IUserDAO;
import Entities.User;
@WebServlet("/Connection")
public class Connection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IUserDAO userDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.getServletContext().getRequestDispatcher("/WEB-INF/Connection.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String path = request.getContextPath();
		
		User user = userDAO.find(email, password);
		
		if(user == null){
			String error = "Bad email or bad password";
			request.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Connection.jsp").forward(request, response);
			return ;
		}
		user.setAlert("");
		HttpSession session = request.getSession();
		session.setAttribute("sessionUser", user);
		request.setAttribute( "user", user );
		response.sendRedirect(path +"/Home");
	}

}
