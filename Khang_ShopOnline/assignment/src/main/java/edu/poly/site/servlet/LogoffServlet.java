package edu.poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.CookieUtils;
import edu.poly.common.SessionUtils;

/**
 * Servlet implementation class LogoffServlet
 */
@WebServlet("/LogoffServlet")
public class LogoffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CookieUtils.add("username", null, 0, resp);
		SessionUtils.invalidate(req);
		
		req.setAttribute("isLogin", false);
		req.getRequestDispatcher("/Homepage").forward(req, resp);
	}

}
