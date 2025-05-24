package com.a6.module.codegroup;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a6.common.util.UtilDateTime;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CodeGroupController {
	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmList")
	public String CodeGroupXdmList(@ModelAttribute("vo") CodeGroupVo vo, Model model) {
		
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
		
		if (vo.getShDelNy() == null) {
		    vo.setShDelNy(0);
		}
		
		vo.setParamsPaging(codeGroupService.selectOneCount(vo));
		

		model.addAttribute("list",codeGroupService.selectList(vo));
		model.addAttribute("total",codeGroupService.listTotal(vo));

		
		
	
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
	
//	@RequestMapping("/excelDownload")
//    public void excelDownload(CodeGroupVo vo, HttpServletResponse httpServletResponse) throws Exception {
//		
//		
//		vo.setParamsPaging(codeGroupService.selectOneCount(vo));
//
//		if (vo.getTotalRows() > 0) {
//			List<CodeGroupDto> list = codeGroupService.selectList(vo);
//			
////			Workbook workbook = new HSSFWorkbook();	// for xls
//	        Workbook workbook = new XSSFWorkbook();
//	        Sheet sheet = workbook.createSheet("첫번째 시트");
//	        CellStyle cellStyle = workbook.createCellStyle();        
//	        Row row = null;
//	        Cell cell = null;
//	        int rowNum = 0;
//			
////	        each column width setting
//	        sheet.setColumnWidth(0, 2100);
//	        sheet.setColumnWidth(1, 3100);
//
////	        Header
//	        String[] tableHeader = {"코드그룹 코드", "코드그룹 이름", "코드", "대체 코드", "코드 이름", "코드 이름 (영문)", "사용", "순서", "등록일", "수정일"};
//
//	        row = sheet.createRow(rowNum++);
//			for(int i=0; i<tableHeader.length; i++) {
//				cell = row.createCell(i);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//				cell.setCellValue(tableHeader[i]);
//			}
//
////	        Body
//	        for (int i=0; i<list.size(); i++) {
//	            row = sheet.createRow(rowNum++);
//	            
////	            String type: null 전달 되어도 ok
////	            int, date type: null 시 오류 발생 하므로 null check
////	            String type 이지만 정수형 데이터가 전체인 seq 의 경우 캐스팅
//	            
//	            cell = row.createCell(0);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	            cell.setCellValue(Integer.parseInt(list.get(i).getSeq()));
//	            
//	            cell = row.createCell(1);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	        	cell.setCellValue(Integer.parseInt(list.get(i).getCodeGroupCode()));
//	        	
//	            cell = row.createCell(2);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	        	cell.setCellValue(list.get(i).getCgName());
//	        	
//	            cell = row.createCell(3);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	        	cell.setCellValue(list.get(i).getCgNameEng());
//	            
//	            cell = row.createCell(4);
//	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	            cell.setCellStyle(cellStyle);
//	            cell.setCellValue(list.get(i).getCount());
//	            
//	            cell = row.createCell(5);
//	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	            cell.setCellStyle(cellStyle);
//	            cell.setCellValue(Integer.parseInt(list.get(i).getCgOrder()));
//     
//	            cell = row.createCell(6);
//	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	            cell.setCellStyle(cellStyle);
//	            cell.setCellValue(list.get(i).getCgRegDate());
//	            
//	            cell = row.createCell(7);
//	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	            cell.setCellStyle(cellStyle);
//	            if(list.get(i).getIfcdOrder() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getIfcdOrder());
//	            
//	            cell = row.createCell(8);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	        	if(list.get(i).getRegDateTime() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getRegDateTime()));
//	        	
//	        	cell = row.createCell(9);
//	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
//	        	cell.setCellStyle(cellStyle);
//	        	if(list.get(i).getModDateTime() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getModDateTime()));
//	        }
//
//	        httpServletResponse.setContentType("ms-vnd/excel");
////	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xls");	// for xls
//	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xlsx");
//
//	        workbook.write(httpServletResponse.getOutputStream());
//	        workbook.close();
//		}
//    }
	
	
	
	
}
