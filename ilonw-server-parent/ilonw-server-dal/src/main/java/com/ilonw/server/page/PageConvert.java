package com.ilonw.server.page;

import java.util.List;

public class PageConvert {
    public static PageBean getPageBean(PageBean pageBean, List listData){
        if(null == pageBean){
            return null;
        }
        PageBean page = new PageBean();
        page.setItems(listData);
        page.setCurrentPage(pageBean.getCurrentPage());
        page.setPageSize(pageBean.getPageSize());
        page.setTotalNum(pageBean.getTotalNum());
        page.setTotalPage(pageBean.getTotalPage());
        page.setIsMore(pageBean.getIsMore());
        page.setStartIndex(pageBean.getStartIndex());
        return page;
    }

    public static PageBean getDataPages(PageBean pageBean, List listData,Integer countData){
        if(null == pageBean){
            return null;
        }
        PageBean page = new PageBean();
        page.setCurrentPage(pageBean.getCurrentPage());
        page.setPageSize(pageBean.getPageSize());
        page.setItems(listData);
        page.setTotalNum(countData);
        page.setTotalPage((countData + page.getPageSize() - 1) / page.getPageSize());
        page.setIsMore(page.getCurrentPage() >= ((countData + page.getPageSize() - 1) / page.getPageSize())?0:1);
        page.setStartIndex((page.getCurrentPage() - 1) * page.getPageSize());
        return page;
    }
}
