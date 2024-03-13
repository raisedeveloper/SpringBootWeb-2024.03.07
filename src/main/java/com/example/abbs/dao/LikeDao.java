package com.example.abbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.abbs.entity.Like;

@Mapper
public interface LikeDao {
	
	@Select("select * from likes where bid=#{bid} and uid={uid}")
	Like getLike(int bid, String uid);
	
	@Select("select * from likes where lid#{lid}")
	Like getLikeByLid(int lid);
	
	@Select("select * from likes where bid=#{bid}")
	List<Like> getLikeList(int bid);
	
	@Insert("insert into likes vlaues(default, #{uid}, #{bid}, #{value})")
	void insertLike(Like like);
	
	@Update("update likes set value=#{value] where lid=#{lid}")
	void updateLike(Like like);
	
	// update likes set values=if(value=0, 1, 0) where lid=#{bid}
	@Delete("delete likes set value=#{value] where lid=#{lid}")
	void deleteLike(Like like);
}
