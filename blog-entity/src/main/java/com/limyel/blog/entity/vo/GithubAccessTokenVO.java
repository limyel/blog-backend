package com.limyel.blog.entity.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GithubAccessTokenVO {

    private String accessToken;

    private String tokenType;

    private String scope;

}
