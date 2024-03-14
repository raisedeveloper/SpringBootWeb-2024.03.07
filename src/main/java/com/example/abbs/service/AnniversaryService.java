package com.example.abbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.abbs.entity.Anniversary;

public interface AnniversaryService {
	/* List<Anniversary>
	 * // 특정한 사용자의 기념일을 뽑아옴 
	 * ex> GET james == admin, james 
	 * 특정한 날짜 또는 기간으로 가져옴 
	 */
	List<Anniversary> getAnnivListByDay(String uid, String sdate);
	
	List<Anniversary> getAnnivList(String uid, String startDay, String endDay); 
	
	void insertAnniv(Anniversary anniv);
	
}
