package com.example.abbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.abbs.dao.AnniversaryDao;
import com.example.abbs.entity.Anniversary;

public class AnniversaryServiceImpl implements AnniversaryService {
	// AnniversaryDao 를 가져오는 작업
	@Autowired private AnniversaryDao annivDao;

	@Override
	public List<Anniversary> getAnnivListByDay(String uid, String sdate) {
		return annivDao.getAnnivLIst(uid, uid, sdate);
	}

	@Override
	public List<Anniversary> getAnnivList(String uid, String startDay, String endDay) {
		return annivDao.getAnnivLIst(uid, startDay, endDay);
	}

	@Override
	public void insertAnniv(Anniversary anniv) {	
		annivDao.insertAnniv(anniv);
	}
}
// If you want to use Oracle, change Impl as fit it.