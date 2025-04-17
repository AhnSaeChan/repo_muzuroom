package com.a6.module.userinfo;

import java.sql.Date;

public class UserInfoDto {

	private String seq;
	private Integer userCodeCD;
	private String userFirstName;
	private String userName;
	private Integer userGenderMF;
	private String userId;
	private String userPassword;
	private String mobileCarrier;
	private String userPhoneNum;
	private String userZipcode;
	private String adminDistrict;
	private String userAddress;
	private String streetAddress;
	private String lotAddress;
	private String addressRef;
	private Double latitude;
	private Double longitude;
	private String userEmail;
	private Date userDOB;
	private Date userRegDate;
	private Integer userInfoDelYN;
	private Integer userReview_seq;
	private Integer payMethod_seq;
	private Integer reservCurrent_seq;
//	-----
	
	
	/**
	 * @return the seq
	 */
	public String getSeq() {
		return seq;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getLotAddress() {
		return lotAddress;
	}
	public void setLotAddress(String lotAddress) {
		this.lotAddress = lotAddress;
	}
	public String getAddressRef() {
		return addressRef;
	}
	public void setAddressRef(String addressRef) {
		this.addressRef = addressRef;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the adminDistrict
	 */
	public String getAdminDistrict() {
		return adminDistrict;
	}
	/**
	 * @param adminDistrict the adminDistrict to set
	 */
	public void setAdminDistrict(String adminDistrict) {
		this.adminDistrict = adminDistrict;
	}
	/**
	 * @return the mobileCarrier
	 */
	public String getMobileCarrier() {
		return mobileCarrier;
	}
	/**
	 * @param mobileCarrier the mobileCarrier to set
	 */
	public void setMobileCarrier(String mobileCarrier) {
		this.mobileCarrier = mobileCarrier;
	}
	/**
	 * @return the userDOB
	 */
	public Date getUserDOB() {
		return userDOB;
	}
	/**
	 * @param userDOB the userDOB to set
	 */
	public void setUserDOB(Date userDOB) {
		this.userDOB = userDOB;
	}
	/**
	 * @return the userRegDate
	 */
	public Date getUserRegDate() {
		return userRegDate;
	}
	/**
	 * @param userRegDate the userRegDate to set
	 */
	public void setUserRegDate(Date userRegDate) {
		this.userRegDate = userRegDate;
	}
	/**
	 * @param seq the seq to set
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	/**
	 * @return the userCodeCD
	 */
	public Integer getUserCodeCD() {
		return userCodeCD;
	}
	/**
	 * @param userCodeCD the userCodeCD to set
	 */
	public void setUserCodeCD(Integer userCodeCD) {
		this.userCodeCD = userCodeCD;
	}
	/**
	 * @return the userFirstName
	 */
	public String getUserFirstName() {
		return userFirstName;
	}
	/**
	 * @param userFirstName the userFirstName to set
	 */
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userGenderMF
	 */
	public Integer getUserGenderMF() {
		return userGenderMF;
	}
	/**
	 * @param userGenderMF the userGenderMF to set
	 */
	public void setUserGenderMF(Integer userGenderMF) {
		this.userGenderMF = userGenderMF;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	/**
	 * @return the userPhoneNum
	 */
	public String getUserPhoneNum() {
		return userPhoneNum;
	}
	/**
	 * @param userPhoneNum the userPhoneNum to set
	 */
	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}
	/**
	 * @return the userZipcode
	 */
	public String getUserZipcode() {
		return userZipcode;
	}
	/**
	 * @param userZipcode the userZipcode to set
	 */
	public void setUserZipcode(String userZipcode) {
		this.userZipcode = userZipcode;
	}
	/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}
	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	/**
	 * @return the userInfoDelYN
	 */
	public Integer getUserInfoDelYN() {
		return userInfoDelYN;
	}
	/**
	 * @param userInfoDelYN the userInfoDelYN to set
	 */
	public void setUserInfoDelYN(Integer userInfoDelYN) {
		this.userInfoDelYN = userInfoDelYN;
	}
	/**
	 * @return the userReview_seq
	 */
	public Integer getUserReview_seq() {
		return userReview_seq;
	}
	/**
	 * @param userReview_seq the userReview_seq to set
	 */
	public void setUserReview_seq(Integer userReview_seq) {
		this.userReview_seq = userReview_seq;
	}
	/**
	 * @return the payMethod_seq
	 */
	public Integer getPayMethod_seq() {
		return payMethod_seq;
	}
	/**
	 * @param payMethod_seq the payMethod_seq to set
	 */
	public void setPayMethod_seq(Integer payMethod_seq) {
		this.payMethod_seq = payMethod_seq;
	}
	/**
	 * @return the reservCurrent_seq
	 */
	public Integer getReservCurrent_seq() {
		return reservCurrent_seq;
	}
	/**
	 * @param reservCurrent_seq the reservCurrent_seq to set
	 */
	public void setReservCurrent_seq(Integer reservCurrent_seq) {
		this.reservCurrent_seq = reservCurrent_seq;
	}
	
	
	
	
}
