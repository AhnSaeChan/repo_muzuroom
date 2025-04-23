package com.a6.module.uploaded;

import org.springframework.stereotype.Repository;

import com.a6.module.content.ContentDto;

@Repository
public interface UploadedDao {
	
	public int insertUploaded(UploadedDto uploadedDto);
}
