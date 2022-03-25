package com.limyel.blog.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GithubUserInfoDTO {

    private String login;

    private Long id;

    private String nodeId;

    private String avatarUrl;

    private String gravatarId;

    private String url;

    private String htmlUrl;

    private String followersUrl;

    private String followingUrl;

    private String gistsUrl;

    private String starredUrl;

    private String subscriptionsUrl;

    private String organizationsUrl;

    private String reposUrl;

    private String eventsUrl;

    private String receivedEventsUrl;

    private String type;

    private String site_admin;

    private String name;

    private String company;

    private String blog;

    private String location;

    private String email;

    private String hireable;

    private String bio;

    private String twitterUsername;

    private Integer publicRepos;

    private Integer publicGists;

    private Integer followers;

    private Integer following;

    private Date createdAt;

    private Date updatedAt;
}
