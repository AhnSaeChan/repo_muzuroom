package com.a6.module.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	
	public String usrProductItem(ContentVo vo, Model model) {
		
		
		model.addAttribute("item",contentService.selectOne(vo));

		return "usr/product/usrProductItem";
	}
	
	@RequestMapping(value = "/usrProductList")
	
		public String usrProductList(ContentVo vo, Model model) {
		
		model.addAttribute("list",contentService.selectList(vo));
		model.addAttribute("vo", vo);
		

		return "usr/product/usrProductList";
		
	}
	
	@RequestMapping(value = "/usrProductCheckout")
	
	public String usrProductCheckout() {
	
	


	return "usr/product/usrProductCheckout";
	
	
}
	
	

//    @RequestMapping("/content/upload")
//    public String contentUpload(ContentDto contentDto) throws Exception {
//        contentService.insert(contentDto);
//        return "redirect:/usr/product/usrProductItem";
//    }
    
	@RequestMapping("/content/upload")
	public String contentUpload(@ModelAttribute ContentDto contentDto,
	                            @RequestParam(value = "uploadImg1", required = false) MultipartFile[] uploadImg1) throws Exception {

	    if (uploadImg1 != null && uploadImg1.length > 0) {
	        contentDto.setUploadImg1(uploadImg1);
	    }

	    contentService.insert(contentDto); 

	    return "redirect:/ContentXdmList?seq=" + contentDto.getSeq();
	}
	
	


}
