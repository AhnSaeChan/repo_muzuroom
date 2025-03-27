package com.a6.module.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {
	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmList")
	public String CodeGroupXdmList(@ModelAttribute("vo") CodeGroupVo vo, Model model) {
	
		vo.setParamsPaging(codeGroupService.selectOneCount(vo));
		
//		int a = codeGroupService.selectOneCount();
//		model.addAttribute(vo);
		model.addAttribute("list",codeGroupService.selectList(vo));
		model.addAttribute("total",codeGroupService.listTotal(vo));
//		CodeGroupVo codeGroupVo = new CodeGroupVo();
//		codeGroupVo.setThisPage();
//		codeGroupVo.setRowNumToShow(20);
		
		
	
		 return "xdm/codegroup/CodeGroupXdmList";
	}
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmView")
	public String CodeGroupXdmView(Model model, CodeGroupVo vo) {
		model.addAttribute("item",codeGroupService.selectOne(vo));
		return "xdm/codegroup/CodeGroupXdmView";
	}
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmForm")
	public String CodeGroupXdmForm(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception {
		
		if (vo.getSeq().equals("0") || vo.getSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", codeGroupService.selectOne(vo));
			
		}
		
		return "xdm/codegroup/CodeGroupXdmForm";
	}
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmInst")
	public String CodeGroupXdmInst(CodeGroupDto codeGroupDto) {
		
		codeGroupService.insert(codeGroupDto);
		
		return "redirect:/xdm/codegroup/CodeGroupXdmList";
	}
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmUpdt")
	public String CodeGroupXdmUpdt(CodeGroupDto codeGroupDto) {
		
		codeGroupService.update(codeGroupDto);
		
		return "redirect:/xdm/codegroup/CodeGroupXdmList";
	}
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmDele")
	public String CodeGroupXdmDele(CodeGroupDto codeGroupDto) {
		
		codeGroupService.delete(codeGroupDto);
		
		return "redirect:/xdm/codegroup/CodeGroupXdmList";
	}
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmUele")
	public String CodeGroupXdmUele(CodeGroupDto codeGroupDto) {
		
		codeGroupService.uelete(codeGroupDto);
		
		return "redirect:/xdm/codegroup/CodeGroupXdmList";
	}	
}
