package com.a6.module.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface CodeGroupDao {
	
	public int listTotal(CodeGroupVo CodeGroupVo);
	public int selectOneCount(CodeGroupVo CodeGroupVo);
	public List<CodeGroupDto> selectList(CodeGroupVo CodeGroupVo);
	public CodeGroupDto selectOne(CodeGroupVo CodeGroupVo);
	public int insert(CodeGroupDto codeGroupDto);
	public int update(CodeGroupDto codeGroupDto);
	public int delete(CodeGroupDto codeGroupDto);
	public int uelete(CodeGroupDto codeGroupDto);
	public List<CodeGroupDto> selectListCachedCodeArrayList();
}
