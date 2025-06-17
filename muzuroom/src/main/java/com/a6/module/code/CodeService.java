package com.a6.module.code;

import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;



@Service
public class CodeService {
	@Autowired
	CodeDao codeDao;
	
	
	
	public int selectOneCount(CodeVo codeVo) {
		return codeDao.selectOneCount(codeVo);
	}
	
	public List<CodeDto> selectList(CodeVo codeVo){
		return codeDao.selectList(codeVo);
	}
	
	public CodeDto selectOne(CodeVo codeVo) {
		return codeDao.selectOne(codeVo); 
	}
	
	public int insert(CodeDto codeDto) {
		return codeDao.insert(codeDto);
	}
	public int update(CodeDto codeDto) {
		return codeDao.update(codeDto);
	}
	public int delete(CodeDto codeDto) {
		return codeDao.delete(codeDto);
	}
	public int uelete(CodeDto codeDto) {
		return codeDao.uelete(codeDto);
	}
	
	
	
	
	 @PostConstruct
		public void selectListCachedCodeArrayList() throws Exception {
			List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) codeDao.selectListCachedCodeArrayList();
			CodeDto.cachedCodeArrayList.clear(); 
			CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
			System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
		}
	    
	    
		public static void clear() throws Exception {
			CodeDto.cachedCodeArrayList.clear();
		}
		
		
		public static List<CodeDto> selectListCachedCode(String Seq) throws Exception {
			List<CodeDto> rt = new ArrayList<CodeDto>();
			for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
				if (codeRow.getSeq().equals(Seq)) {
					rt.add(codeRow);
				} else {
					// by pass
				}
			}
			return rt;
		}

							 
		public static String selectOneCachedCode(int code) throws Exception {
			String rt = "";
			for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
				System.out.println(codeRow.getSeq());
				if (codeRow.getSeq().equals(Integer.toString(code))) {
					rt = codeRow.getCdName();
				} else {
					// by pass
				}
			}
			return rt;
		}
		
		

		public List<CodeDto> parseExcel(MultipartFile file) throws Exception {
		    System.out.println("🟢 [Service] parseExcel() 진입");

		    List<CodeDto> list = new ArrayList<>();

		    try (InputStream inputStream = file.getInputStream();
		         Workbook workbook = WorkbookFactory.create(inputStream)) {

		        Sheet sheet = workbook.getSheetAt(0);
		        int rowCount = sheet.getLastRowNum();
		        System.out.println("📄 [Service] 총 행 수: " + rowCount);

		        for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
		            System.out.println("🔎 [Service] " + rowIndex + "행 파싱 시작");

		            try {
		                Row row = sheet.getRow(rowIndex);
		                if (row == null) continue;

		                CodeDto dto = new CodeDto();

		                dto.setCdDelNY(getIntegerValue(row.getCell(0))); 
		                dto.setCodeUsedNY(getIntegerValue(row.getCell(1)));
		                dto.setCodeGroupCd(getIntegerValue(row.getCell(2)));
		                dto.setCodeGroupName(getStringValue(row.getCell(3)));
		                dto.setCodeCD(getIntegerValue(row.getCell(4)));
		                dto.setCodeAlt(getIntegerValue(row.getCell(5)));
		                dto.setCdName(getStringValue(row.getCell(6)));
		                dto.setCodeNameEng(getStringValue(row.getCell(7)));
		                dto.setCodeOrder(getIntegerValue(row.getCell(8)));
		                dto.setCodeRegDate(toSqlDate(row.getCell(9)));
		                dto.setCodeCorrectDate(toSqlDate(row.getCell(10)));


		                Integer codeGroupSeq = codeDao.selectCodeGroupSeqByGroupCd(dto.getCodeGroupCd());
		                dto.setCodeGroup_seq(codeGroupSeq);

		                list.add(dto);
		                System.out.println("✅ [Service] " + rowIndex + "행 파싱 완료");
		            } catch (Exception e) {
		                System.out.println("❌ [Service] " + rowIndex + "행 파싱 중 예외: " + e.getMessage());
		            }
		        }
		    }

		    System.out.println("🔚 [Service] parseExcel() 종료, 총 파싱된 행 수: " + list.size());
		    
//		 // 1. 파싱 끝나고
//		    System.out.println("🔚 [Service] parseExcel() 종료, 정렬 시작");
//
//		    // 2. codeOrder 기준 정렬
//		    list.sort(Comparator.comparing(CodeDto::getCodeOrder, Comparator.nullsLast(Integer::compareTo)));

		    // 3. 정렬 후 리턴
		    return list;

		    
		}




	    

	    // 엑셀 미리보기 확정 후 sql에 저장
	    public void insertExcelList(List<CodeDto> previewList) {
	        for (CodeDto dto : previewList) {
	            codeDao.insert(dto);
	        }
	    }

	    private String getStringValue(Cell cell) {
	        return (cell == null) ? "" : cell.toString().trim();
	    }

	    private Integer getIntegerValue(Cell cell) {
	        try {
	            if (cell == null) return null;
	            if (cell.getCellType() == CellType.NUMERIC) {
	                return (int) cell.getNumericCellValue(); // 1001.0 → 1001
	            } else {
	                String value = cell.toString().trim();
	                if (value.contains(".")) {
	                    return (int) Double.parseDouble(value); // "1001.0" → 1001
	                }
	                return Integer.parseInt(value);
	            }
	        } catch (Exception e) {
	            return null;
	        }
	    }

	    private Date toSqlDate(Cell cell) {
	        try {
	            if (cell == null) return null;

	            if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
	                return new Date(cell.getDateCellValue().getTime());
	            } else {
	                String dateStr = cell.toString().trim();
	                if (dateStr.isEmpty()) return null;
	                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	                java.util.Date utilDate = format.parse(dateStr);
	                return new Date(utilDate.getTime());
	            }
	        } catch (Exception e) {
	            System.out.println("❌ 날짜 파싱 실패: " + e.getMessage());
	            return null;
	        }
	    }




	    
	    
}
