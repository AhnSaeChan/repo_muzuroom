package com.a6.module.reservation;

import java.sql.Date;

import com.a6.module.content.ContentDto;
import com.a6.module.userinfo.UserInfoDto;

public class ReservationDto extends ReservationVo {
	
	private String seq;
	private Date reservDate;
	private String reservName;
	private String reservTell;
	private Integer reservTime;
	private Integer totalPrice;
	private Integer reservStat;
	private Integer reservDelNY;
	private String userinfo_seq;
	private String room_seq;
	
	private UserInfoDto userInfo;
	private ContentDto roomInfo;
	
	private String roomPic;
	
//-----
	
	
	public String getSeq() {
		return seq;
	}
	
	public String getRoomPic() {
		return roomPic;
	}

	public void setRoomPic(String roomPic) {
		this.roomPic = roomPic;
	}

	public UserInfoDto getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfoDto userInfo) {
		this.userInfo = userInfo;
	}
	public ContentDto getRoomInfo() {
		return roomInfo;
	}
	public void setRoomInfo(ContentDto roomInfo) {
		this.roomInfo = roomInfo;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public Date getReservDate() {
		return reservDate;
	}
	public void setReservDate(Date reservDate) {
		this.reservDate = reservDate;
	}
	public String getReservName() {
		return reservName;
	}
	public void setReservName(String reservName) {
		this.reservName = reservName;
	}
	public String getReservTell() {
		return reservTell;
	}
	public void setReservTell(String reservTell) {
		this.reservTell = reservTell;
	}
	public Integer getReservTime() {
		return reservTime;
	}
	public void setReservTime(Integer reservTime) {
		this.reservTime = reservTime;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getReservStat() {
		return reservStat;
	}
	public void setReservStat(Integer reservStat) {
		this.reservStat = reservStat;
	}
	public Integer getReservDelNY() {
		return reservDelNY;
	}
	public void setReservDelNY(Integer reservDelNY) {
		this.reservDelNY = reservDelNY;
	}
	public String getUserinfo_seq() {
		return userinfo_seq;
	}
	public void setUserinfo_seq(String userinfo_seq) {
		this.userinfo_seq = userinfo_seq;
	}
	public String getRoom_seq() {
		return room_seq;
	}
	public void setRoom_seq(String room_seq) {
		this.room_seq = room_seq;
	}
	

	
	
}
