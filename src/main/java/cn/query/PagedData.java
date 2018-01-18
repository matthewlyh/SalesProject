package cn.query;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import java.io.Serializable;
import java.util.*;

/**
 * 分页数据 
 * 
 * 
 * 
 */
public class PagedData<T> implements Serializable {

	private static final long serialVersionUID = 4728903762417L;

	/**
	 * 默认分页页码
	 */
	public static final int DEFAULT_PAGE_NO = 1;

	/**
	 * 默认分页每页数量
	 */
	public static final int DEFAULT_PAGE_SIZE = 20;

	/**
	 * 页码
	 */
	private static final String PAGE_NO = "pageNo";

	/**
	 * 每页数量
	 */
	private static final String PAGE_SIZE = "pageSize";

	/**
	 * 总数
	 */
	private static final String TOTAL_NUM = "totalNum";

	/**
	 * 页码总数
	 */
	private static final String TOTAL_PAGE = "totalPage";

	/**
	 * 是否还有更多
	 */
	private static final String HAS_MORE = "hasMore";

	/**
	 * 列表数据
	 */
	private static final String LIST = "list";

	/**
	 * 查询总数
	 */
	private int totalNum = 0;

	/**
	 * 每页数量
	 */
	private int pageSize = DEFAULT_PAGE_SIZE;

	/**
	 * 页码
	 */
	private int pageNo = DEFAULT_PAGE_NO;

	/**
	 * 列表
	 */
	private List<T> list;



	/**
	 * 参数
	 */
	private Map<String, String> args = new HashMap<String, String>();

	public Map<String, Object> translateToMap() {
		Map<String, Object> map = new HashMap<>();
		map.put(PAGE_NO, pageNo);
		map.put(PAGE_SIZE, pageSize);
		map.put(TOTAL_NUM, totalNum);
		map.put(TOTAL_PAGE, getTotalPage());
		map.put(HAS_MORE, getHasMore());
		map.put(LIST, list);
		return map;
	}

	@SuppressWarnings({ "rawtypes", "unchecked"})
	public static PagedData copyOf(PagedData<?> other) {

		PagedData pagedData = new PagedData();
		pagedData.setPageNo(other.getPageNo());
		pagedData.setPageSize(other.getPageSize());
		pagedData.setTotalNum(other.getTotalNum());
		pagedData.setList(other.getList());
		return pagedData;
	}

	public String getPageNumHtml() {
		StringBuffer sb = new StringBuffer();
		// 首页，上一页
		if (this.getPageNo() != 1) {
			sb.append("<li><a href='" + this.getUrl(this.getPageNo() - 1)
					+ "'>«</a></li>");
		}
		// 页码
		if (this.getTotalPage() != 1) {
			int startNum = this.getPageNo() - 3 <= 1 ? 1
					: this.getPageNo() - 3;
			int endNum = this.getPageNo() + 3 >= this.getTotalPage() ? this
					.getTotalPage() : this.getPageNo() + 3;
			if (startNum > 1) {
				sb.append("<li><a href='javascript:void(0);'>...</a></li>");
			}
			for (int i = startNum; i <= endNum; i++) {
				if (i == pageNo) {
					sb.append("<li class='am-active'><a   href='" + this.getUrl(i)
							+ "'>" + i
							+ "</a></li>");
				} else {
					sb.append("<li><a href='" + this.getUrl(i)
							+ "'>" + i
							+ "</a></li>");
				}
			}
			if (endNum < this.getTotalPage()) {
				sb.append("<li><a href='javascript:void(0);'>...</a></li>");
			}
		}
		// 下一页，尾页
		if (this.getPageNo() < this.getTotalPage()) {
			sb.append("<li><a href='" + this.getUrl(this.getPageNo() + 1)
					+ "'>»</a></li>");
		}
		return sb.toString();
	}

	public String getUrl(int num) {
		Iterator<Map.Entry<String, String>> iter = this.getArgs().entrySet()
				.iterator();
		List<String> values = new ArrayList<String>();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			values.add(key + "=" + val);
		}
		values.add("pageNum=" + num);
		return "http:127.0.0.1:8081/StaffPage?" + StringUtils.join(values.toArray(), "&");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {

		if (this.pageNo <= 0) {
			this.pageNo = 1;
			return 1;
		} else {
			return pageNo;
		}
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPage() {
		if (totalNum <= 0 || pageSize <= 0) {
			return 0;
		}
		return (totalNum % pageSize == 0) ? (totalNum / pageSize) : (totalNum / pageSize + 1);
	}

	public boolean getHasMore() {
		return totalNum > pageSize * pageNo;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Map<String, String> getArgs() {
		return args;
	}

	public void setArgs(Map<String, String> args) {
		this.args = args;
	}
}
