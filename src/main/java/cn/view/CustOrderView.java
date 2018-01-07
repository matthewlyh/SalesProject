package cn.view;

public class CustOrderView {
    private int cust_order_id;
    private String  cust_order_date;
    private String staff_name;
    private String prod_offer_name;
    private String product_name;
    private float gold;
    
    
    
    
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public int getCust_order_id() {
		return cust_order_id;
	}
	public void setCust_order_id(int cust_order_id) {
		this.cust_order_id = cust_order_id;
	}
	public String getCust_order_date() {
		return cust_order_date;
	}
	public void setCust_order_date(String cust_order_date) {
		this.cust_order_date = cust_order_date;
	}
	public String getProd_offer_name() {
		return prod_offer_name;
	}
	public void setProd_offer_name(String prod_offer_name) {
		this.prod_offer_name = prod_offer_name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public float getGold() {
		return gold;
	}
	public void setGold(float gold) {
		this.gold = gold;
	}
	
}
