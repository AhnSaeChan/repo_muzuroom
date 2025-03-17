package com.a6.module.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CodeController {
	@Autowired
	CodeService codeService;
	
	@RequestMapping(value = "/xdm/code/CodeXdmList")
	public String codeGroupXdmList(CodeVo vo, Model model) {
		
		vo.setParamsPaging(codeService.selectOneCount(vo));
		
		model.addAttribute("list", codeService.selectList(vo));
		
		model.addAttribute("vo",vo);
		
		return "xdm/code/CodeXdmList";
	}
}
