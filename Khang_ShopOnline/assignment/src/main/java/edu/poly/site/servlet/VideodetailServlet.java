package edu.poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.model.Video;
import edu.poly.services.VideoService;

/**
 * Servlet implementation class VideodetailServlet
 */
@WebServlet("/VideodetailServlet")
public class VideodetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	VideoService vds = new VideoService();
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Video video = vds.findOneById(req.getParameter("videoId"));
		
		req.setAttribute("video", video);
		
		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_VIDEO_DETAIL_PAGE);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
