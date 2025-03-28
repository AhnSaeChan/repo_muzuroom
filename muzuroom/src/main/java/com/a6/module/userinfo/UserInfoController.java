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
	public Map<String, Object> signinXdmProc(UserInfoDto UserInfoDto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		UserInfoDto rtMember = userInfoService.selectOneLogin(UserInfoDto);
		if(rtMember!=null) {
			httpSession.setAttribute("sessSeqXdm",rtMember.getSeq());
			httpSession.setAttribute("sessIdXdm",rtMember.getUserId());
			httpSession.setAttribute("sessNameXdm",rtMember.getUserName());
			returnMap.put("rt","success");
		}else {
			returnMap.put("rt","fail");
//			System.out.println(rtMember.getSeq());
		}
//		UtilCookie.deleteCookieXdm();
		
//		System.out.println(rtMember.getUserId());
		return returnMap;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/signoutXdmProc")
	public Map<String, Object> signoutXdmProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
//		UtilCookie.deleteCookieXdm();
		httpSession.setAttribute("sessSeqXdm", null);
		httpSession.setAttribute("sessIdXdm", null);
		httpSession.setAttribute("sessNameXdm", null);
		returnMap.put("rt","success");
		return returnMap;
		
	}
	
	
	
	
	
}
