package com.example.abbs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abbs.dao.AnniversaryDao;
import com.example.abbs.dao.ScheduleDao;
import com.example.abbs.entity.Anniversary;
import com.example.abbs.entity.SchDay;
import com.example.abbs.entity.Schedule;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	@Autowired private ScheduleDao schedDao;
	@Autowired private AnniversaryDao annivDao;

	@Override
	public Schedule getSchedule(int sid) {
		// TODO Auto-generated method stub
		return schedDao.getSchedule(sid);
	}

	@Override
	public List<Schedule> getSchedList(String uid, String startDay, String endDay) {
		// TODO Auto-generated method stub
		return schedDao.getSchedList(uid, startDay, endDay);
	}

	@Override
	public List<Schedule> getSchedListByDay(String uid, String sdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		schedDao.insertSchedule(schedule);
	}

	@Override
	public void updateSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		schedDao.updateSchedule(schedule);
	}

	@Override
	public void deleteSchedule(int sid) {
		// TODO Auto-generated method stub
		schedDao.deleteSchedule(sid);
	}

	@Override
	public SchDay generateSchDay(String uid, int day, String sdate, int date, int isOtherMonth) {
		// TODO Auto-generated method stub
		List<Anniversary> annivList = annivDao.getAnnivLIst(uid, sdate, sdate);
		List<Schedule> schedList = schedDao.getSchedList(uid, sdate, sdate);
		// 기념일 정보를 통해 가져옴 (isHoliday)
// !!!		int isHoliday ???? /// 이거 해야됨 !!!
		int isHoliday = 0;
		List<String> aList = new ArrayList<>();
		for (Anniversary anniv: annivList) {
			aList.add(anniv.getAname());
			if (isHoliday == 0)
				isHoliday = anniv.getIsHoliday();
		}
		SchDay schDay = new SchDay(day, date, isHoliday, isOtherMonth, sdate, aList, schedList);
		return schDay;
	}

}
