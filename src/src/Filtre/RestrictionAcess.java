package Filtre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/EditAnnnounce", "/FollowAnnounce","/MyAnnounces","/MyFavoritesAnnounces","/MySpace",
		"/NewAnnounce","/RemoveAnnounce","/UnFollowAnnounce","/Home"})
public class RestrictionAcess implements Filter {

    public void init( FilterConfig config ) throws ServletException {
    }

    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException,
            ServletException {
    	
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession();

        if ( session.getAttribute("sessionUser" ) == null ) {
            response.sendRedirect(request.getContextPath() + "/PublicHome");
        } else {
            chain.doFilter( request, response );
        }
    }

    public void destroy() {
    }
}