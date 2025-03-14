package com.a6.module.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupDao {
	public int selectRaw(CodeGroupVo CodeGroupVo);
	public int selectOneCount(CodeGroupVo CodeGroupVo);
	public List<CodeGroupDto> selectList(CodeGroupVo CodeGroupVo);
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto);
	public int insert(CodeGroupDto codeGroupDto);
}
