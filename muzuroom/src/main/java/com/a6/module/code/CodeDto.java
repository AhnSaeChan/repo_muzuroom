package com.a6.module.code;

import java.util.ArrayList;
import java.util.List;

public class CodeDto {
	
	private String seq;
	private Integer cdDelNY;
	private Integer codeUsedNY;
	private Integer codeGroupCd;
	private String codeGroupName;
	private Integer codeCD;
	private Integer codeAlt;
	private String cdName; 
	private String codeNameEng;
    private Integer codeOrder;
    private String codeRegDate;
    private String codeCorrectDate;
    private Integer codeGroup_seq;
    
    public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();
	/**
	 * 
	 * 
	 * @return the seq
	 */
    
    
	public String getSeq() {
		return seq;
	}
	/**
	 * @return the cachedCodeArrayList
	 */
	public static List<CodeDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}
	/**
	 * @param cachedCodeArrayList the cachedCodeArrayList to set
	 */
	public static void setCachedCodeArrayList(List<CodeDto> cachedCodeArrayList) {
		CodeDto.cachedCodeArrayList = cachedCodeArrayList;
	}
	/**
	 * @param seq the seq to set
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	/**
	 * @return the cdDelNY
	 */
	public Integer getCdDelNY() {
		return cdDelNY;
	}
	/**
	 * @param cdDelNY the cdDelNY to set
	 */
	public void setCdDelNY(Integer cdDelNY) {
		this.cdDelNY = cdDelNY;
	}
	/**
	 * @return the codeUsedNY
	 */
	public Integer getCodeUsedNY() {
		return codeUsedNY;
	}
	/**
	 * @param codeUsedNY the codeUsedNY to set
	 */
	public void setCodeUsedNY(Integer codeUsedNY) {
		this.codeUsedNY = codeUsedNY;
	}
	/**
	 * @return the codeGroupCd
	 */
	public Integer getCodeGroupCd() {
		return codeGroupCd;
	}
	/**
	 * @param codeGroupCd the codeGroupCd to set
	 */
	public void setCodeGroupCd(Integer codeGroupCd) {
		this.codeGroupCd = codeGroupCd;
	}
	/**
	 * @return the codeGroupName
	 */
	public String getCodeGroupName() {
		return codeGroupName;
	}
	/**
	 * @param codeGroupName the codeGroupName to set
	 */
	public void setCodeGroupName(String codeGroupName) {
		this.codeGroupName = codeGroupName;
	}
	/**
	 * @return the codeCD
	 */
	public Integer getCodeCD() {
		return codeCD;
	}
	/**
	 * @param codeCD the codeCD to set
	 */
	public void setCodeCD(Integer codeCD) {
		this.codeCD = codeCD;
	}
	/**
	 * @return the codeAlt
	 */
	public Integer getCodeAlt() {
		return codeAlt;
	}
	/**
	 * @param codeAlt the codeAlt to set
	 */
	public void setCodeAlt(Integer codeAlt) {
		this.codeAlt = codeAlt;
	}
	/**
	 * @return the cdName
	 */
	public String getCdName() {
		return cdName;
	}
	/**
	 * @param cdName the cdName to set
	 */
	public void setCdName(String cdName) {
		this.cdName = cdName;
	}
	/**
	 * @return the codeNameEng
	 */
	public String getCodeNameEng() {
		return codeNameEng;
	}
	/**
	 * @param codeNameEng the codeNameEng to set
	 */
	public void setCodeNameEng(String codeNameEng) {
		this.codeNameEng = codeNameEng;
	}
	/**
	 * @return the codeOrder
	 */
	public Integer getCodeOrder() {
		return codeOrder;
	}
	/**
	 * @param codeOrder the codeOrder to set
	 */
	public void setCodeOrder(Integer codeOrder) {
		this.codeOrder = codeOrder;
	}
	/**
	 * @return the codeRegDate
	 */
	public String getCodeRegDate() {
		return codeRegDate;
	}
	/**
	 * @param codeRegDate the codeRegDate to set
	 */
	public void setCodeRegDate(String codeRegDate) {
		this.codeRegDate = codeRegDate;
	}
	/**
	 * @return the codeCorrectDate
	 */
	public String getCodeCorrectDate() {
		return codeCorrectDate;
	}
	/**
	 * @param codeCorrectDate the codeCorrectDate to set
	 */
	public void setCodeCorrectDate(String codeCorrectDate) {
		this.codeCorrectDate = codeCorrectDate;
	}
	/**
	 * @return the codeGroup_seq
	 */
	public Integer getCodeGroup_seq() {
		return codeGroup_seq;
	}
	/**
	 * @param codeGroup_seq the codeGroup_seq to set
	 */
	public void setCodeGroup_seq(Integer codeGroup_seq) {
		this.codeGroup_seq = codeGroup_seq;
	}
    
// -----
    
    
	
    
    
    
}
 