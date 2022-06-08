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
import edu.poly.dao.FavoriteDao;
import edu.poly.model.Favorite;
import edu.poly.model.Video;
import edu.poly.services.FavoriteService;

/**
 * Servlet implementation class FavoriteServlet
 */
@WebServlet("/FavoriteServlet")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 /*String username = SessionUtils.getLoginedUsername(req);*/
			FavoriteService fvs = new FavoriteService();
		
			if(!SessionUtils.isLogin(req)) {
				resp.sendRedirect("LoginServlet");
				return;
			}
			else {
				try {
					String username = SessionUtils.getLoginedUsername(req);
				/* User user = new User(); */
					
					
					List<Video> list = fvs.findAllByUserId(username);
					System.out.print(username);
					req.setAttribute("listFavoriteVideo", list);
				/* req.setAttribute("user", user); */
					
					PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_FAVORITE_PAGE);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
		}
		}	
	

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
