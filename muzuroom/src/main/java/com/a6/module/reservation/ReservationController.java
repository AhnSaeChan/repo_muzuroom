package com.a6.module.reservation;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.a6.module.content.ContentDto;
import com.a6.module.content.ContentService;
import com.a6.module.userinfo.UserInfoDto;

import jakarta.servlet.http.HttpServletRequest;
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

    // 세션에서 사용자 정보 가져오기
    String userSeq = (String) session.getAttribute("sessSeqUsr");
    if (userSeq == null) {
        returnMap.put("error", "로그인이 필요합니다.");
        return returnMap;
    }

    UserInfoDto sessionUser = new UserInfoDto();
    sessionUser.setSeq(userSeq);
    reservationDto.setUserinfo_seq(userSeq);

    // room_seq를 이용해서 가격 정보 조회
    if (reservationDto.getRoom_seq() != null) {
        ContentDto room = new ContentDto();
        room.setSeq(reservationDto.getRoom_seq());

        ContentDto fullRoom = contentService.selectOne(room);
        if (fullRoom != null && fullRoom.getPricePerHour() != null) {
            int pricePerHour = fullRoom.getPricePerHour();
            int totalPrice = reservationDto.getReservTime() * pricePerHour;
            reservationDto.setTotalPrice(totalPrice);

            reservationDto.setRoomInfo(fullRoom); // 필요한 경우를 대비해 roomInfo도 설정
        } else {
            reservationDto.setTotalPrice(0);
        }
    } else {
        reservationDto.setTotalPrice(0);
    }

    // UUID로 예약 번호 생성
    reservationDto.setSeq(UUID.randomUUID().toString());

    // DB 저장
//    reservationService.insert(reservationDto);

    // 세션에 저장
    session.setAttribute("reservationData", reservationDto);

    returnMap.put("result", reservationDto.getStaySeq());
    return returnMap;
}



@RequestMapping(value = "/PayUserForm")
public String PayUserForm(HttpServletRequest request, Model model) {

    HttpSession session = request.getSession();
    String userSeq = (String) session.getAttribute("sessSeqUsr");

    if (userSeq == null) {
        return "redirect:/login";
    }

    UserInfoDto sessionUser = new UserInfoDto();
    sessionUser.setSeq(userSeq);

    ReservationDto reservationData = (ReservationDto) session.getAttribute("reservationData");

    if (reservationData != null) {
        reservationData.setUserinfo_seq(sessionUser.getSeq());
        model.addAttribute("reservationData", reservationData);
        model.addAttribute("orderId", reservationData.getSeq()); // ✅ 추가됨

        // room_seq로 ContentDto 조회
        ContentDto contentDto = new ContentDto();
        contentDto.setSeq(reservationData.getRoom_seq());
        ContentDto item = contentService.selectOne(contentDto);

        if (item != null) {
            model.addAttribute("item", item);
        } else {
            model.addAttribute("item", new ContentDto());
        }
    } else {
        return "redirect:/";
    }

    return "usr/product/usrProductCheckout";
}

@RequestMapping(value = "/successPayments")
public String successPayments(
        @RequestParam("orderId") String orderId,
        @RequestParam("paymentKey") String paymentKey,
        @RequestParam("amount") int amount,
        HttpSession session,
        Model model) {

    // 1. Toss 결제 승인 요청
    RestTemplate restTemplate = new RestTemplate();
    String secretKey = "test_gsk_docs_OaPz8L5KdmQXkzRz3y47BMw6";
    String encodedKey = Base64.getEncoder().encodeToString((secretKey + ":").getBytes(StandardCharsets.UTF_8));

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("Authorization", "Basic " + encodedKey);

    Map<String, Object> body = new HashMap<>();
    body.put("orderId", orderId);
    body.put("amount", amount);
    body.put("paymentKey", paymentKey);

    HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

    ResponseEntity<String> response = restTemplate.postForEntity(
            "https://api.tosspayments.com/v1/payments/confirm",
            request,
            String.class
    );

    // 2. 세션에서 예약 정보 꺼내기
    ReservationDto reservationData = (ReservationDto) session.getAttribute("reservationData");

    if (reservationData != null) {
        reservationData.setReservStat(1); // 결제완료 상태로 설정 (예: 1 = 완료)
        reservationData.setPaymentKey(paymentKey); // 필요 시 저장

        reservationService.insert(reservationData); // DB 저장
        session.removeAttribute("reservationData"); // 세션 정리
    } else {
        // 예외 처리: 예약 정보가 세션에 없을 경우
        model.addAttribute("error", "세션이 만료되어 예약 정보를 저장할 수 없습니다.");
        return "usr/product/paymentFail";
    }

    return "redirect:/myOrderList";
}


@RequestMapping(value="/failPayments")
public void failPayments( 
		@RequestParam("code") String code,
	    @RequestParam("message") String message) {
	System.out.println("code: "+code);
	System.out.println("message: "+message);
	
}







	
}
