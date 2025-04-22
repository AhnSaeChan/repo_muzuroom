package com.a6.module.uploaded;

import org.springframework.stereotype.Repository;

@Repository
public interface UploadedDao {
	
	
	public int insertUploaded(UploadedDto uploadedDto);
	public int insert(UploadedDto uploadedDto);
	
}
