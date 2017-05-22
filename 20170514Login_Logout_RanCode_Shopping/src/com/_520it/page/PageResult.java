//需求：分页查询，在查询结果中实现分页显示，在浏览器页面中显示总条数，当前页，总页数，首页，上页，下页，页面大小，尾页，结果集数据
//由于数据太多，在servlet中共享到jsp页面麻烦，把它们封装到对象中
package com._520it.page;

import java.util.ArrayList;
import java.util.List;

import lombok.Setter;

//@Setter
public class PageResult {
    // 需要查询而来的
    private List listData;
    private Integer totalCount;
    public static PageResult emptyResult =  new PageResult(new ArrayList<>(),0,1,3);
    /// 用户传递的
    private Integer currentPage;
    private Integer pageSize;
    // 通过计算而来
    private Integer prePage;
    private Integer nextPage;
    private Integer totalPages;
    // 首页尾页
    private Integer beginPage=1;
    private Integer lastPage;
    
    public PageResult() {
    }
    public List getListData() {
        return listData;
    }

    public void setListData(List listData) {
        this.listData = listData;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPrePage() {
        return prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(Integer beginPage) {
        this.beginPage = beginPage;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }


    public PageResult(List listData, Integer totalCount, Integer currentPage, Integer pageSize) {
        super();
        this.listData = listData;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        // 计算一些值
        this.totalPages = totalCount / pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        this.prePage = currentPage - 1 >= 1 ? currentPage - 1 : 1;
        this.nextPage = currentPage + 1 <= this.totalPages ? currentPage + 1 : this.totalPages;
    }

    @Override
    public String toString() {
        return "PageResult [listData=" + listData + ", totalCount=" + totalCount + ", currentPage=" + currentPage
                + ", pageSize=" + pageSize + ", prePage=" + prePage + ", nextPage=" + nextPage + ", totalPages="
                + totalPages + ", firstPage=" + beginPage + ", lastPage=" + lastPage + "]";
    };

}
