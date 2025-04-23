package com.a6.module.uploaded;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UploadedController {
	@Autowired
    private UploadedService uploadedService;

    // 파일 업로드 처리
//	@PostMapping("/usr/product/uploaded/insert")
//	public String uploadedInsert(@ModelAttribute UploadedDto uploadedDto) throws Exception {
//	    uploadedService.insert(uploadedDto);
//	    return "redirect:/usr/product/usrProductItem";
//	}
	
	
}
