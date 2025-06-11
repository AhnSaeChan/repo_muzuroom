package com.a6.module.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	@Autowired
	ReservationDao reservationDao;
	
	public List<ReservationDto> selectList(ReservationDto reservationDto){
		return reservationDao.selectList(reservationDto);
		
	}
	
	public int selectOneCount(ReservationDto reservationDto) {
		return reservationDao.selectOneCount(reservationDto);
	}
	
	public int insert(ReservationDto Dto) {
		return reservationDao.insert(Dto);
	}
}
