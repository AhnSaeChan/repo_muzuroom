package com.a6.module.content;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.a6.module.uploaded.UploadedDto;

public class ContentDto extends UploadedDto{
	
	private String seq;
	private String roomPic;
	private String roomIdCD;
	private Integer reginCD;
	private Integer reservAvailableYN;
	private String roomName;
	private Integer pricePerHour;
	 
	 
	private String roomZipCode; 
	private String roomStreetAddress; 
	private String roomLotAddress;
	private String roomAddressRef;
	private String roomAddress;
	
	
	private Double roomLatitude;
	private Double roomLongitude;
	 
	  
	private String roomDetail;  
	private String roomIntro; 
	private String roomGuideline; 
	
	private Date roomRegTime;
	private Date roomModTime;
	private String userInfo_seq;
	
	private MultipartFile[] uploadImg1;
	
	private Integer uploadImg1Type;
	private Integer uploadImg1MaxNumber;
	
	private String reSeq; //리뷰 Seq
	private Integer starScore; // 리뷰 별점
	private String reTitle; // 리뷰 제목
	private String reText; // 리뷰 내용
	private String reDelNy; // 리뷰 업데이트 삭제
	private String room_seq; // 스테이 Seq
	
	private String userName;
	
	private Double averageRating;
//---
	
	public String getSeq() {
		return seq;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}
	public String getReSeq() {
		return reSeq;
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
	public String getReDelNy() {
		return reDelNy;
	}
	public void setReDelNy(String reDelNy) {
		this.reDelNy = reDelNy;
	}
	public String getRoom_seq() {
		return room_seq;
	}
	public void setRoom_seq(String room_seq) {
		this.room_seq = room_seq;
	}
	public Integer getReginCD() {
		return reginCD;
	}
	public void setReginCD(Integer reginCD) {
		this.reginCD = reginCD;
	}
	public String getUserInfo_seq() {
		return userInfo_seq;
	}
	public void setUserInfo_seq(String userInfo_seq) {
		this.userInfo_seq = userInfo_seq;
	}
	public Integer getPricePerHour() {
		return pricePerHour;
	}
	public void setPricePerHour(Integer pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	public String getRoomZipCode() {
		return roomZipCode;
	}
	public void setRoomZipCode(String roomZipCode) {
		this.roomZipCode = roomZipCode;
	}
	public String getRoomStreetAddress() {
		return roomStreetAddress;
	}
	public void setRoomStreetAddress(String roomStreetAddress) {
		this.roomStreetAddress = roomStreetAddress;
	}
	public String getRoomLotAddress() {
		return roomLotAddress;
	}
	public void setRoomLotAddress(String roomLotAddress) {
		this.roomLotAddress = roomLotAddress;
	}
	public String getRoomAddressRef() {
		return roomAddressRef;
	}
	public void setRoomAddressRef(String roomAddressRef) {
		this.roomAddressRef = roomAddressRef;
	}
	public String getRoomAddress() {
		return roomAddress;
	}
	public void setRoomAddress(String roomAddress) {
		this.roomAddress = roomAddress;
	}
	public String getRoomPic() {
		return roomPic;
	}
	public void setRoomPic(String roomPic) {
		this.roomPic = roomPic;
	}
	public Double getRoomLatitude() {
		return roomLatitude;
	}
	public void setRoomLatitude(Double roomLatitude) {
		this.roomLatitude = roomLatitude;
	}
	public Double getRoomLongitude() {
		return roomLongitude;
	}
	public void setRoomLongitude(Double roomLongitude) {
		this.roomLongitude = roomLongitude;
	}
	public Date getRoomRegTime() {
		return roomRegTime;
	}
	public void setRoomRegTime(Date roomRegTime) {
		this.roomRegTime = roomRegTime;
	}
	public Date getRoomModTime() {
		return roomModTime;
	}
	public void setRoomModTime(Date roomModTime) {
		this.roomModTime = roomModTime;
	}
	public Integer getUploadImg1Type() {
		return uploadImg1Type;
	}
	public void setUploadImg1Type(Integer uploadImg1Type) {
		this.uploadImg1Type = uploadImg1Type;
	}
	public Integer getUploadImg1MaxNumber() {
		return uploadImg1MaxNumber;
	}
	public void setUploadImg1MaxNumber(Integer uploadImg1MaxNumber) {
		this.uploadImg1MaxNumber = uploadImg1MaxNumber;
	}
	public MultipartFile[] getUploadImg1() {
		return uploadImg1;
	}
	public void setUploadImg1(MultipartFile[] uploadImg1) {
		this.uploadImg1 = uploadImg1;
	}
	/**
	 * @param seq the seq to set
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	/**
	 * @return the roomIdCD
	 */
	public String getRoomIdCD() {
		return roomIdCD;
	}
	/**
	 * @param roomIdCD the roomIdCD to set
	 */
	public void setRoomIdCD(String roomIdCD) {
		this.roomIdCD = roomIdCD;
	}
	/**
	 * @return the reservAvailableYN
	 */
	public Integer getReservAvailableYN() {
		return reservAvailableYN;
	}
	/**
	 * @param reservAvailableYN the reservAvailableYN to set
	 */
	public void setReservAvailableYN(Integer reservAvailableYN) {
		this.reservAvailableYN = reservAvailableYN;
	}
	/**
	 * @return the roomName
	 */
	public String getRoomName() {
		return roomName;
	}
	/**
	 * @param roomName the roomName to set
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	/**
	 * @return the roomDetail
	 */
	public String getRoomDetail() {
		return roomDetail;
	}
	/**
	 * @param roomDetail the roomDetail to set
	 */
	public void setRoomDetail(String roomDetail) {
		this.roomDetail = roomDetail;
	}
	/**
	 * @return the roomIntro
	 */
	public String getRoomIntro() {
		return roomIntro;
	}
	/**
	 * @param roomIntro the roomIntro to set
	 */
	public void setRoomIntro(String roomIntro) {
		this.roomIntro = roomIntro;
	}
	/**
	 * @return the roomGuideline
	 */
	public String getRoomGuideline() {
		return roomGuideline;
	}
	/**
	 * @param roomGuideline the roomGuideline to set
	 */
	public void setRoomGuideline(String roomGuideline) {
		this.roomGuideline = roomGuideline;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
