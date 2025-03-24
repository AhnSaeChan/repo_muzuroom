package com.a6.module.userinfo;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDao {
	
	public int selectOneCount(UserInfoVo userInfoVo);
	public List<UserInfoDto> selectList(UserInfoVo userInfoVo);
	public UserInfoDto selectOne(UserInfoDto userInfoDto);
	public int insert (UserInfoDto userInfoDto);
}
