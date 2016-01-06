package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;
import Entities.User;

import javax.ejb.EJB;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IUserDAO userDAO;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Registration.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmation = request.getParameter("confirmation");
		
		String path = request.getContextPath();
		
		System.out.println("Ajout d'un utilisateur:"+email+","+password+","+confirmation);
		
		User u = new User(email,password);
		
		
		request.setAttribute("user", u);
		if(!password.equals(confirmation)){
			String error = "Error password and password confirmation is not the same";
			System.out.println(error);
			request.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Registration.jsp").forward(request, response);
			return ;
		}
		
		if(password.length()<7){
			String error = "Error too less password (more 7 character)";
			System.out.println(error);
			request.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Registration.jsp").forward(request, response);
			return ;
		}
		
		if(password.length()>20){
			String error = "Error too long password";
			System.out.println(error);
			request.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Registration.jsp").forward(request, response);
			return ;
		}
		
		
		if(email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")){
			String error = "Bad Email's Format";
			System.out.println(error);
			u.setEmail("");
			request.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Registration.jsp").forward(request, response);
			return ;
		}
		
		userDAO.create(u);
		
		response.sendRedirect(path+"/Connection");
		
	}
}
