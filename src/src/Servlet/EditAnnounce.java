package Servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

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
		boolean sold=false;
		if(request.getParameter("sold").equals("SOLD")){
			sold = true;
		}
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
		announce.setSold(sold);
		Announce update = new Announce(announce);
		
		int numPicture = 0;

		HttpSession session = request.getSession();
		String pathSaveFile = getServletContext().getRealPath("/");
		User seller =(User) session.getAttribute("sessionUser");
		seller = userDAO.find(seller.getEmail(), seller.getPassword());
		
		List<FileItem> items;
		try {
			items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for (FileItem item : items) {

			if(!item.isFormField()) {
				String nomChamp = item.getFieldName();
				String nameFile = FilenameUtils.getName(item.getName());
				if(nameFile != null && !nameFile.isEmpty()){
					nameFile = nameFile.substring(nameFile.lastIndexOf('/')+1).substring( nameFile.lastIndexOf('\\')+1);
					if (nameFile.lastIndexOf(".") > 0) {
					    String ext = nameFile.substring(nameFile.lastIndexOf("."));
					    if (ext.equals(".png") || ext.equals(".jpeg") || ext.equals(".jpg")) {
					    	InputStream file = item.getInputStream();
					    	String newNamePicture= seller.getEmail()+new Date().toString()+numPicture+ext;
					    	if(numPicture==0){
							announce.removeAllPhoto();
					    	}
							writeFile(file,newNamePicture,pathSaveFile);
							
							announce.addPhoto(newNamePicture);
							update.addPhoto(newNamePicture);
							numPicture++;
							
					    }else{
					    	String error = "Unsupported format, the supported formats are .jpg and .png";
							request.setAttribute("error", error);
							this.getServletContext().getRequestDispatcher("/Private/NewAnnounce.jsp").forward(request, response);
							return ;
					    }
					} else {
						String error = "Unsupported format, the supported formats are .jpg and .png";
						request.setAttribute("error", error);
						this.getServletContext().getRequestDispatcher("/Private/NewAnnounce.jsp").forward(request, response);
						return ;
					}
				}


			}
		}
		if(numPicture<1){
			String error = "Minimun 2 Pictures";
			request.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher("/Private/NewAnnounce.jsp").forward(request, response);
			return ;
		}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		announceDAO.remove(announce);
		announceDAO.create(update);
		seller.addMyAnnounce(update);
		userDAO.create(seller);
		request.setAttribute("Announce", announceDAO.find(idAnnounce));
		this.getServletContext().getRequestDispatcher("/Private/EditAnnounce.jsp").forward(request, response);
		
	}
	
	private void writeFile( InputStream file, String nomFichier, String chemin ) throws IOException {
		int SIZE_CACHE = 10240;

		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		File f = new File( chemin + nomFichier );
		try {
			in = new BufferedInputStream( file, SIZE_CACHE );
			out = new BufferedOutputStream( new FileOutputStream( f ),SIZE_CACHE );

			byte[] cache = new byte[SIZE_CACHE];
			int size = in.read(cache);

			System.out.println(nomFichier +":" +size);
			while ( size > 0 ) {
				out.write( cache, 0, size );
				size = in.read(cache);
			}

			out.close();
			in.close();

		} catch ( IOException ignore ) {}
	}
}
