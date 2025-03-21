package com.a6.module.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController {
	@Autowired
	ContentService contentService;
	
	@RequestMapping(value = "/xdm/content/ContentXdmList")
	public String ContentXdmList(ContentVo vo, Model model) {
		vo.setParamsPaging(contentService.selectOneCount(vo));
		
		model.addAttribute("list",contentService.selectList(vo));
		
		model.addAttribute("vo", vo);
		
		return "xdm/content/ContentXdmList";
	}
	
	@RequestMapping(value = "/xdm/content/ContentXdmView")
	public String ContentXdmView(ContentVo contentvo, Model model) {
		
		
		model.addAttribute("item",contentService.selectOne(contentvo));

		return "xdm/content/ContentXdmView";
	}
}
