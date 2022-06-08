package edu.poly.dao;


import javax.persistence.EntityManager;

import edu.poly.model.Video;

public class VideoDao extends AbstractEntityDao<Video> {

	public VideoDao() {
		super(Video.class);
	}
	public Video findOneById(String videoId) {
		EntityManager em = JpaUtils.getEntityManager();
		em.clear();
		try {
			Video video = em.find(Video.class, videoId);
			return video;
		} catch (Exception e) {
			return null;
		}
	}

}
