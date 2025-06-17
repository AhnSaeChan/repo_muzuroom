package com.a6.module.review;

public class ReviewVo {
	
		
//		paging
		private int thisPage = 1;									// 현재 페이지
		private int rowNumToShow = 5;								// 화면에 보여줄 데이터 줄 갯수
		private int pageNumToShow = 5;								// 화면에 보여줄 페이징 번호 갯수

		private int totalRows;										// 전체 데이터 갯수
		private int totalPages;										// 전체 페이지 번호
		private int startPage;										// 시작 페이지 번호
		private int endPage;										// 마지막 페이지 번호

		private int startRnumForMysql = 0;							// 쿼리 시작 row
		
		private String seq;
		
//		search
		private Integer shUseNy = 1; 									/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
		private Integer shDelNy = 0; 								/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
		private Integer shOptionDate;							/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
		private String shDateStart;
		private String shDateEnd;
		private Integer shOption;									/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
		private String shValue;
//		-----
		
		/**
		 * @return the thisPage
		 */
		public int getThisPage() {
			return thisPage;
		}

		/**
		 * @return the shUseNy
		 */
		public Integer getShUseNy() {
			return shUseNy;
		}

		/**
		 * @param shUseNy the shUseNy to set
		 */
		public void setShUseNy(Integer shUseNy) {
			this.shUseNy = shUseNy;
		}

		/**
		 * @return the shDelNy
		 */
		public Integer getShDelNy() {
			return shDelNy;
		}

		/**
		 * @param shDelNy the shDelNy to set
		 */
		public void setShDelNy(Integer shDelNy) {
			this.shDelNy = shDelNy;
		}

		/**
		 * @return the shOptionDate
		 */
		public Integer getShOptionDate() {
			return shOptionDate;
		}

		/**
		 * @param shOptionDate the shOptionDate to set
		 */
		public void setShOptionDate(Integer shOptionDate) {
			this.shOptionDate = shOptionDate;
		}

		/**
		 * @return the shDateStart
		 */
		public String getShDateStart() {
			return shDateStart;
		}

		/**
		 * @param shDateStart the shDateStart to set
		 */
		public void setShDateStart(String shDateStart) {
			this.shDateStart = shDateStart;
		}

		/**
		 * @return the shDateEnd
		 */
		public String getShDateEnd() {
			return shDateEnd;
		}

		/**
		 * @param shDateEnd the shDateEnd to set
		 */
		public void setShDateEnd(String shDateEnd) {
			this.shDateEnd = shDateEnd;
		}

		/**
		 * @return the shOption
		 */
		public Integer getShOption() {
			return shOption;
		}

		/**
		 * @param shOption the shOption to set
		 */
		public void setShOption(Integer shOption) {
			this.shOption = shOption;
		}

		/**
		 * @return the shValue
		 */
		public String getShValue() {
			return shValue;
		}

		/**
		 * @param shValue the shValue to set
		 */
		public void setShValue(String shValue) {
			this.shValue = shValue;
		}

		/**
		 * @return the seq
		 */
		public String getSeq() {
			return seq;
		}

		/**
		 * @param seq the seq to set
		 */
		public void setSeq(String seq) {
			this.seq = seq;
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
//			setThisPage(3);

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
//			System.out.println("getStartRnumForOracle():" + getStartRnumForOracle());
//			System.out.println("getEndRnumForOracle():" + getEndRnumForOracle());
			System.out.println("getStartRnumForMysql(): " + getStartRnumForMysql());
			
		}
		
		
	}


