package com.a6.module.review;

import java.sql.Date;

import com.a6.module.content.ContentDto;
import com.a6.module.userinfo.UserInfoDto;

public class ReviewDto {
	private String reSeq; //리뷰Seq
	private Integer starScore; //리뷰 별점
	private String reTitle; //리뷰 제목
	private String reText; //리뷰 내용
	private Integer reDelNy; //삭제 여부
	private Date regDateTime; //등록일
	private Date modDateTime; //수정일
	private String userInfo_seq; //숙소 Seq
	private String room_seq; //멤버 Seq
	
	private ContentDto roomInfo;
    private UserInfoDto userInfo;
    
    //-----
    
    
	public String getReSeq() {
		return reSeq;
	}
	public String getUserInfo_seq() {
		return userInfo_seq;
	}
	public void setUserInfo_seq(String userInfo_seq) {
		this.userInfo_seq = userInfo_seq;
	}
	public String getRoom_seq() {
		return room_seq;
	}
	public ContentDto getRoomInfo() {
		return roomInfo;
	}
	public void setReSeq(String reSeq) {
		this.reSeq = reSeq;
	}
	public Integer getStarScore() {
		return starScore;
	}
	public void setStarScore(Integer starScore) {
		this.starScore = starScore;
	}
	public String getReTitle() {
		return reTitle;
	}
	public void setReTitle(String reTitle) {
		this.reTitle = reTitle;
	}
	public String getReText() {
		return reText;
	}
	public void setReText(String reText) {
		this.reText = reText;
	}
	public Integer getReDelNy() {
		return reDelNy;
	}
	public void setReDelNy(Integer reDelNy) {
		this.reDelNy = reDelNy;
	}
	public Date getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(Date regDateTime) {
		this.regDateTime = regDateTime;
	}
	public Date getModDateTime() {
		return modDateTime;
	}
	public void setModDateTime(Date modDateTime) {
		this.modDateTime = modDateTime;
	}
	
	
	public void setRoomInfo(ContentDto roomInfo) {
		this.roomInfo = roomInfo;
	}
	public UserInfoDto getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfoDto userInfo) {
		this.userInfo = userInfo;
	}
	
	public void setRoom_seq(String room_seq) {
	    this.room_seq = room_seq;

	    if (this.roomInfo == null) {
	        this.roomInfo = new ContentDto();
	    }
	    this.roomInfo.setSeq(room_seq); // 숙소 정보 DTO에 seq 자동 설정
	}

	public void setUserinfo_seq(String userinfo_seq) {
	    this.userInfo_seq = userinfo_seq;

	    if (this.userInfo == null) {
	        this.userInfo = new UserInfoDto();
	    }
	    this.userInfo.setSeq(userinfo_seq); // 사용자 정보 DTO에 seq 자동 설정
	}

	
	

    
    
    
    
}
