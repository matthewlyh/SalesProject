package cn.query;

public class StaffQuery extends BaseQuery {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2939697634160861181L;
	private String staffCode;
	private String staffName;
	private Integer lanId;
	private Integer staffType;

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Integer getLanId() {
		return lanId;
	}

	public void setLanId(Integer lanId) {
		this.lanId = lanId;
	}

	public Integer getStaffType() {
		return staffType;
	}

	public void setStaffType(Integer staffType) {
		this.staffType = staffType;
	}

}
