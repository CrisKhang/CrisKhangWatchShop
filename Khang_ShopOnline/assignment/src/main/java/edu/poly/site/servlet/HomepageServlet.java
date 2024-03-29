package edu.poly.site.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.VideoDao;
import edu.poly.model.Video;


@WebServlet("/Homepage")
public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {  
		String username = SessionUtils.getLoginedUsername(req);
		if(username == null) {
			req.setAttribute("isLogin", false);
		}
		else {
			req.setAttribute("isLogin", true);
		}
		try {
			VideoDao dao = new VideoDao();
			List<Video> list = dao.findAll();
			req.setAttribute("videos", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_HOME_PAGE);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
