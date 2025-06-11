package com.a6.module.reservation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a6.module.content.ContentDto;
import com.a6.module.content.ContentService;

import jakarta.servlet.http.HttpSession;



@Controller
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	ContentService contentService;
	
@RequestMapping(value = "/myOrderList")
	public String myOrderList(@ModelAttribute("vo") ReservationDto reservationDto, HttpSession session, Model model) {
		reservationDto.setParamsPaging(reservationService.selectOneCount(reservationDto));
		reservationDto.setUserinfo_seq((String)session.getAttribute("sessSeqUsr"));
		model.addAttribute("list",reservationService.selectList(reservationDto));
		
		return "usr/myaccount/myOrder";
		
	}

@ResponseBody
@RequestMapping(value = "/DetailedPageUser")
public Map<String, Object> DetailedPageUser(ReservationDto reservationDto, HttpSession session) throws Exception {
    Map<String, Object> returnMap = new HashMap<>();

    
    String rtt = reservationDto.getSeq();
    Date checkInDate = reservationDto.getReservDate();
    
    int totalPrice = 0;
    int reservTime = reservationDto.getReservTime();
	int pricePerHour = 0;
	 if (reservationDto.getRoomInfo() != null && reservationDto.getRoomInfo().getPricePerHour() != null) {
	     pricePerHour = reservationDto.getRoomInfo().getPricePerHour(); // 예: 6000
	 }

	 totalPrice = reservTime * pricePerHour;
	 reservationDto.setTotalPrice(totalPrice);

	 session.setAttribute("reservationData", reservationDto);

	 returnMap.put("result", rtt);
    return returnMap;
	}

@RequestMapping(value="/PayUserForm")
public String PayUserForm(HttpSession session, Model model,ContentDto contentDto) {
    
	ReservationDto reservationData = (ReservationDto) session.getAttribute("reservationData");
	ContentDto stayInfoData = (ContentDto) session.getAttribute("stayInfoData");
    
    String orderId ="order-" + UUID.randomUUID();
    
    model.addAttribute("reservationData", reservationData);
    model.addAttribute("stayInfoData", stayInfoData);
    model.addAttribute("item", contentService.selectOne(contentDto));
    model.addAttribute("orderId", orderId);
    return "usr/product/usrProductCheckout"; 
 	}




	
}
