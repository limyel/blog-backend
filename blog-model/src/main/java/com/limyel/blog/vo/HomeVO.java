package com.limyel.blog.vo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.limyel.blog.common.api.PageInfo;
import com.limyel.blog.common.api.Paging;
import com.limyel.blog.dto.PostPureDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC)
public class HomeVO extends PageInfo {

    Map<Integer, List<PostPureDTO>> result;

    public HomeVO(Page<?> page) {
        super(page);
    }
}
