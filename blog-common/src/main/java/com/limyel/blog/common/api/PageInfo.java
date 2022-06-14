package com.limyel.blog.common.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.domain.Page;

import java.util.List;

public class PageInfo {

    /**
     * 总数
     */
    protected Long total;

    /**
     * 每页记录
     */
    protected Integer pageSize;

    /**
     * 总页数
     */
    protected Integer totalPage;

    /**
     * 当前页数
     */
    protected Integer pageNum;

    public PageInfo(Page<?> page) {
        this.total = page.getTotalElements();
        this.pageSize = page.getNumberOfElements();
        this.totalPage = page.getTotalPages();
        this.pageNum = page.getNumber() + 1;
    }

}
