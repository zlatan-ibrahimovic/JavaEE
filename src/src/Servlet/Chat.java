package Servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.IAnnounceDAO;
import DAO.IUserDAO;
import Entities.Announce;

@WebServlet("/Chat")
public class Chat extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@EJB
	private IAnnounceDAO announceDAO;
	
	@EJB
	private IUserDAO userDAO;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Announces", announceDAO.findAllAnnounce());
		this.getServletContext().getRequestDispatcher("/Chat/Chat.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		User user =(User) session.getAttribute("sessionUser");
		user = userDAO.find(user.getEmail(), user.getPassword());*/
				
	}

}
