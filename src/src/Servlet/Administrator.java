package Servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.IAnnounceDAO;
import DAO.IUserDAO;

@WebServlet("/Administrator")
public class Administrator extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private IUserDAO userDAO;
	
	@EJB
	private IAnnounceDAO announceDAO;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Users", userDAO.findAllUser());
		request.setAttribute("Announces", announceDAO.findAllAnnounce());
		this.getServletContext().getRequestDispatcher("/WEB-INF/Administrator.jsp").forward(request, response);
	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
