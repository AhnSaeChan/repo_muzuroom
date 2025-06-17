package com.a6.module.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	
	
	@RequestMapping(value="/WrittenReviewUser")
	public String MyReservationsUser(ReviewDto reviewDto, HttpSession session, Model model) {
		
		String memSeqStr = (String) session.getAttribute("sessSeqUsr");
		
    	int memSeq = Integer.parseInt(memSeqStr);
		
		reviewDto.setUserinfo_seq((String)session.getAttribute("sessSeqUsr"));
		List<ReviewDto> reviewList = reviewService.selectList(memSeq);
		model.addAttribute("reviewList", reviewList);
		
		return "usr/review/WrittenReviewUser";
	}
	
	@ResponseBody
	@RequestMapping(value = "/reviewUdate")
	public Map<String, Object> reviewUdate(ReviewDto reviewDto, HttpSession httpSession) throws Exception {
	    
	    Map<String, Object> returnMap = new HashMap<>();
	    
	    // 리뷰 저장
	    reviewService.insert(reviewDto);
	    
	    // 성공 메시지 추가
	    returnMap.put("status", "success");
	    
	    return returnMap;
	}
	
	
}
