package com.a6.module.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexView {
	@RequestMapping(value = "/xdm/index/IndexView")
	public String IndexView() {
		
		return "xdm/index/IndexView";
	}
	
	@RequestMapping(value = "/usr/usrindex/usrIndexView")
	public String usrIndexView() {
			
		return "usr/usrindex/usrIndexView";
	}
}

