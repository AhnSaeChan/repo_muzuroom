package com.a6.module.reservation;

import java.sql.Date;

public class ReservationDto {
	
	private String seq;
	private Date reservDate;
	private String reservName;
	private String reservTell;
	private Integer reservTime;
	private Integer totalPrice;
	private Integer reservStat;
	private Integer reservDelNY;
	private Integer userinfo_seq;
	private Integer room_seq;
	
//-----
	
	
	public String getSeq() {
		return seq;
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
	public Integer getUserinfo_seq() {
		return userinfo_seq;
	}
	public void setUserinfo_seq(Integer userinfo_seq) {
		this.userinfo_seq = userinfo_seq;
	}
	public Integer getRoom_seq() {
		return room_seq;
	}
	public void setRoom_seq(Integer room_seq) {
		this.room_seq = room_seq;
	}

	
	
}
