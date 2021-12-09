package com.limyel.blog.entity.dto;

import com.limyel.blog.entity.About;
import com.limyel.blog.entity.AboutItem;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AboutDetail extends About {

    List<AboutItem> items;

}
