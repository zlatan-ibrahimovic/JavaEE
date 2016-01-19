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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import Entities.Announce;
import Entities.User;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.ejb.EJB;
import javax.servlet.annotation.WebInitParam;

@WebServlet(urlPatterns={"/NewAnnounce"})
@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024, maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)

public class NewAnnounce extends HttpServlet{
	
	//private static String pathSaveFile = "/autofs/netapp/account/cremi/oconstan/espaces/travail/WS_Kepler/ALDA_Project/WebContent/ImagesALDA/";

	private static final long serialVersionUID = 1L;

	@EJB
	private IAnnounceDAO announceDAO;

	@EJB
	private IUserDAO userDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(getServletContext().getRealPath("/"));
		this.getServletContext().getRequestDispatcher("/Private/NewAnnounce.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String pathSaveFile = getServletContext().getRealPath("/");
		try {
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

			Announce announce = new Announce();

			User seller =(User) session.getAttribute("sessionUser");
			seller = userDAO.find(seller.getEmail(), seller.getPassword());
			Date currentDate = new Date();
			announce.setDate(currentDate);
			int numPicture = 0;
			for (FileItem item : items) {

				if (item.isFormField()) {

					String nomChamp = item.getFieldName();
					String valeur = item.getString();

					switch (nomChamp) {
					case "title":
						announce.setTitle(valeur);
						break;
					case "description":
						announce.setDescription(valeur);
						break;
					case "price":
						announce.setPrice(Double.valueOf(valeur));
						break;
					case "area":
						announce.setPrice(Double.valueOf(valeur));
						break;
					case "postalCode":
						announce.setPostalCode(valeur);
						break;
					case "address":
						announce.setAddress(valeur);
						break;
					default:
						break;
					}

				} else {
					//String nomChamp = item.getFieldName();
					String nameFile = FilenameUtils.getName(item.getName());
					if(nameFile != null && !nameFile.isEmpty()){
						nameFile = nameFile.substring(nameFile.lastIndexOf('/')+1).substring( nameFile.lastIndexOf('\\')+1);
						if (nameFile.lastIndexOf(".") > 0) {
						    String ext = nameFile.substring(nameFile.lastIndexOf("."));
						    if (ext.equals(".png") || ext.equals(".jpeg") || ext.equals(".jpg")) {
						    	InputStream file = item.getInputStream();
						    	String newNamePicture= seller.getEmail()+new Date().toString()+numPicture+ext;
						    	
								writeFile(file,newNamePicture,pathSaveFile);
								announce.addPhoto(newNamePicture);
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
				announceDAO.create(announce);
				
				seller.addMyAnnounce(announce);
				userDAO.create(seller);
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		String path = request.getContextPath();
		response.sendRedirect(path +"/MyAnnounces");
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
