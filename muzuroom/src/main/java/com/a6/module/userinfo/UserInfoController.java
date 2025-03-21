package com.a6.module.userinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class UserInfoController {
	@Autowired
	UserInfoService userInfoService;
	
	@RequestMapping(value = "/xdm/userinfo/UserInfoXdmList")
	public String UserInfoXdmList(UserInfoVo vo, Model model) {
	
		vo.setParamsPaging(userInfoService.selectOneCount(vo));
		
//		int a = codeGroupService.selectOneCount();
//		model.addAttribute(vo);
		
		model.addAttribute("list",userInfoService.selectList(vo));
//		CodeGroupVo codeGroupVo = new CodeGroupVo();
//		codeGroupVo.setThisPage();
//		codeGroupVo.setRowNumToShow(20);
		
		model.addAttribute("vo", vo);
	
		 return "xdm/userinfo/UserInfoXdmList";
	}
	
	@RequestMapping(value = "/xdm/userinfo/UserInfoXdmView")
	public String UserInfoXdmView(Model model, UserInfoDto userInfoDto) {
		model.addAttribute("item",userInfoService.selectOne(userInfoDto));
		return "xdm/userinfo/UserInfoXdmView";
	}
}
