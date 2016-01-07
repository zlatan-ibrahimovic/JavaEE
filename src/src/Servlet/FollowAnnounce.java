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

@WebServlet("/FollowAnnounce")
public class FollowAnnounce extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@EJB
	private IAnnounceDAO announceDAO;
	
	@EJB
	private IUserDAO userDAO;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user =(User) session.getAttribute("sessionUser");
		user = userDAO.find(user.getEmail(), user.getPassword());
		
		int idAnnounce = Integer.valueOf(request.getParameter("idAnnounce"));
		Announce announce =announceDAO.find(idAnnounce);
		
		user.addMyFavoritesAnnounces(announce);
		
		userDAO.create(user);
		session.setAttribute("sessionUser", user);
		for(User u : announce.getObservors()){
			System.out.println(u.getId());
		}
		for(Announce a : user.getMyFavoritesAnnounces()){
			System.out.println(a.getId());
		}
		announceDAO.create(announce);
		String path = request.getContextPath();
		response.sendRedirect(path +"/Home");
		
	}

}
