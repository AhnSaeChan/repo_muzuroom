package com.a6.module.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.a6.common.util.UtilDateTime;

import jakarta.servlet.http.HttpSession;

@Controller

public class CodeController{
	@Autowired
	CodeService codeService;
	
	
	@RequestMapping(value = "/xdm/code/CodeXdmList")
	public String CodeXdmList(@ModelAttribute("vo") CodeVo vo, Model model)  {
		
		
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
		
		if (vo.getShDelNy() == null) {
		    vo.setShDelNy(0);
		}
		
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
	
//	@RequestMapping(value = "/xdm/code/CodeExcelUploadForm")
//	
//	public String CodeExcelUploadForm(@ModelAttribute("vo") CodeVo vo, Model model) {
//		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
//		
//		if (vo.getShDelNy() == null) {
//		    vo.setShDelNy(0);
//		}
//		
//		vo.setParamsPaging(codeService.selectOneCount(vo));
//		
//		return "/xdm/code/CodeExcelUploadForm";
//	}
	
	@RequestMapping(value = "/xdm/code/CodeExcelUploadForm")
	public String CodeExcelUploadForm(@ModelAttribute("vo") CodeVo vo, Model model) {
	    vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart().equals("") ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
	    vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd().equals("") ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
	    
	    if (vo.getShDelNy() == null) {
	        vo.setShDelNy(0);
	    }

	    vo.setParamsPaging(codeService.selectOneCount(vo));
	    model.addAttribute("vo", vo);
	    
	    return "/xdm/code/CodeExcelUploadForm"; // 업로드 페이지
	}

	@RequestMapping(value = "/xdm/code/CodeExcelUploadPreview")
	public String CodeExcelUploadPreview(@RequestParam("file") MultipartFile file, Model model) {
	    System.out.println("🟢 [Controller] CodeExcelUploadPreview 진입");
	    try {
	        if (file.isEmpty()) {
	            System.out.println("❌ [Controller] 업로드된 파일이 비어 있음");
	            model.addAttribute("error", "업로드된 파일이 없습니다.");
	            return "/xdm/code/CodeExcelUploadForm";
	        }

	        String originalFilename = file.getOriginalFilename();
	        System.out.println("📄 [Controller] 파일명: " + originalFilename);
	        System.out.println("📏 [Controller] 파일 크기: " + file.getSize());

	        if (!originalFilename.endsWith(".xls") && !originalFilename.endsWith(".xlsx")) {
	            System.out.println("❌ [Controller] 엑셀 형식 아님");
	            model.addAttribute("error", "엑셀 파일만 업로드 가능합니다.");
	            return "/xdm/code/CodeExcelUploadForm";
	        }

	        if (file.getSize() > 5 * 1024 * 1024) {
	            System.out.println("❌ [Controller] 파일 크기 초과");
	            model.addAttribute("error", "파일 용량은 5MB 이하만 가능합니다.");
	            return "/xdm/code/CodeExcelUploadForm";
	        }

	        System.out.println("🟢 [Controller] parseExcel 호출 직전");
	        List<CodeDto> previewList = codeService.parseExcel(file);
	        System.out.println("✅ [Controller] parseExcel 정상 호출 완료");

	        model.addAttribute("previewList", previewList);
	        System.out.println("✅ [Controller] previewList 모델 등록 완료");

	        return "/xdm/code/CodeExcelUploadForm";
	    } catch (Exception e) {
	        System.out.println("❌ [Controller] 예외 발생: " + e.getMessage());
	        e.printStackTrace();
	        model.addAttribute("error", "엑셀 파일 처리 중 오류 발생: " + e.getMessage());
	        return "/xdm/code/CodeExcelUploadForm";
	    }
	}


	@RequestMapping(value = "/xdm/code/CodeExcelUploadConfirm")
	public String CodeExcelUploadConfirm(HttpSession session) {
	    @SuppressWarnings("unchecked")
	    List<CodeDto> previewList = (List<CodeDto>) session.getAttribute("previewList");

	    if (previewList != null && !previewList.isEmpty()) {
	        codeService.insertExcelList(previewList);
	        session.removeAttribute("previewList"); // 세션 정리
	    }

	    return "redirect:/xdm/code/CodeXdmList";
	}
	
	


	
	
	
	
	
}
