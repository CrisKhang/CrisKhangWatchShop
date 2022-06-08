package edu.poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.UserDao;
import edu.poly.model.User;

/**
 * Servlet implementation class EditprofileServlet
 */
@WebServlet("/EditprofileServlet")
public class EditprofileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String username = SessionUtils.getLoginedUsername(req);
		if(username == null) {
			req.getRequestDispatcher("/LoginServlet").forward(req, resp);
			req.setAttribute("isLogin", false);
			return;
		}
		try {
			UserDao dao = new UserDao();
			User user = dao.findById(username);
			
			req.setAttribute("user", user);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_EDIT_PROFILE_PAGE);
		req.setAttribute("isLogin", true);
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user, req.getParameterMap());
			String username = SessionUtils.getLoginedUsername(req);
			
			UserDao dao = new UserDao();
			User oldUser = dao.findById(username);
			
			user.setAdmin(oldUser.isAdmin());
			dao.update(user);
			req.setAttribute("Message", "User profile updated!!!");
			req.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.setAttribute("isLogin", true);
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_EDIT_PROFILE_PAGE);
	}

}
