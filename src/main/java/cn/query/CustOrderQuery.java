package cn.query;

/**
 * Created by Administrator on 2017/10/26.
 */
public class CustOrderQuery {
    private int cust_order_id;
    private int  prod_offer_id;
    private String prod_offer_name;
    private String  cust_order_date;
    private String product_name;
    private String staff_name;
    private int offer_type;
    private float gold;
    private int bool;
	public int getCust_order_id() {
		return cust_order_id;
	}
	public void setCust_order_id(int cust_order_id) {
		this.cust_order_id = cust_order_id;
	}
	public int getProd_offer_id() {
		return prod_offer_id;
	}
	public void setProd_offer_id(int prod_offer_id) {
		this.prod_offer_id = prod_offer_id;
	}
	public String getProd_offer_name() {
		return prod_offer_name;
	}
	public void setProd_offer_name(String prod_offer_name) {
		this.prod_offer_name = prod_offer_name;
	}
	public String getCust_order_date() {
		return cust_order_date;
	}
	public void setCust_order_date(String cust_order_date) {
		this.cust_order_date = cust_order_date;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public int getOffer_type() {
		return offer_type;
	}
	public void setOffer_type(int offer_type) {
		this.offer_type = offer_type;
	}
	public float getGold() {
		return gold;
	}
	public void setGold(float gold) {
		this.gold = gold;
	}
	public int getBool() {
		return bool;
	}
	public void setBool(int bool) {
		this.bool = bool;
	}

}
