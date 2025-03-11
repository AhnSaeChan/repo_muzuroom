package com.a6.module.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {
	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmList")
	public String CodeGroupXdmList(Model model) {
		model.addAttribute("list",codeGroupService.selectList());
		return "xdm/codegroup/CodeGroupXdmList";
	}
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmView")
	public String CodeGroupXdmView(Model model, CodeGroupDto codeGroupDto) {
		model.addAttribute("item",codeGroupService.selectOne(codeGroupDto));
		return "xdm/codegroup/CodeGroupXdmView";
	}
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmForm")
	public String CodeGroupXdmForm() {
		
		return "xdm/codegroup/CodeGroupXdmForm";
	}
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmInst")
	public String emailaddressXdmInst(CodeGroupDto codeGroupDto) {
		
		codeGroupService.insert(codeGroupDto);
		
		return "redirect:/xdm/codegroup/CodeGroupXdmList";
	}
	
	
}
