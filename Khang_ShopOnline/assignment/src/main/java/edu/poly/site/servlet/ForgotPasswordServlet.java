package edu.poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.EmailUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.UserDao;
import edu.poly.domain.Email;
import edu.poly.model.User;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_FORGOT_PASSWORD_PAGE);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String emailAddress = req.getParameter("email");
			String username = req.getParameter("username");
			
			UserDao dao = new UserDao();
			User user = dao.findByUsernameAndEmail(username, emailAddress);
			
			if (user == null) {
				req.setAttribute("error", "Username or email are incorrect");
			}else {
				Email email = new Email();
				email.setFrom("khangtgps15054@fpt.edu.vn");
				email.setFromPassword("0337429181ka.");
				email.setTo(emailAddress);
				email.setSubbjet("Forgot Password Function");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear").append(username).append("<br>");
				sb.append("You are used the forgot password function. <br> ");
				sb.append("Your password is <b> ").append(user.getPassword()).append("</b>");
				sb.append("Regards<br>");
				sb.append("Administrator");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				
				req.setAttribute("message", "Email sent to the email Address. "
						+ "Please check and get your password");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_FORGOT_PASSWORD_PAGE);
	}

}
