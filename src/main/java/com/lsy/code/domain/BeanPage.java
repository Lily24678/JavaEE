package com.lsy.code.domain;

import java.util.List;

public class BeanPage<T> {
    private Integer currentPage;// 当前页
    private Integer totalPage;// 总共的页数
    private Integer size=15;// 当前页显示的记录数
    private Integer totalCount;// 总记录数
    private List<T> list;// 当前页的记录

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
