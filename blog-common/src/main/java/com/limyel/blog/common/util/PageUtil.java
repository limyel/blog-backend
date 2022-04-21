package com.limyel.blog.common.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 */
@Getter
@Setter
public class PageUtil implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 总记录数
	 */
	private Long total;
	/**
	 * 每页记录数
	 */
	private Long pageSize;
	/**
	 * 总页数
	 */
	private Long pages;
	/**
	 * 当前页数
	 */
	private Long pageNum;
	/**
	 * 列表数据
	 */
	private List<?> list;

	/**
	 * 分页
	 * @param list        列表数据
	 * @param totalCount  总记录数
	 * @param pageSize    每页记录数
	 * @param currPage    当前页数
	 */
	public PageUtil(List<?> list, Long totalCount, Long pageSize, Long currPage, Long pages) {
		this.list = list;
		this.total = totalCount;
		this.pageSize = pageSize;
		this.pageNum = currPage;
		this.pages = pages;
	}

	public PageUtil(List<?> list, IPage<?> iPage) {
		this(list, iPage.getTotal(), iPage.getSize(), iPage.getCurrent(), iPage.getPages());
	}

	/**
	 * 分页
	 */
	public PageUtil(IPage<?> iPage) {
		this(iPage.getRecords(), iPage);
	}

}
