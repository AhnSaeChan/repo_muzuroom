package com.a6.module.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService {
	@Autowired
	ContentDao contentDao;
	
	public int selectOneCount(ContentVo contentVo) {
		return contentDao.selectOneCount(contentVo);
	}
	
	public List<ContentDto> selectList(ContentVo contentVo){
		return contentDao.selectList(contentVo);
	}
	
	public int selectOne(ContentVo contentVo) {
		return contentDao.selectOne(contentVo);
	}
}
