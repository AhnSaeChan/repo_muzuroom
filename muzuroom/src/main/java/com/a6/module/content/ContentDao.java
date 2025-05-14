package com.a6.module.content;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.a6.module.uploaded.UploadedDao;

@Repository
public interface ContentDao extends UploadedDao{
	
	public int selectOneCount(ContentVo contentVo);
	public List<ContentDto> selectList(ContentVo contentVo);
	public ContentDto selectOne(ContentVo contentVo);
	public int insertUploaded(ContentDto contentDto);
//	public int insert(ContentDto contentDto);
}
