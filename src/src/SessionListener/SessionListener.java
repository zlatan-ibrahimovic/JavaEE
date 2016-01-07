package SessionListener;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import Entities.User;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("Destroy");
		
		HttpSession session = arg0.getSession();
		UsersConnected.remove((User) session.getAttribute("sessionUser"));
		UsersConnected.printConnected();
		
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		if(arg0.getName().equals("sessionUser")){
			UsersConnected.add((User) arg0.getValue());
			UsersConnected.printConnected();
		}
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
