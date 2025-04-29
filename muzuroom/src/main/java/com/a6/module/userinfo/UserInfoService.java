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
	
	public UserInfoDto selectInfo(UserInfoVo userInfoVo) {
		return userInfoDao.selectInfo(userInfoVo);
	}
	
	public int insert(UserInfoDto userInfoDto) {
		return userInfoDao.insert(userInfoDto);
	}
	
	public UserInfoDto selectOneLogin(UserInfoDto userInfoDto) {
		return userInfoDao.selectOneLogin(userInfoDto);
	}
	
	public int selectDuplicateId(UserInfoDto userInfoDto) {
		return userInfoDao.selectDuplicateId(userInfoDto);
	}
	
	public int updateInfo(UserInfoDto userInfoDto) {
		return userInfoDao.updateInfo(userInfoDto);
	}

}
