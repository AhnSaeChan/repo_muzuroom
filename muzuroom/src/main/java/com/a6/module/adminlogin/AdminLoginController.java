package com.a6.module.adminlogin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a6.module.code.CodeVo;

@Controller
public class AdminLoginController {

	@RequestMapping(value = "/adminLoginXdmForm")
	public String adminLoginXdmForm() {
		
		return "xdm/adminlogin/adminLoginXdmForm";
	}
	
	@RequestMapping(value = "/usrLoginUsrForm")
	public String usrLoginUsrForm() {
		
		return "/usr/usrlogin/usrLoginUsrForm";
	}
}
