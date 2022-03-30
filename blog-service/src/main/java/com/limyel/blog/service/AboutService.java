package com.limyel.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.blog.core.util.PageUtil;
import com.limyel.blog.entity.About;
import com.limyel.blog.vo.AboutDetailVO;

import java.util.List;

/**
 * @author limyel
 */
public interface AboutService extends IService<About> {

    /**
     * 关于详情列表
     * @return
     */
    List<AboutDetailVO> listDetail();

    /**
     * 保存
     * @param about
     * @return
     */
    int saveAbout(About about);

    /**
     * 通过 id 获取
     * @param id
     * @return
     */
    About getById(Long id);

    /**
     * 逻辑删除
     * @param about
     * @return
     */
    int delete(About about);

    /**
     * 更新
     * @param about
     * @return
     */
    int update(About about);

    /**
     * 分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageUtil page(Long pageNum, Long pageSize);

    /**
     * 通过 id 获取关于详情
     * @param id
     * @return
     */
    AboutDetailVO getDetailById(Long id);
}
