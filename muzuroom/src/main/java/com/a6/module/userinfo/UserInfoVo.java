package com.a6.module.userinfo;

public class UserInfoVo {
	
//	paging
	private int thisPage = 1;									// 현재 페이지
	private int rowNumToShow = 5;								// 화면에 보여줄 데이터 줄 갯수
	private int pageNumToShow = 5;								// 화면에 보여줄 페이징 번호 갯수

	private int totalRows;										// 전체 데이터 갯수
	private int totalPages;										// 전체 페이지 번호
	private int startPage;										// 시작 페이지 번호
	private int endPage;										// 마지막 페이지 번호

	private int startRnumForMysql = 0;							// 쿼리 시작 row

//	-----

	/**
	 * @return the thisPage
	 */
	public int getThisPage() {
		return thisPage;
	}

	/**
	 * @param thisPage the thisPage to set
	 */
	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}

	/**
	 * @return the rowNumToShow
	 */
	public int getRowNumToShow() {
		return rowNumToShow;
	}

	/**
	 * @param rowNumToShow the rowNumToShow to set
	 */
	public void setRowNumToShow(int rowNumToShow) {
		this.rowNumToShow = rowNumToShow;
	}

	/**
	 * @return the pageNumToShow
	 */
	public int getPageNumToShow() {
		return pageNumToShow;
	}

	/**
	 * @param pageNumToShow the pageNumToShow to set
	 */
	public void setPageNumToShow(int pageNumToShow) {
		this.pageNumToShow = pageNumToShow;
	}

	/**
	 * @return the totalRows
	 */
	public int getTotalRows() {
		return totalRows;
	}

	/**
	 * @param totalRows the totalRows to set
	 */
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @return the startPage
	 */
	public int getStartPage() {
		return startPage;
	}

	/**
	 * @param startPage the startPage to set
	 */
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	/**
	 * @return the endPage
	 */
	public int getEndPage() {
		return endPage;
	}

	/**
	 * @param endPage the endPage to set
	 */
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	/**
	 * @return the startRnumForMysql
	 */
	public int getStartRnumForMysql() {
		return startRnumForMysql;
	}

	/**
	 * @param startRnumForMysql the startRnumForMysql to set
	 */
	public void setStartRnumForMysql(int startRnumForMysql) {
		this.startRnumForMysql = startRnumForMysql;
	}
	
	public void setParamsPaging(int totalRows) {
//		setThisPage(3);

		setTotalRows(totalRows);

		if (getTotalRows() == 0) {
			setTotalPages(1);
		} else {
			setTotalPages(getTotalRows() / getRowNumToShow());
		}

		if (getTotalRows() % getRowNumToShow() > 0) {
			setTotalPages(getTotalPages() + 1);
		}

		if (getTotalPages() < getThisPage()) {
			setThisPage(getTotalPages());
		}
		
		setStartPage(((getThisPage() - 1) / getPageNumToShow()) * getPageNumToShow() + 1);

		setEndPage(getStartPage() + getPageNumToShow() - 1);

		if (getEndPage() > getTotalPages()) {
			setEndPage(getTotalPages());
		}
		
		
		
		if (thisPage == 1) {
			setStartRnumForMysql(0);
		} else {
			setStartRnumForMysql((getRowNumToShow() * (getThisPage()-1)));
		}
		
		System.out.println("getThisPage():" + getThisPage());
		System.out.println("getTotalRows():" + getTotalRows());
		System.out.println("getRowNumToShow():" + getRowNumToShow());
		System.out.println("getTotalPages():" + getTotalPages());
		System.out.println("getStartPage():" + getStartPage());
		System.out.println("getEndPage():" + getEndPage());		
//		System.out.println("getStartRnumForOracle():" + getStartRnumForOracle());
//		System.out.println("getEndRnumForOracle():" + getEndRnumForOracle());
		System.out.println("getStartRnumForMysql(): " + getStartRnumForMysql());
		
	}
	
	
}
	

