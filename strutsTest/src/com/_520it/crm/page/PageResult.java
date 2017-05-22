package com._520it.crm.page;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter@Setter
public class PageResult {
    // 查询
    private List listData;
    private Integer totalcount;
    // 用户传入
    private Integer pageSize=10;
    private Integer currentPage=1;
    // 计算
    private Integer prePage;
    private Integer nextPage;
    private Integer totalpage;

    // 构造器
    public PageResult(List listData, Integer totalcount, Integer pageSize, Integer currentPage) {
        this.listData = listData;
        this.totalcount = totalcount;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        totalpage = totalcount % pageSize == 0 ? totalcount / pageSize : totalcount / pageSize + 1;
        prePage = currentPage - 1 <= 1 ? 1 :currentPage - 1;
        nextPage = currentPage + 1 >= totalpage ? totalpage : (currentPage + 1);
    }

    @Override
    public String toString() {
        return "PageResult [listData=" + listData + ", totalcount=" + totalcount + ", pageSize=" + pageSize
                + ", currentPage=" + currentPage + ", prePage=" + prePage + ", nextPage=" + nextPage + ", totalpage="
                + totalpage + "]";
    }

    // tostr

}
