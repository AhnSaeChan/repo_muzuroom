package com.a6.module.userinfo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;



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
	
	@RequestMapping(value = "/xdm/userinfo/UserInfoXdmForm")
	public String UserInfoXdmForm() {
		
		return "xdm/userinfo/UserInfoXdmForm";
	}
	
	@RequestMapping(value = "/xdm/userinfo/UserInfoXdmInst")
	public String UserInfoXdmInst(Model model, UserInfoDto userInfoDto) {
		userInfoService.insert(userInfoDto);
		return "redirect:/xdm/userinfo/UserInfoXdmInst";
	}
	
	@ResponseBody
	@RequestMapping(value = "/signinXdmProc")
	public Map<String, Object> signinXdmProc(UserInfoDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
//		UtilCookie.deleteCookieXdm();
//		httpSession.setAttribute("sessSeqXdm", null);
//		httpSession.setAttribute("sessIdXdm", null);
//		httpSession.setAttribute("sessNameXdm", null);
		returnMap.put("rt","success");
		return returnMap;
		
	}
}
