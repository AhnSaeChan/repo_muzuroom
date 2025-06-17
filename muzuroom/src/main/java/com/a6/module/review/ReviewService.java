package com.a6.module.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
	
	@Autowired
	ReviewDao reviewDao;
	
	public List<ReviewDto> selectList(int seq){
		return reviewDao.selectList(seq);
	}
	
	// 리뷰 등록하기
		public int insert (ReviewDto reviewDto) {
			return reviewDao.insert(reviewDto);
		}
}
