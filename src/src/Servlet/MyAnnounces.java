package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import Entities.User;
import Entities.Announce;

import javax.ejb.EJB;

@WebServlet("/MyAnnounces")
public class MyAnnounces extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private IUserDAO userDAO;
	
	@EJB
	private IAnnounceDAO announceDAO;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUser");
		user = userDAO.find(user.getEmail(), user.getPassword());
		request.setAttribute("MyAnnounces", new ArrayList<Announce>(user.getMyAnnounces()));
		this.getServletContext().getRequestDispatcher("/Private/MyAnnounces.jsp").forward(request, response);
	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
