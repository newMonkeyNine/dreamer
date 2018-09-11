package com.liuhaolei.dreamer.common;

public class RequestModel {
	
	/**
	 * 默认页数
	 */
	private Integer curPage = 1;
	
	/**
	 * 默认每页显示数量
	 */
	private Integer pageSize = 10;

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	

}
