package com.example.abbs.service;

import java.util.List;

import com.example.abbs.entity.Like;

public interface LikeService {
	
	Like getLike(int bid, String uid);
	
	Like getlikeByLid(int lid);
	
	List<Like> getLikeList(int bid);
	
	void insertlike(Like like);
	
	void togleLike(Like like);		// value 가 0 이면 1로 바꾸고, 1 이면 0 으로 바꿈
	
	int getLikeCount(int bid);

}
