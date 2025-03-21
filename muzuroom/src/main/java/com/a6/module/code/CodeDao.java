package com.a6.module.code;

import java.util.List;

import org.springframework.stereotype.Repository;



@Repository
public interface CodeDao {
	
	public int selectOneCount(CodeVo CodeVo);
	public List<CodeDto> selectList(CodeVo CodeVo);
	public CodeDto selectOne(CodeVo codeVo);
	public int insert (CodeDto codeDto);
	
	public List<CodeDto> selectListCachedCodeArrayList();
}
