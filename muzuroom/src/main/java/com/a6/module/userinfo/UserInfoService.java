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
	
	public UserInfoDto selectOne(UserInfoVo userInfoVo) {
		return userInfoDao.selectOne(userInfoVo);
	}
	
	public int insert(UserInfoDto userInfoDto) {
		return userInfoDao.insert(userInfoDto);
	}
	
	public UserInfoDto selectOneLogin(UserInfoDto userInfoDto) {
		return userInfoDao.selectOneLogin(userInfoDto);
	}

}
