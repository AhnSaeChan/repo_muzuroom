package com.a6.module.reservation;

import java.util.List;

import org.springframework.stereotype.Repository;



@Repository
public interface ReservationDao {
	public List<ReservationDto> selectList(ReservationVo reservationVo);
}
