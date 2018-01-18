package cn.query;

import java.io.Serializable;

/**
 * 基础查询对象
 * 
 * @author wangqiongqiong.wq
 * @date 2017-9-29 11:24
 */
public abstract class BaseQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7513369102222636670L;

	/**
	 * 默认分页页码
	 */
	public static final int DEFAULT_PAGE_NO = 1;

	/**
	 * 默认分页每页数量
	 */
	public static final int DEFAULT_PAGE_SIZE = 20;

	/**
	 * 最大分页页码
	 */
	public static final int MAX_PAGE_NO = 1000;

	/**
	 * 最大分页每页数量
	 */
	public static final int MAX_PAGE_SIZE = 200;

	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 创建者userId
	 */
	private Long creatorUserId;


	/**
	 * 是否需要扩展信息
	 */
	private boolean needExtraInfo = false;

	/**
	 * 是否需要分页信息，如果需要显示，可以设置为True
	 */
	private boolean needPagedInfo = false;

	/**
	 * 页码
	 */
	private int pageNo = DEFAULT_PAGE_NO;

	/**
	 * 每页数量
	 */
	private int pageSize = DEFAULT_PAGE_SIZE;


	public boolean getNeedExtraInfo() {
		return needExtraInfo;
	}

	public void setNeedExtraInfo(boolean needExtraInfo) {
		this.needExtraInfo = needExtraInfo;
	}

	public boolean getNeedPagedInfo() {
		return needPagedInfo;
	}

	public void setNeedPagedInfo(boolean needPagedInfo) {
		this.needPagedInfo = needPagedInfo;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		if (pageNo <= 0) {
			this.pageNo = DEFAULT_PAGE_NO;
		} else if (pageNo > MAX_PAGE_NO) {
			this.pageNo = MAX_PAGE_NO;
		} else {
			this.pageNo = pageNo;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 0) {
			this.pageSize = DEFAULT_PAGE_SIZE;
		} else if (pageSize > MAX_PAGE_SIZE) {
			this.pageSize = MAX_PAGE_SIZE;
		} else {
			this.pageSize = pageSize;
		}
	}

	public int getStartRow() {
		return (pageNo - 1) * pageSize;
	}

	public int getEndRow() {
		return pageNo * pageSize;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(Long creatorUserId) {
		this.creatorUserId = creatorUserId;
	}
}
