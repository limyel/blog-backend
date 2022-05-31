package com.limyel.blog.common.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Paging<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 总数
     */
    private Long total;

    /**
     * 每页记录
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 当前页数
     */
    private Integer pageNum;

    /**
     * 数据
     */
    private List<T> list;

    public Paging(Page<T> page) {
        this.initPaging(page);
        this.list = page.getContent();
    }

    public Paging(Page<?> page, Class<T> clazz) {
        this.initPaging(page);
        this.list = page.getContent()
                .stream().map(item -> {
                    T target = null;
                    try {
                        target = clazz.getDeclaredConstructor().newInstance();
                    } catch (InstantiationException | NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    BeanUtils.copyProperties(item, target);
                    return target;
                }).collect(Collectors.toList());
    }

    private void initPaging(Page<?> page) {
        this.total = page.getTotalElements();
        this.pageSize = page.getSize();
        this.totalPage = page.getTotalPages();
        this.pageNum = page.getNumberOfElements();
    }
}
