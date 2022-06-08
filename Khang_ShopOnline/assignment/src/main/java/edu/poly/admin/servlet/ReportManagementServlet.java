package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.FavoriteDao;
import edu.poly.dao.VideoDao;
import edu.poly.domain.FavoriteReport;
import edu.poly.domain.FavoriteUserReport;
import edu.poly.model.Video;

/**
 * Servlet implementation class ReportManagementServlet
 */
@WebServlet("/ReportManagementServlet")
public class ReportManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		reportFavoritesByVideos(req, resp);
		reportFavoriteUsersByVideo(req, resp);
		PageInfo.prepareAndForward(req, resp, PageType.REPORT_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	protected void reportFavoriteUsersByVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String videoUserId = req.getParameter("videoUserId");
			
			VideoDao vdao = new VideoDao();
			List<Video> vList = vdao.findAll();
			
			if(videoUserId == null && vList.size()>0) {
				videoUserId = vList.get(0).getVideoId();
			}
			
			FavoriteDao dao = new FavoriteDao();
			
			List<FavoriteUserReport> list = dao.reportFavoriteUsersByVideo(videoUserId);
			
			req.setAttribute("videoUserId", videoUserId);
			req.setAttribute("vidList", vList);
			req.setAttribute("favUsers", list);
		} catch (Exception e) {
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}
    protected void reportFavoritesByVideos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			FavoriteDao dao = new FavoriteDao();
			List<FavoriteReport> list = dao.reportFavoritesByVideos();
			
			req.setAttribute("favList", list);
		} catch (Exception e) {
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}
}
