package edu.poly.services;

import java.util.List;


import edu.poly.dao.FavoriteDao;
import edu.poly.model.Favorite;
import edu.poly.model.Video;

public class FavoriteService {

	FavoriteDao favoriteDAO = new FavoriteDao();
	
	public void like(Favorite favorite) {
		favoriteDAO.insert(favorite);
	}
	
	public void unlike(Favorite favorite) {
		favoriteDAO.delete(favorite);
	}
	
	public List<Video> findAllByUserId(String user){
		return favoriteDAO.findAllByUsername(user);
	}
	
	
}
