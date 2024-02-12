package java.student.registration.filter;

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

import java.student.registration.model.User;

@WebFilter("/showUsers")
public class showUsersFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Check if the user is logged in and has the "admin" role
        HttpSession session = httpRequest.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if ("admin".equalsIgnoreCase(user.getRole())) {
                // User is admin, allow the request to proceed
                chain.doFilter(request, response);
            } else {
                // User is not admin, send an "Access Denied" response
                httpResponse.getWriter().write("Access Denied. You do not have permission to access this page.");
                httpResponse.setContentType("text/html");
                httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        } else {
            // User is not logged in, send an "Unauthorized Access" response
            httpResponse.getWriter().write("Unauthorized Access. Please login.");
            httpResponse.setContentType("text/html");
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }

}


