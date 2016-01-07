package Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;
import Entities.Announce;

import javax.ejb.EJB;

@WebServlet("/EditAnnounce")
public class EditAnnounce extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@EJB
	private IAnnounceDAO announceDAO;
	
	@EJB
	private IUserDAO userDAO;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idAnnounce = Integer.valueOf(request.getParameter("idAnnounce"));
		System.out.println(idAnnounce); 
		request.setAttribute("Announce", announceDAO.find(idAnnounce));
		this.getServletContext().getRequestDispatcher("/Private/EditAnnounce.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idAnnounce = Integer.valueOf(request.getParameter("idAnnounce"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		Double price = Double.valueOf(request.getParameter("price"));
		Double area = Double.valueOf(request.getParameter("area"));
		Date currentDate = new Date();
		String address = request.getParameter("address");
		String postalCode = request.getParameter("postalCode");
		
		Announce announce =announceDAO.find(idAnnounce);
		
		announce.setTitle(title);
		announce.setDescription(description);
		announce.setPrice(price);
		announce.setArea(area);
		announce.setAddress(address);
		announce.setPostalCode(postalCode);
		announce.setDate(currentDate);
		
		announceDAO.create(announce);
		
		request.setAttribute("Announce", announceDAO.find(idAnnounce));
		this.getServletContext().getRequestDispatcher("/Private/EditAnnounce.jsp").forward(request, response);
		
	}

}
