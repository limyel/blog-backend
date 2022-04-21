package com.limyel.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Date createTime;

    private Date updateTime;

    @TableLogic
    @TableField(value = "is_deleted")
    private Boolean deleted;

}
