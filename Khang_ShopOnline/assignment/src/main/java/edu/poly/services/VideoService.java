package edu.poly.services;

import edu.poly.dao.VideoDao;
import edu.poly.model.Video;

public class VideoService {
	VideoDao videoDao = new VideoDao();
	
	public Video findOneById(String videoId) {
		return videoDao.findOneById(videoId);
	}
}
