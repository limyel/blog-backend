package com.limyel.blog.entity.vo;

import com.limyel.blog.entity.About;
import com.limyel.blog.entity.AboutItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AboutDetailVO extends About {

    List<AboutItem> items;

}
