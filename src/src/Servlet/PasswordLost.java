package Servlet;

import java.io.IOException;
import java.util.Properties;

import javax.ejb.EJB;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.IUserDAO;
import Entities.User;

@WebServlet("/PasswordLost")
public class PasswordLost extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private IUserDAO userDAO;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/PasswordLost.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		User user = userDAO.find(email);
		
		if( user == null){
			request.setAttribute("error", "No account linked to this address");
			this.getServletContext().getRequestDispatcher("/WEB-INF/PasswordLost.jsp").forward(request, response);
			return ;
		}
		
		String subject = "Votre demande de code d'accès a été acceptée.";
		String msg = "Bonjour, \n"
				+ "Voici le code confidentiels qui vous permettera d'accéder, dès à présent, à votre espace adhérents : \n"
				+ "Mot de passe :" + user.getPassword() + "\n"
				+ "Nous vous conseillons de conserver ce code, ils vous sera demandé à chaque visite sur votre espace sécurisé. \n"
				+ "Important : lorsque vous saisissez vos codes, attention de bien respecter les majuscules/minuscules et de ne pas laisser d'espace avant/après après le mot de passe. \n"
				+ "A bientôt ";
		
	    final String from = "robot.projetalda@gmail.com";
	    String to = user.getEmail();
	    final String password = "projetalda";
	 
	    Properties props = new Properties();
	    props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.debug", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		
	    try {
	    	
	    Transport transport = session.getTransport();
		InternetAddress addressFrom = new InternetAddress(from);

		MimeMessage message = new MimeMessage(session);
		message.setSender(addressFrom);
		message.setSubject(subject);
		message.setContent(msg, "text/plain");
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		transport.connect();
		Transport.send(message);
		transport.close();
		
		request.setAttribute("error", "An email was sent to this address \""+user.getEmail()+"\" with your password");
		
		} catch (Exception e) {}
	    
	    this.getServletContext().getRequestDispatcher("/WEB-INF/PasswordLost.jsp").forward(request, response);
	}

}
