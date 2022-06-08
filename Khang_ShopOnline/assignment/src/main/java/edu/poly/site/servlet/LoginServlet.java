package edu.poly.site.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.CookieUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.UserDao;
import edu.poly.domain.LoginForm;
import edu.poly.model.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		 String username = CookieUtils.get("username", req);
		 
		  if(username == null) { 
			 PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_LOGIN_PAGE); 
			 return; 
		  }
		 SessionUtils.add(req, "username", username); 
		/* PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_HOME_PAGE); */
		req.getRequestDispatcher("Homepage").forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			LoginForm form = new LoginForm();
			
			BeanUtils.populate(form, req.getParameterMap());
			
			UserDao dao = new UserDao();
			
			User user = dao.findById(form.getUsername());
			
			if(user!= null && user.getPassword().equals(form.getPassword())) {
				SessionUtils.add(req, "username", user.getUsername());
				
				if(form.isRemember()) {
					CookieUtils.add("username", form.getUsername(), 24, resp);
				}else {
					CookieUtils.add("username", form.getUsername(), 0, resp);
				}	
				req.setAttribute("isLogin", true);
				req.setAttribute("name", user.getFullname());
				if(!user.isAdmin()) {
					req.getRequestDispatcher("/Homepage").forward(req, resp);
				}
				else {
					this.createSession(req, user);
					resp.sendRedirect("http://localhost:8080/Admin/VideosManagement");
					 req.getRequestDispatcher("/Admin/VideosManagement").forward(req, resp); 
					PageInfo.prepareAndForward(req, resp, PageType.VIDEO_MANAGEMENT_PAGE);
				}
				return;
			}
			req.setAttribute("error", "invalid username or password");
			PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_LOGIN_PAGE);
		} catch (Exception e) {
			req.setAttribute("error", e.getMessage());
		}
	}
	
	private void createSession (HttpServletRequest req, User user) {
		HttpSession session = req.getSession();
		session.setAttribute("userSession", user);
	}

}
