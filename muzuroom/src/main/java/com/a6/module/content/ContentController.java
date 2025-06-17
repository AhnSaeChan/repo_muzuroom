package com.a6.module.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
public class ContentController {
	@Autowired
	ContentService contentService;
	
	@RequestMapping(value = "/ContentXdmList")
	
	public String ContentXdmList(ContentVo vo, Model model) {
		vo.setParamsPaging(contentService.selectOneCount(vo));
		model.addAttribute("list",contentService.selectList(vo));
		model.addAttribute("vo", vo);
		return "xdm/content/ContentXdmList";
	}
	
	@RequestMapping(value = "/xdm/content/ContentXdmView")
	public String ContentXdmView(@ModelAttribute("vo") ContentVo vo, Model model)throws Exception {
		
		if (vo.getSeq().equals("0") || vo.getSeq().equals("")) {
//			insert mode
		} else {
//			update mode
		model.addAttribute("item",contentService.selectOne(vo));
		
		}
		return "xdm/content/ContentXdmView";
	}
		
	
	@RequestMapping(value = "/usr/product/usrProductItem")
	
	public String usrProductItem(@ModelAttribute("vo") ContentVo vo, ContentDto contentDto, Model model) {
		
		 List<ContentDto> reviewList = contentService.reviewList(vo);
		 int totalReviews = reviewList.size();
		 
		 int[] ratingCounts = new int[5]; // 별점 1 ~ 5의 개수
		    for (ContentDto review : reviewList) {
		        int starScore = review.getStarScore();
		        if (starScore >= 1 && starScore <= 5) {
		            ratingCounts[starScore - 1]++;
		        }
		    }
		 
		    double[] ratingPercentages = new double[5];
		    for (int i = 0; i < 5; i++) {
		        ratingPercentages[i] = (totalReviews > 0) ? (double) ratingCounts[i] / totalReviews * 100 : 0.0;
		    }
		    
		    double averageRating = 0.0;
		    if (totalReviews > 0) {
		        double totalRating = 0.0;
		        for (ContentDto review : reviewList) {
		            totalRating += review.getStarScore(); // 각 리뷰의 별점 점수를 더함
		        }
		        averageRating = totalRating / totalReviews; // 평균 별점 계산
		    }
		    
		 ContentDto item = contentService.selectOne(vo);

		    if (item != null) {
		        
		        if (item.getRoomIntro() != null) {
		            item.setRoomIntro(item.getRoomIntro().replaceAll("(\r\n|\n)", "<br>"));
		        }

		        if (item.getRoomGuideline() != null) {
		            item.setRoomGuideline(item.getRoomGuideline().replaceAll("(\r\n|\n)", "<br>"));
		        }

		        if (item.getRoomDetail() != null) {
		            item.setRoomDetail(item.getRoomDetail().replaceAll("(\r\n|\n)", "<br>"));
		        }
		    }
		    model.addAttribute("averageRating", averageRating);
		    model.addAttribute("ratingPercentages", ratingPercentages);
		    model.addAttribute("reviewList", reviewList);
		    model.addAttribute("item", item);
		    
//		model.addAttribute("item",contentService.selectOne(vo));

		return "usr/product/usrProductItem";
	}
	
	@RequestMapping(value = "/usrProductList")
	
		public String usrProductList(ContentVo vo, Model model) {
		vo.setParamsPaging(contentService.selectOneCount(vo));
		model.addAttribute("list",contentService.selectList(vo));
		model.addAttribute("vo", vo);
		

		return "usr/product/usrProductList";
		
	}
	
//	@RequestMapping(value = "/usrProductCheckout")
//	
//	public String usrProductCheckout() {
//	
//	
//
//
//	return "usr/product/usrProductCheckout";
//	
//	
//}
	
	

//    @RequestMapping("/content/upload")
//    public String contentUpload(ContentDto contentDto) throws Exception {
//        contentService.insert(contentDto);
//        return "redirect:/usr/product/usrProductItem";
//    }
    
	@RequestMapping("/content/upload")
	public String contentUpload(@ModelAttribute ContentDto contentDto, HttpSession httpSession,
	                            @RequestParam(value = "uploadImg1", required = false) MultipartFile[] uploadImg1) throws Exception {

	    if (uploadImg1 != null && uploadImg1.length > 0) {
	        contentDto.setUploadImg1(uploadImg1);
	    }
	    contentDto.setUserInfo_seq((String) httpSession.getAttribute("sessSeqXdm"));
	    contentService.insert(contentDto); 

	    return "redirect:/ContentXdmList?seq=" + contentDto.getSeq();
	}
	
	@ResponseBody
	@RequestMapping("/reviewStats")
	public Map<String, Object> reviewStats(@RequestParam("seq") String seq, ContentVo vo) {
	    Map<String, Object> result = new HashMap<>();

	    List<ContentDto> reviewList = contentService.reviewList(vo);
	    int totalReviews = reviewList.size();

	    int[] ratingCounts = new int[5];
	    for (ContentDto review : reviewList) {
	        int star = review.getStarScore();
	        if (star >= 1 && star <= 5) ratingCounts[star - 1]++;
	    }

	    double[] ratingPercentages = new double[5];
	    for (int i = 0; i < 5; i++) {
	        ratingPercentages[i] = (totalReviews > 0) ? (double) ratingCounts[i] / totalReviews * 100 : 0.0;
	    }

	    double averageRating = 0.0;
	    if (totalReviews > 0) {
	        int sum = 0;
	        for (ContentDto r : reviewList) sum += r.getStarScore();
	        averageRating = (double) sum / totalReviews;
	    }
	    

	    result.put("reviewList", reviewList);
	    result.put("ratingPercentages", ratingPercentages);
	    result.put("averageRating", averageRating);

	    return result;
	}



	
	


}
