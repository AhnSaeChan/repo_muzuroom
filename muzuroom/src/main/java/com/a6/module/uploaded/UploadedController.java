package com.a6.module.uploaded;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UploadedController {
	@Autowired
    private UploadedService uploadedService;

    // 파일 업로드 처리
    @PostMapping("/usr/product/uploaded/insert")
    public String uploadedInsert(UploadedDto uploadedDto) throws Exception {
        // UploadedService의 insertUploaded 메소드 호출하여 파일 업로드
        uploadedService.insertUploaded(uploadedDto);

        // 업로드 후, 파일 목록 페이지로 리다이렉트
        return "redirect:/usr/product/usrProductItem";
    }
	
	
}
