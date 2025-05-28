package com.a6.module.code;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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
		        int totalRows = sheet.getLastRowNum();
		        System.out.println("📄 [Service] 총 행 수: " + totalRows);

		        for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
		            Row row = sheet.getRow(rowIndex);
		            if (row == null) {
		                System.out.println("⚠️ [Service] " + rowIndex + "행은 비어 있음");
		                continue;
		            }

		            CodeDto dto = new CodeDto();

		            try {
		                System.out.println("🔎 [Service] " + rowIndex + "행 파싱 시작");

		                dto.setCodeUsedNY((int) getNumericValue(row.getCell(0)));

		                String setCodeGroupCdStr = getStringValue(row.getCell(1));
		                dto.setCodeGroupCd(setCodeGroupCdStr.isEmpty() ? null : Integer.parseInt(setCodeGroupCdStr));

		                dto.setCodeGroupName(getStringValue(row.getCell(2)));

		                String setCodeCDStr = getStringValue(row.getCell(3));
		                dto.setCodeCD(setCodeCDStr.isEmpty() ? null : Integer.parseInt(setCodeCDStr));

		                String codeAltStr = getStringValue(row.getCell(4));
		                dto.setCodeAlt(codeAltStr.isEmpty() ? null : Integer.parseInt(codeAltStr));

		                dto.setCdName(getStringValue(row.getCell(5)));
		                dto.setCodeNameEng(getStringValue(row.getCell(6)));
		                dto.setCodeOrder((int) getNumericValue(row.getCell(7)));

		                dto.setCodeRegDate(toSqlDate(getStringValue(row.getCell(8))));
		                dto.setCodeCorrectDate(toSqlDate(getStringValue(row.getCell(9))));

		                list.add(dto);
		                System.out.println("✅ [Service] " + rowIndex + "행 파싱 완료, 누적 개수: " + list.size());
		            } catch (Exception rowEx) {
		                System.out.println("❌ [Service] " + rowIndex + "행 파싱 중 예외: " + rowEx.getMessage());
		            }
		        }
		    } catch (Exception ex) {
		        System.out.println("❌ [Service] 엑셀 파싱 전체 실패: " + ex.getMessage());
		        throw ex;
		    }

		    System.out.println("🔚 [Service] parseExcel() 종료, 총 파싱된 행 수: " + list.size());
		    return list;
		}
	    

	    // 엑셀 미리보기 확정 후 DB에 일괄 저장
	    public void insertExcelList(List<CodeDto> previewList) {
	        for (CodeDto dto : previewList) {
	            codeDao.insert(dto);
	        }
	    }

	    // 셀에서 문자열 추출
	    private String getStringValue(Cell cell) {
	        return (cell == null) ? "" : cell.toString().trim();
	    }

	    // 셀에서 숫자 추출
	    private double getNumericValue(Cell cell) {
	        if (cell == null) return 0;
	        if (cell.getCellType() == CellType.NUMERIC) {
	            return cell.getNumericCellValue();
	        }
	        try {
	            return Double.parseDouble(cell.toString());
	        } catch (NumberFormatException e) {
	            return 0;
	        }
	    }

	    // 문자열 yyyy-MM-dd → java.sql.Date로 변환
	    private Date toSqlDate(String dateStr) {
	        try {
	            if (dateStr == null || dateStr.isEmpty()) return null;
	            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	            java.util.Date utilDate = format.parse(dateStr);
	            return new Date(utilDate.getTime());
	        } catch (Exception e) {
	            return null;
	        }
	    }
	    
	    
}
