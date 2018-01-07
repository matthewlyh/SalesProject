package cn.model;

import java.io.Serializable;

public class Channel implements Serializable {
    private Integer channelId;

    private String channelName;

    private Integer statusCd;

    private Integer lanId;

    private String attrValue1;

    private String attrValue2;

    private String attrValue3;

    private static final long serialVersionUID = 1L;

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public Integer getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(Integer statusCd) {
        this.statusCd = statusCd;
    }

    public Integer getLanId() {
        return lanId;
    }

    public void setLanId(Integer lanId) {
        this.lanId = lanId;
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