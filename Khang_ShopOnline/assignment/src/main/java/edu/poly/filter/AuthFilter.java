package edu.poly.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import edu.poly.common.SessionUtils;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {

   
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		req.setAttribute("isLogin", SessionUtils.isLogin((HttpServletRequest) req));
		
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
