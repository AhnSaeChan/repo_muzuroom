package com.a6.module.review;

import java.util.List;

import org.springframework.stereotype.Repository;



@Repository
public interface ReviewDao {
	public List<ReviewDto> selectList(int seq);
	
	public int insert(ReviewDto reviewDto);
}
