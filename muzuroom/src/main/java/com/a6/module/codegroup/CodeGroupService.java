package com.a6.module.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a6.module.code.CodeVo;

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
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto){
		return codeGroupDao.selectOne(codeGroupDto);
	}
	
	public int insert(CodeGroupDto codeGroupDto){ // 함수를 선언 ,Dto를 받겠다고 선언
		 return codeGroupDao.insert(codeGroupDto); //하나씩 추가, 함수를 사용
	 }
}
