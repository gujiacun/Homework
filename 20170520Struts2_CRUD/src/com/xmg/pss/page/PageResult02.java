package com.xmg.pss.page;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Setter@Getter
public class PageResult02 {
//分页查询所有参数
    //查询结果为空时的空PageResult
    private List listData;
    private Integer totalcount;
    
    private Integer currentPage=1;
    private Integer pageSize=3;
    
    private Integer totalpage;
    private Integer prePage;
    private Integer nextPage;
    
    public static PageResult02 emptyResult = new PageResult02();
            
    
    public PageResult02(List listData, Integer totalcount, Integer currentPage, Integer pageSize) {
        super();
        this.listData = listData;
        this.totalcount = totalcount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        
        totalpage = totalcount % pageSize == 0?totalcount / pageSize:totalcount / pageSize + 1;
        prePage = currentPage - 1 >= 1?currentPage - 1:1;
        nextPage = currentPage + 1 <= totalpage?currentPage + 1:totalpage;
    }
    @Override
    public String toString() {
        return "PageResult02 [listData=" + listData + ", totalcount=" + totalcount + ", currentPage=" + currentPage
                + ", pageSize=" + pageSize + ", totalpage=" + totalpage + ", prePage=" + prePage + ", nextPage="
                + nextPage + "]";
    }
    public PageResult02() {
        super();
    }
    
    
}
