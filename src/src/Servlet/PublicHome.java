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
import Entities.Announce;

@WebServlet("/PublicHome")
public class PublicHome extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	@EJB
	private IAnnounceDAO announceDAO;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Announces", announceDAO.findForSale());
		this.getServletContext().getRequestDispatcher("/WEB-INF/PublicHome.jsp").forward(request, response);
	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Announce> announces = null;
		String sort = request.getParameter("sort");
		if(sort.equals("areaDESC")){
			announces =  announceDAO.findAllOBAreaDESC();
		}
		if(sort.equals("areaASC")){
			announces =  announceDAO.findAllOBAreaASC();
		}
		if(sort.equals("priceDESC")){
			announces =  announceDAO.findAllOBPriceDESC();
		}
		if(sort.equals("priceASC")){
			announces =  announceDAO.findAllOBPriceASC();
		}
		if(sort.equals("address")){
			announces = announceDAO.findAllOBPostalCode();
		}
		if(announces == null){
			announces = announceDAO.findAllAnnounce();
		}
		request.setAttribute("Announces", announces);
		this.getServletContext().getRequestDispatcher("/WEB-INF/PublicHome.jsp").forward(request, response);
	}

}
