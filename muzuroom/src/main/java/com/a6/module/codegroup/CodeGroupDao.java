package com.a6.module.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.a6.module.code.CodeVo;

@Repository
public interface CodeGroupDao {
	
	public int listTotal(CodeGroupVo CodeGroupVo);
	public int selectOneCount(CodeGroupVo CodeGroupVo);
	public List<CodeGroupDto> selectList(CodeGroupVo CodeGroupVo);
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto);
	public int insert(CodeGroupDto codeGroupDto);
}
