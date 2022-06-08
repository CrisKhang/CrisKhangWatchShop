package edu.poly.site.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import edu.poly.common.SessionUtils;
import edu.poly.dao.FavoriteDao;
import edu.poly.model.Favorite;
import edu.poly.model.User;
import edu.poly.model.Video;

/**
 * Servlet implementation class LikeVideoServlet
 */
@WebServlet("/LikeVideo")
public class LikeVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		if(!SessionUtils.isLogin(req)) {
			resp.sendRedirect("LoginServlet");
			return;
		}
		String page  = req.getParameter("page");
		String videoId = req.getParameter("videoId");
		
		if(videoId == null) {
			resp.sendRedirect("Homepage");
			return;
		}
		try {
			FavoriteDao dao = new FavoriteDao();
			Favorite favorite = new Favorite();
			Video video = new Video();
			video.setVideoId(videoId);
			favorite.setVideo(video);
			
			String username = SessionUtils.getLoginedUsername(req);
			User user = new User();
			user.setUsername(username);
			favorite.setUser(user);
			
			favorite.setLikedDate(new Date());
			
			dao.insert(favorite);
			
			req.setAttribute("message", "Video is added to Favorite");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		
		if(page == null) {
			page = "/Homepage";
		}
		req.getRequestDispatcher(page).forward(req, resp);
		
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
