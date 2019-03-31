package come.examples.java.core;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;

public class SessionListener implements ServletContextListener {
	public static int currentUserCount=0;
	public static int totalUsers=0;
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext context=se.getSession().getServletContext();
		context.setAttribute("currentUser", currentUserCount++);
	}
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext context=se.getSession().getServletContext();
		int cuurentUsers=Integer.parseInt((String)context.getAttribute("currentUser"));
		context.setAttribute("cuurentUsers", cuurentUsers--);
	}
}
