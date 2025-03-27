package com.a6.module.codegroup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a6.module.code.CodeDto;

import jakarta.annotation.PostConstruct;

//import com.a6.module.code.CodeVo;

@Service
public class CodeGroupService {
	@Autowired
	CodeGroupDao codeGroupDao;
	

	
	public int listTotal(CodeGroupVo codeGroupVo) {
		return codeGroupDao.listTotal(codeGroupVo);
	}
	
	public int selectOneCount(CodeGroupVo codeGroupVo) {
		return codeGroupDao.selectOneCount(codeGroupVo);
	}
	
	public List<CodeGroupDto> selectList(CodeGroupVo codeGroupVo){
		return codeGroupDao.selectList(codeGroupVo);
	}
	public CodeGroupDto selectOne(CodeGroupVo codeGroupVo){
		return codeGroupDao.selectOne(codeGroupVo);
	}
	
	public int insert(CodeGroupDto codeGroupDto){ // 함수를 선언 ,Dto를 받겠다고 선언
		 return codeGroupDao.insert(codeGroupDto); //하나씩 추가, 함수를 사용
	 }
	
	public int update(CodeGroupDto codeGroupDto){ // 함수를 선언 ,Dto를 받겠다고 선언
		 return codeGroupDao.update(codeGroupDto); //하나씩 추가, 함수를 사용
	 }
	
	public int delete(CodeGroupDto codeGroupDto){ // 함수를 선언 ,Dto를 받겠다고 선언
		 return codeGroupDao.delete(codeGroupDto); //하나씩 추가, 함수를 사용
	 }
	
	public int uelete(CodeGroupDto codeGroupDto){ // 함수를 선언 ,Dto를 받겠다고 선언
		 return codeGroupDao.uelete(codeGroupDto); //하나씩 추가, 함수를 사용
	 }
	
	@PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<CodeGroupDto> codeListFromDb = (ArrayList<CodeGroupDto>) codeGroupDao.selectListCachedCodeArrayList();
		CodeGroupDto.cachedCodeArrayList.clear(); 
		CodeGroupDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
	}
    
    
	public static void clear() throws Exception {
		CodeGroupDto.cachedCodeArrayList.clear();
	}
	
	
	public static List<CodeGroupDto> selectListCachedCode(String Seq) throws Exception {
		List<CodeGroupDto> rt = new ArrayList<CodeGroupDto>();
		for(CodeGroupDto codeRow : CodeGroupDto.cachedCodeArrayList) {
			if (codeRow.getSeq().equals(Seq)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		return rt;
	}

						 
	public static String selectOneCachedCode(int codegroup) throws Exception {
		String rt = "";
		for(CodeGroupDto codeRow : CodeGroupDto.cachedCodeArrayList) {
			System.out.println(codeRow.getSeq());
			if (codeRow.getSeq().equals(Integer.toString(codegroup))) {
				rt = codeRow.getCgName();
			} else {
				// by pass
			}
		}
		return rt;
	}
}
