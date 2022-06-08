package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.common.UploadUtils;
import edu.poly.dao.UserDao;
import edu.poly.dao.VideoDao;
import edu.poly.model.User;
import edu.poly.model.Video;


@WebServlet({ "/UserManagementServlet", "/UserManagementServlet/create", "/UserManagementServlet/update",
	"/UserManagementServlet/delete", "/UserManagementServlet/reset", "/UserManagementServlet/edit",})
public class UsersManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao usDao = new UserDao();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		findAll(req, resp);
		String username = SessionUtils.getLoginedUsername(req);
		if(username == null) {
			req.setAttribute("isLogin", false);
		}
		else {
			req.setAttribute("isLogin", true);
		}
		String url = req.getRequestURL().toString();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		if(url.contains("edit")) {
			edit(req, resp);
			return;
		}
		if(url.contains("delete")) {
			delete(req, resp);
			return;
		}
		if(url.contains("reset")) {
			reset(req, resp);
			return;
		}
		
		

		PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
	}
	
	private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		
		req.setAttribute("user", user);
		findAll(req, resp);
		PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

        String id = req.getParameter("username");
		
		if (id == null) {
			req.setAttribute("error", "User id is required!");
			PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
			return;
		}
		try {
			
			UserDao dao = new UserDao();
			User user = dao.findById(id);
			
			if (user == null) {
				req.setAttribute("error", "User id not found!");
				PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
				return;
			}
			
			dao.delete(id);
			req.setAttribute("message", "user is deleted!");
			
			req.setAttribute("user", new User());
			findAll(req, resp);
			
			
		} catch (Exception e) {
			e.getStackTrace();
			
			req.setAttribute("error", "Error: "+ e.getMessage());
		}
		PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("username");
		
		if (id == null) {
			req.setAttribute("error", "Video id is required!");
			PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
			return;
		}
		try {
			
			UserDao dao = new UserDao();
			User user = dao.findById(id);
			
			req.setAttribute("user", user);
			findAll(req, resp);
			
			
		} catch (Exception e) {
			e.getStackTrace();
			
			req.setAttribute("error", "Error: "+ e.getMessage());
		}
		PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
	}
	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		
        try {
        	
			UserDao dao = new UserDao();
			
			List<User> list = dao.findAll();
			
			req.setAttribute("listUser", list);
		} catch (Exception e) {
			e.getStackTrace();
			
			req.setAttribute("error", "Error: "+ e.getMessage());
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = SessionUtils.getLoginedUsername(req);
		if(username == null) {
			req.setAttribute("isLogin", false);
		}
		else {
			req.setAttribute("isLogin", true);
		}
		String url = req.getRequestURL().toString();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		if(url.contains("create")) {
			create(req, resp);
			return;
		}
		if(url.contains("delete")) {
			delete(req, resp);
			return;
		}
		if(url.contains("update")) {
			update(req, resp);
			return;
		}
		if(url.contains("reset")) {
			reset(req, resp);
			return;
		}
		
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		
        try {
			BeanUtils.populate(user, req.getParameterMap());
        	
			UserDao dao = new UserDao();
			User oldUser = dao.findById(user.getUsername());
			
			
			
			dao.update(user);
			
			req.setAttribute("user", user);
			req.setAttribute("message", "User is update!");
			
			findAll(req, resp);
		} catch (Exception e) {
			e.getStackTrace();
			
			req.setAttribute("error", "Error: "+ e.getMessage());
		}
        PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
	}

	private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		try {
			BeanUtils.populate(user, req.getParameterMap());
						
			UserDao dao = new UserDao();
			dao.insert(user);
			
			req.setAttribute("user", user);
			req.setAttribute("message", "User is inserted! " );
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
		findAll(req, resp);
        PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
	}
		
	

}
