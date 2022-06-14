package com.limyel.blog.common.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
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
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC)
public class Paging<T> extends PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据
     */
    private List<T> list;

    public Paging(Page<T> page) {
        super(page);
        this.list = page.getContent();
    }

    public Paging(Page<?> page, Class<T> clazz) {
        super(page);
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

    public Paging(Page<?> page, List<T> result) {
        super(page);
        this.setList(result);
    }

}
