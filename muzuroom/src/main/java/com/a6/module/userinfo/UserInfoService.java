package com.a6.module.userinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
	@Autowired
	UserInfoDao userInfoDao;
	
	public int selectOneCount(UserInfoVo userInfoVo) {
		return userInfoDao.selectOneCount(userInfoVo);
	}
	
	public List<UserInfoDto> selectList(UserInfoVo userInfoVo){
		return userInfoDao.selectList(userInfoVo);
	}
	
	public UserInfoDto selectOne(UserInfoDto userInfoDto) {
		return userInfoDao.selectOne(userInfoDto);
	}
	
	public int insert(UserInfoDto userInfoDto) {
		return userInfoDao.insert(userInfoDto);
	}

}
