package com.codeid.microservices.models;

import java.util.List;

public class PageableList<T> {

    private List<T> list;
    private int size;
    private int page;
    private Long total;

    public PageableList(List<T> list, int page, int size, Long total) {
        this.list = list;
        this.size = size;
        this.page = page;
        this.total = total;
    }
 
    public PageableList() {
    }
      
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}