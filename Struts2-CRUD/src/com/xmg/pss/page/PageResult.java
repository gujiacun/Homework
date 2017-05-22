package com.xmg.pss.page;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class PageResult {

	private List<?> listData;
	private Integer totalCount;
	private Integer currentPage=1;
	private Integer pageSize=5;
	private Integer totalPage;
	private Integer prePage;
	private Integer nextPage;

	public PageResult(List<?> listData, Integer totalCount,
			Integer currentPage, Integer pageSize) {
		super();
		this.listData = listData;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;

		this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount
				/ this.pageSize : this.totalCount / this.pageSize + 1;
		this.prePage = this.currentPage - 1 >= 1 ? this.currentPage - 1 : 1;
		this.nextPage = this.currentPage + 1 <= this.totalPage ? this.currentPage + 1
				: this.totalPage;
	}
}
