package com.limyel.blog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GithubAccessTokenDTO {

    private String accessToken;

    private String tokenType;

    private String scope;

}
