package com.limyel.blog.dto;

import com.limyel.blog.entity.Post;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class PostDTO {

    private String title;

    private String content;

    private String introduction;

    private List<Long> tagIdList;

    public interface Save {

    }

    public interface Update {

    }

}
