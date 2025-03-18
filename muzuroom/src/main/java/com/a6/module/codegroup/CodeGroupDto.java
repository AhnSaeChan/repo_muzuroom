package com.a6.module.codegroup;

public class CodeGroupDto {

	
	private String seq;
	private String cgName;
	private Integer count;
	private Integer cgDelNY;
//	-----
	
	
	/**
	 * @return the seq
	 */
	public String getSeq() {
		return seq;
	}
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
