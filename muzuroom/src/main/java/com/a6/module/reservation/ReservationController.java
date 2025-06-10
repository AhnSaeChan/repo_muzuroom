package com.a6.module.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
@RequestMapping(value = "/myOrderList")
	public String myOrderList(ReservationVo vo, Model model) {
//		vo.setParamsPaging(reservationService.selectOneCount(vo));
		model.addAttribute("list",reservationService.selectList(vo));
		model.addAttribute("vo", vo);
		return "usr/myaccount/myOrder";
		
	}
}
