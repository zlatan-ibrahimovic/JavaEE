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

@WebServlet("/UnFollowAnnounce")
public class UnFollowAnnounce extends HttpServlet{
	
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
		
		for(User u : announce.getObservors()){
			System.out.println("*getObservors");
			System.out.println(u.getId());
		}
		for(Announce a : user.getMyFavoritesAnnounces()){
			System.out.println("*getMyFA");
			System.out.println(a.getId());
		}
		
		user.removeMyFavoritesAnnounces(announce);
		
		for(User u : announce.getObservors()){
			System.out.println("**getObservors");
			System.out.println(u.getId());
		}
		for(Announce a : user.getMyFavoritesAnnounces()){
			System.out.println("**getMyFA");
			System.out.println(a.getId());
		}
		
		userDAO.create(user);
		announceDAO.create(announce);
		
		for(User u : announce.getObservors()){
			System.out.println("getObservors");
			System.out.println(u.getId());
		}
		for(Announce a : user.getMyFavoritesAnnounces()){
			System.out.println("getMyFA");
			System.out.println(a.getId());
		}
		session.setAttribute("sessionUser", user);
		String path = request.getContextPath();
		response.sendRedirect(path +"/Home");
		
	}

}
