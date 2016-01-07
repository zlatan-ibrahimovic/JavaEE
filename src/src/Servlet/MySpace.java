package Servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import Entities.User;

import javax.ejb.EJB;

@WebServlet("/MySpace")
public class MySpace extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private IUserDAO userDAO;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/Private/MySpace.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String changePassword = request.getParameter("changePassword");
		String modifiedUser = request.getParameter("modifiedUser");
		if(modifiedUser != null){
			modifiedUser(request,response);
			return ;
		}
		if(changePassword != null){
			changePassword(request, response);
			return ;
		}
	}
	
	
	private void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		String confirmation = request.getParameter("confirmation");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUser");
		
		System.out.println(password + ','+newPassword+','+confirmation+','+user.getPassword()+"...");
		
		if(!user.getPassword().equals(password)){
			String error = "It isn't your password";
			System.out.println(error);
			request.setAttribute("errorP", error);
			this.getServletContext().getRequestDispatcher("/Private/MySpace.jsp").forward(request, response);
		}
		
		if(!newPassword.equals(confirmation)){
			String error = "Error new password and password confirmation is not the same";
			System.out.println(error);
			request.setAttribute("errorP", error);
			this.getServletContext().getRequestDispatcher("/Private/MySpace.jsp").forward(request, response);
		}
		
		if(newPassword.length()<7){
			String error = "Error too less new password (more 7 character)";
			System.out.println(error);
			request.setAttribute("errorP", error);
			this.getServletContext().getRequestDispatcher("/Private/MySpace.jsp").forward(request, response);
			return ;
		}
		
		if(newPassword.length()>20){
			String error = "Error too long new password";
			System.out.println(error);
			request.setAttribute("errorP", error);
			this.getServletContext().getRequestDispatcher("/Private/MySpace.jsp").forward(request, response);
			return ;
		}
		
		user.setPassword(newPassword);
		userDAO.create(user);
		request.setAttribute("successP", "Password modified with success");
		this.getServletContext().getRequestDispatcher("/Private/MySpace.jsp").forward(request, response);
	}
	
	private void modifiedUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String name = request.getParameter("name");
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUser");
		
		if(name != null){
			user.setName(name);
		}
		if(firstName != null){
			user.setFirstName(firstName);
		}
		if(email != null){
			user.setEmail(email);
		}
		if(address != null){
			user.setAddress(address);
		}
		if(phone != null){
			user.setPhone(phone);
		}
		
		if(email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")){
			String error = "Bad Email's Format";
			System.out.println(error);
			user.setEmail("");
			request.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher("/Private/MySpace.jsp").forward(request, response);
			return ;
		}
		
		userDAO.create(user);
		this.getServletContext().getRequestDispatcher("/Private/MySpace.jsp").forward(request, response);
	}
}
