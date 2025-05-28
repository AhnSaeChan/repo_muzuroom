package com.a6.module.code;

import java.util.List;

import org.springframework.stereotype.Repository;



@Repository
public interface CodeDao {
	
	public int selectOneCount(CodeVo CodeVo);
	public List<CodeDto> selectList(CodeVo CodeVo);
	public CodeDto selectOne(CodeVo codeVo);
	public int insert (CodeDto codeDto);
	public int update (CodeDto codeDto);
	public int delete (CodeDto codeDto);
	public int uelete (CodeDto codeDto);
	void insertCodeList(List<CodeDto> list); 
	void insertExcelList(List<CodeDto> list);
	
	
	public List<CodeDto> selectListCachedCodeArrayList();
}
