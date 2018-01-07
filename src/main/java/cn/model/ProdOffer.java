package cn.model;

import java.io.Serializable;
import java.util.Date;

public class ProdOffer implements Serializable {
    private Integer prodOfferId;

    private String prodOfferName;

    private Integer offerType;

    private Integer statusCd;

    private Date statusDate;

    private Float gold;

    private String attrValue1;

    private String attrValue2;

    private String attrValue3;

    private static final long serialVersionUID = 1L;

    public Integer getProdOfferId() {
        return prodOfferId;
    }

    public void setProdOfferId(Integer prodOfferId) {
        this.prodOfferId = prodOfferId;
    }

    public String getProdOfferName() {
        return prodOfferName;
    }

    public void setProdOfferName(String prodOfferName) {
        this.prodOfferName = prodOfferName == null ? null : prodOfferName.trim();
    }

    public Integer getOfferType() {
        return offerType;
    }

    public void setOfferType(Integer offerType) {
        this.offerType = offerType;
    }

    public Integer getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(Integer statusCd) {
        this.statusCd = statusCd;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
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