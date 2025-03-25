package com.a6.module.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
