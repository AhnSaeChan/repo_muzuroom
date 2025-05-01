package com.a6.module.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController {
	@Autowired
	ContentService contentService;
	
	@RequestMapping(value = "/ContentXdmList")
	
	public String ContentXdmList(ContentVo vo, Model model) {
		
		model.addAttribute("list",contentService.selectList(vo));
		model.addAttribute("vo", vo);
		return "/xdm/content/ContentXdmList";
	}
	
	@RequestMapping(value = "/xdm/content/ContentXdmView")
	public String ContentXdmView(Model model, ContentVo contentvo) {
		
		
		model.addAttribute("item",contentService.selectOne(contentvo));

		return "xdm/content/ContentXdmView";
	}
	
	@RequestMapping(value = "/usr/product/usrProductItem")
	
	public String usrProductItem() {
		
		
//		model.addAttribute("item",contentService.selectOne(contentvo));

		return "usr/product/usrProductItem";
	}
	
	@RequestMapping(value = "/usrProductList")
	
		public String usrProductList() {
		
		


		return "/usr/product/usrProductList";
		
	}
	
	@RequestMapping(value = "/usrProductCheckout")
	
	public String usrProductCheckout() {
	
	


	return "/usr/product/usrProductCheckout";
	
	
}
	
	

    @RequestMapping("/content/upload")
    public String contentUpload(ContentDto contentDto) throws Exception {
        contentService.insert(contentDto);
        return "redirect:/usr/product/usrProductItem";
    }
}
