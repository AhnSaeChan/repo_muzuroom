package com.a6.module.userinfo;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDao {
	
	public int selectOneCount(UserInfoVo UserInfoVo);
	public List<UserInfoDto> selectList(UserInfoVo userInfoVo);
	public UserInfoDto selectOne(UserInfoVo userInfoVo);
	public UserInfoDto selectInfo(UserInfoVo userInfoVo);
	public int insert (UserInfoDto userInfoDto);
	public UserInfoDto selectOneLogin(UserInfoDto userInfoDto);
	public int selectDuplicateId(UserInfoDto userInfoDto);
	
}
