package com.example.abbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.example.abbs.entity.Anniversary;

public interface AnniversaryDao {
	// ex> When whiteDay insert == insert into anniversary values(default, 'james, '화이트데이', '20240314', 0);
	@Select("select * from anniversary where (uid=#{uid} or uid='admin') and"
			+ " adate between #{startDay} and #{endDay} order by adate")
	
	List<Anniversary> getAnnivLIst(String uid, String startDay, String endDay);
	
	@Insert("insert into 	@Select(\"select * from anniversary where uid=#{uid} and\"\r\n"
			+ " values(default, #{uid}), ${aname}, #{adate}, #{isHoliday})")
	void insertAnniv(Anniversary anniv);
}
