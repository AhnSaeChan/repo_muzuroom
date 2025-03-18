package com.a6.module.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a6.module.codegroup.CodeGroupVo;



@Service
public class CodeService {
	@Autowired
	CodeDao codeDao;
	
	public int selectListWithoutPaging(CodeVo codeVo) {
		return codeDao.selectListWithoutPaging(codeVo);
	}
	
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
}
