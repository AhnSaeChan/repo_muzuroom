package com.a6.module.signup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignupController {
	
	@RequestMapping(value = "/usr/usrsignup/usrSignUpForm")
	public String usrSignUpForm() {
		
		return "usr/usrsignup/usrSignUpForm";
	}
	
}
