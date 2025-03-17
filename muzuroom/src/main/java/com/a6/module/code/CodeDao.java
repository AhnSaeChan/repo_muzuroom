package com.a6.module.code;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.a6.module.codegroup.CodeGroupVo;



@Repository
public interface CodeDao {
	public int selectRaw(CodeVo CodeVo);
	public int selectOneCount(CodeVo CodeVo);
	public List<CodeDto> selectList(CodeVo CodeVo);
}
