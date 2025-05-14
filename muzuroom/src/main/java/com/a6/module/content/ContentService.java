package com.a6.module.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a6.module.uploaded.UploadedService;
import com.amazonaws.services.s3.AmazonS3Client;

@Service
public class ContentService extends UploadedService {
	@Autowired
	ContentDao contentDao;
	
	@Autowired
	UploadedService uploadedService;
	
	@Autowired
    private AmazonS3Client amazonS3Client;
	
	public int selectOneCount(ContentVo contentVo) {
		return contentDao.selectOneCount(contentVo);
	}
	
	public List<ContentDto> selectList(ContentVo contentVo){
		return contentDao.selectList(contentVo);
	}
	
	public ContentDto selectOne(ContentVo contentVo) {
		return contentDao.selectOne(contentVo);
	}
	
	public int insert(ContentDto dto) throws Exception { 
//		contentDao.insert(dto);
    	uploadFilesToS3(
    			dto.getUploadImg1()
    			, dto
    			, "uploaded"
    			, dto.getUploadImg1Type()
    			, dto.getUploadImg1MaxNumber()
    			, dto.getSeq()
    			, contentDao
    			, amazonS3Client);
    	return 1; 
    }
	
	
	
}
