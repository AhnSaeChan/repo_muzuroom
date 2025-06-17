package com.a6.module.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a6.module.uploaded.UploadedDao;
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
	
	@Autowired
    private UploadedDao uploadedDao;
	
	public int selectOneCount(ContentVo contentVo) {
		return contentDao.selectOneCount(contentVo);
	}
	
	public List<ContentDto> selectList(ContentVo contentVo){
		return contentDao.selectList(contentVo);
	}
	
	public ContentDto selectOne(ContentVo contentVo) {
		return contentDao.selectOne(contentVo);
	}
	
	public ContentDto selectOne(ContentDto contentDto) {
		return contentDao.selectOne(contentDto);
	}
	
	public List<ContentDto>reviewList(ContentVo contentVo){
		return contentDao.reviewList(contentVo);
	}
	
//	public int insert(ContentDto dto) throws Exception { 
////		contentDao.insert(dto);
//    	uploadFilesToS3(
//    			dto.getUploadImg1()
//    			, dto
//    			, "uploaded"
//    			, dto.getUploadImg1Type()
//    			, dto.getUploadImg1MaxNumber()
//    			, dto.getSeq()
//    			, contentDao
//    			, amazonS3Client);
//    	return 1; 
//    }
	
//	@Transactional
//	public int insert(ContentDto dto) throws Exception {
//	    // 1. 파일 S3 업로드
//	    uploadFilesToS3(
//	        dto.getUploadImg1(),
//	        dto,
//	        "uploaded",
//	        dto.getUploadImg1Type(),
//	        dto.getUploadImg1MaxNumber(),
//	        dto.getSeq(),
//	        contentDao,
//	        amazonS3Client
//	    );
//
//	    // 2. DB 저장
//	    contentDao.insert(dto);  // DB에 제품 정보 저장
//
//	    return 1;
//	}
	
	@Transactional
	public int insert(ContentDto dto) throws Exception {

	    // 1. S3 업로드 및 uploaded 테이블 저장
	    uploadedService.uploadFilesToS3(
	        dto.getUploadImg1(),
	        dto,
	        "uploaded",
	        dto.getUploadImg1Type(),
	        dto.getUploadImg1MaxNumber(),
	        dto.getSeq(),
	        uploadedDao,
	        amazonS3Client
	    );

	    // 2. 대표 이미지 URL 세팅 (uploadFilesToS3 내부에서 dto.path에 마지막 URL이 들어 있음)
	    if(dto.getPath() != null && !dto.getPath().isEmpty()) {
	        dto.setRoomPic(dto.getPath());
	    }

	    // 3. room 테이블 insert
	    contentDao.insert(dto);

	    return 1;
	}


	
	
	
}
