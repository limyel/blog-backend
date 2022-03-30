package com.limyel.blog.core.util;

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
	private int total;
	/**
	 * 每页记录数
	 */
	private int pageSize;
	/**
	 * 总页数
	 */
	private int pages;
	/**
	 * 当前页数
	 */
	private int pageNum;
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
	public PageUtil(List<?> list, int totalCount, int pageSize, int currPage) {
		this.list = list;
		this.total = totalCount;
		this.pageSize = pageSize;
		this.pageNum = currPage;
		this.pages = (int) Math.ceil((double)totalCount/pageSize);
	}

	/**
	 * 分页
	 */
	public PageUtil(IPage<?> page) {
		this.list = page.getRecords();
		this.total = (int)page.getTotal();
		this.pageSize = (int)page.getSize();
		this.pageNum = (int)page.getCurrent();
		this.pages = (int)page.getPages();
	}

}
