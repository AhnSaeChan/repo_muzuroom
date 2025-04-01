package com.a6.module.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CodeController{
	@Autowired
	CodeService codeService;
	
	
	@RequestMapping(value = "/xdm/code/CodeXdmList")
	public String CodeXdmList(@ModelAttribute("vo") CodeVo vo, Model model)  {
		
		vo.setParamsPaging(codeService.selectOneCount(vo));
		
		model.addAttribute("list", codeService.selectList(vo));
		
		return "xdm/code/CodeXdmList";
	}
	@RequestMapping(value = "/xdm/code/CodeXdmView")
	public String CodeXdmView(Model model, CodeVo codeVo) {
		model.addAttribute("item",codeService.selectOne(codeVo));
		return "xdm/code/CodeXdmView";
	}
	@RequestMapping(value = "/xdm/code/CodeXdmForm")
	public String CodeXdmForm(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception{
		
		if (vo.getSeq().equals("0") || vo.getSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", codeService.selectOne(vo));
			
		}
		return "xdm/code/CodeXdmForm";
	}
	@RequestMapping(value = "/xdm/code/CodeXdmInst")
	public String CodeXdmInst(CodeDto codeDto) {
		
		codeService.insert(codeDto);
		
		return "redirect:/xdm/code/CodeXdmList";
	}
	
	@RequestMapping(value = "/xdm/code/CodeXdmUpdt")
	public String CodeXdmUpdt(CodeDto codeDto) {
		
		codeService.update(codeDto);
		
		return "redirect:/xdm/code/CodeXdmList";
	}
	
	@RequestMapping(value = "/xdm/code/CodeXdmDele")
	public String CodeXdmDele(CodeDto codeDto) {
		
		codeService.delete(codeDto);
		
		return "redirect:/xdm/code/CodeXdmList";
	}
	
	@RequestMapping(value = "/xdm/code/CodeXdmUele")
	public String CodeXdmUele(CodeDto codeDto) {
		
		codeService.uelete(codeDto);
		
		return "redirect:/xdm/code/CodeXdmList";
	}
	
	
	
}
