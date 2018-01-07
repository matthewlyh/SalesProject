package cn.model;

import java.io.Serializable;

public class Gold implements Serializable {
    private Integer goldId;

    private Integer staffId;

    private Integer prodOfferId;

    private Integer channelId;

    private Integer lanId;

    private Integer custOrderId;

    private Float gold;

    private String attrValue1;

    private String attrValue2;

    private String attrValue3;

    private static final long serialVersionUID = 1L;

    public Integer getGoldId() {
        return goldId;
    }

    public void setGoldId(Integer goldId) {
        this.goldId = goldId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getProdOfferId() {
        return prodOfferId;
    }

    public void setProdOfferId(Integer prodOfferId) {
        this.prodOfferId = prodOfferId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getLanId() {
        return lanId;
    }

    public void setLanId(Integer lanId) {
        this.lanId = lanId;
    }

    public Integer getCustOrderId() {
        return custOrderId;
    }

    public void setCustOrderId(Integer custOrderId) {
        this.custOrderId = custOrderId;
    }

    public Float getGold() {
        return gold;
    }

    public void setGold(Float gold) {
        this.gold = gold;
    }

    public String getAttrValue1() {
        return attrValue1;
    }

    public void setAttrValue1(String attrValue1) {
        this.attrValue1 = attrValue1 == null ? null : attrValue1.trim();
    }

    public String getAttrValue2() {
        return attrValue2;
    }

    public void setAttrValue2(String attrValue2) {
        this.attrValue2 = attrValue2 == null ? null : attrValue2.trim();
    }

    public String getAttrValue3() {
        return attrValue3;
    }

    public void setAttrValue3(String attrValue3) {
        this.attrValue3 = attrValue3 == null ? null : attrValue3.trim();
    }
}