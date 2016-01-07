package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;
import Entities.Announce;

import javax.ejb.EJB;

@WebServlet("/RemoveAnnounce")
public class RemoveAnnounce extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@EJB
	private IAnnounceDAO announceDAO;
	
	@EJB
	private IUserDAO userDAO;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() +"/MyAnnounces");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idAnnounce = Integer.valueOf(request.getParameter("idAnnounce"));
		System.out.println(idAnnounce);
		Announce announce = announceDAO.find(idAnnounce);
		System.out.println(announce.getId());
		announceDAO.remove(announce);
		
		response.sendRedirect(request.getContextPath() +"/MyAnnounces");
	}

}
