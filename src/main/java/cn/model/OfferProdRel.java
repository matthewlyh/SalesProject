package cn.model;

import java.io.Serializable;

public class OfferProdRel implements Serializable {
    private Integer offerProdRelId;

    private Integer prodOfferId;

    private Integer productId;

    private String attrValue1;

    private String attrValue2;

    private String attrValue3;

    private static final long serialVersionUID = 1L;

    public Integer getOfferProdRelId() {
        return offerProdRelId;
    }

    public void setOfferProdRelId(Integer offerProdRelId) {
        this.offerProdRelId = offerProdRelId;
    }

    public Integer getProdOfferId() {
        return prodOfferId;
    }

    public void setProdOfferId(Integer prodOfferId) {
        this.prodOfferId = prodOfferId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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