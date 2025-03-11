package com.a6.module.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupService {
	@Autowired
	CodeGroupDao codeGroupDao;
	
	public List<CodeGroupDto> selectList(){
		return codeGroupDao.selectList();
	}
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto){
		return codeGroupDao.selectOne(codeGroupDto);
	}
	
	public int insert(CodeGroupDto codeGroupDto){ // 함수를 선언 ,Dto를 받겠다고 선언
		 return codeGroupDao.insert(codeGroupDto); //하나씩 추가, 함수를 사용
	 }
}
