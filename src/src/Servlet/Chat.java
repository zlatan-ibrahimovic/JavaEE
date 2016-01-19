package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import Entities.Announce;
import Entities.User;

import javax.ejb.EJB;

@WebServlet("/Chat")
public class Chat extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@EJB
	private IAnnounceDAO announceDAO;
	
	@EJB
	private IUserDAO userDAO;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/Chat/Chat.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		User user =(User) session.getAttribute("sessionUser");
		user = userDAO.find(user.getEmail(), user.getPassword());*/
		
		this.getServletContext().getRequestDispatcher("/Chat/Chat.jsp").forward(request, response);
		
		
	}

}
