package com.a6.module.codegroup;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CodeGroupDto {

	
	private String seq;
	private Integer groupUsedNY;
	private Integer codeGroupCode;
	private String cgName;
	private String cgNameEng;
	private Integer count;
	private Integer cgOrder;
	private Date cgRegDate;
	private Date cgCorrectDate;
	private Integer cgDelNY;
	
	public static List<CodeGroupDto> cachedCodeArrayList = new ArrayList<CodeGroupDto>();
//	-----
	
	
	/**
	 * @return the seq
	 */
	public String getSeq() {
		return seq;
	}
	/**
	 * @return the cgRegDate
	 */
	public Date getCgRegDate() {
		return cgRegDate;
	}
	/**
	 * @param cgRegDate the cgRegDate to set
	 */
	public void setCgRegDate(Date cgRegDate) {
		this.cgRegDate = cgRegDate;
	}
	/**
	 * @return the cgCorrectDate
	 */
	public Date getCgCorrectDate() {
		return cgCorrectDate;
	}
	/**
	 * @param cgCorrectDate the cgCorrectDate to set
	 */
	public void setCgCorrectDate(Date cgCorrectDate) {
		this.cgCorrectDate = cgCorrectDate;
	}
	/**
	 * @return the cachedCodeArrayList
	 */
	public static List<CodeGroupDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}
	/**
	 * @param cachedCodeArrayList the cachedCodeArrayList to set
	 */
	public static void setCachedCodeArrayList(List<CodeGroupDto> cachedCodeArrayList) {
		CodeGroupDto.cachedCodeArrayList = cachedCodeArrayList;
	}
	/**
	 * @return the groupUsedNY
	 */
	public Integer getGroupUsedNY() {
		return groupUsedNY;
	}
	/**
	 * @param groupUsedNY the groupUsedNY to set
	 */
	public void setGroupUsedNY(Integer groupUsedNY) {
		this.groupUsedNY = groupUsedNY;
	}
	/**
	 
	/**
	 * @return the cgNameEng
	 */
	public String getCgNameEng() {
		return cgNameEng;
	}
	/**
	 * @param cgNameEng the cgNameEng to set
	 */
	public void setCgNameEng(String cgNameEng) {
		this.cgNameEng = cgNameEng;
	}
	/**
	 
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * @param seq the seq to set
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public Integer getCodeGroupCode() {
		return codeGroupCode;
	}
	public void setCodeGroupCode(Integer codeGroupCode) {
		this.codeGroupCode = codeGroupCode;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getCgOrder() {
		return cgOrder;
	}
	public void setCgOrder(Integer cgOrder) {
		this.cgOrder = cgOrder;
	}
	/**
	 * @return the cgName
	 */
	public String getCgName() {
		return cgName;
	}
	/**
	 * @param cgName the cgName to set
	 */
	public void setCgName(String cgName) {
		this.cgName = cgName;
	}
	/**
	 * @return the cgDelNY
	 */
	public Integer getCgDelNY() {
		return cgDelNY;
	}
	/**
	 * @param cgDelNY the cgDelNY to set
	 */
	public void setCgDelNY(Integer cgDelNY) {
		this.cgDelNY = cgDelNY;
	}
	
	
	
}
