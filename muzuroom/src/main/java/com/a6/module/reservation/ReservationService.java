package com.a6.module.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	@Autowired
	ReservationDao reservationDao;
	
	public List<ReservationDto> selectList(ReservationVo reservationVo){
		return reservationDao.selectList(reservationVo);
		
	}
}
