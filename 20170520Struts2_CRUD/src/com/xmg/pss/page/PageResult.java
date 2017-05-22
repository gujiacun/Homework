package com.xmg.pss.page;
//分页查询的参数

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PageResult {
    // 需要查询
    private List listData;
    private Integer totalCount;
    // 用户传入
    private Integer pageSize = 3;
    private Integer currentPage = 1;
    // 需要计算
    private Integer prePage;
    private Integer nextPage;
    private Integer totalPage;
    // 首页尾页
    private Integer beginPage = 1;
    private Integer endPage;
    // 当查询时没有任何符合条件的结果时，返回空集合
    public static PageResult emptyResult = new PageResult();

    public PageResult() {

    }

    public PageResult(List listData, Integer totalCount, Integer pageSize, Integer currentPage) {
        super();
        this.listData = listData;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        // 需要计算
        totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        prePage = currentPage - 1 >= 1 ? currentPage - 1 : 1;
        nextPage = currentPage + 1 <= totalPage ? currentPage + 1 : totalPage;

    }

}
