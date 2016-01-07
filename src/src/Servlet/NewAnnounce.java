package Servlet;

import java.io.IOException;
import java.util.Date;

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

@WebServlet("/NewAnnounce")
public class NewAnnounce extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@EJB
	private IAnnounceDAO announceDAO;
	
	@EJB
	private IUserDAO userDAO;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/Private/NewAnnounce.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		Double price = Double.valueOf(request.getParameter("price"));
		Double area = Double.valueOf(request.getParameter("area"));
		String postalCode = request.getParameter("postalCode");
		User seller =(User) session.getAttribute("sessionUser");
		seller = userDAO.find(seller.getEmail(), seller.getPassword());
		Date currentDate = new Date();
		String address = request.getParameter("address");
		
		Announce announce = new Announce();
		announce.setTitle(title);
		announce.setDescription(description);
		announce.setPrice(price);
		announce.setArea(area);
		announce.setAddress(address);
		announce.setDate(currentDate);
		announce.setPostalCode(postalCode);
		
		announceDAO.create(announce);
		
		seller.addMyAnnounce(announce);
		userDAO.create(seller);
		
		String path = request.getContextPath();
		response.sendRedirect(path +"/MyAnnounces");
		
	}

}
