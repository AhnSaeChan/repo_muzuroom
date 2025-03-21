package com.a6.module.content;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ContentDao {
	
	public int selectOneCount(ContentVo contentVo);
	public List<ContentDto> selectList(ContentVo contentVo);
	public int selectOne(ContentVo contentVo);
}
