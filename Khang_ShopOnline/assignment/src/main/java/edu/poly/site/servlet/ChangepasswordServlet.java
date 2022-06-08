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
import edu.poly.domain.ChangePasswordForm;


/**
 * Servlet implementation class ChangepasswordServlet
 */
@WebServlet("/ChangepasswordServlet")
public class ChangepasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = SessionUtils.getLoginedUsername(req);
		
		if( username == null) {
			req.getRequestDispatcher("LoginServlet").forward(req, resp);
			req.setAttribute("isLogin", false);
			return;
		}
		req.setAttribute("username", username);
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_CHANG_PASSWORD_PAGE);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String username = SessionUtils.getLoginedUsername(req);
			ChangePasswordForm form = new ChangePasswordForm();
			
			BeanUtils.populate(form, req.getParameterMap());
			req.setAttribute("username", username);
			
            if (!form.getConfirmPassword().equals(form.getPassword())) {
				req.setAttribute("error", "new password and new confirm password are not identical");
			}else {
				UserDao dao = new UserDao();
				dao.changePassword(form.getUsername(), form.getCurrentPassword(), form.getPassword());
				req.setAttribute("message", "Password has been changed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.setAttribute("isLogin", true);
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_CHANG_PASSWORD_PAGE);
	}

}
