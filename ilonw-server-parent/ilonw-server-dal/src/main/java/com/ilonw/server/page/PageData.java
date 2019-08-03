package com.ilonw.server.page;

import java.io.Serializable;

public class PageData  implements Serializable {
    private static final long serialVersionUID = 1L;
    // 当前页
    private Integer currentPage;
    // 每页显示的总条数
    private Integer pageSize;

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
}
