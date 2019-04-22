package cn.team.entity;

import java.util.Date;

public class Scenic {
    private Integer scenicId;

    private String scenicName;

    private String scenicAddress;

    private String scenicLink;

    private String scenicTel;

    private String scenicTicket;

    private Double scenicCharge;

    private String scenicPic;

    private String openTime;

    private String endTime;

    private String checkType;

    private String scenicStatus;

    private Date createTime;

    private Date updateTime;

    private String typeOne;

    private String typeTwo;

    private String scenicIntro;

    public Integer getScenicId() {
        return scenicId;
    }

    public void setScenicId(Integer scenicId) {
        this.scenicId = scenicId;
    }

    public String getScenicName() {
        return scenicName;
    }

    public void setScenicName(String scenicName) {
        this.scenicName = scenicName == null ? null : scenicName.trim();
    }

    public String getScenicAddress() {
        return scenicAddress;
    }

    public void setScenicAddress(String scenicAddress) {
        this.scenicAddress = scenicAddress == null ? null : scenicAddress.trim();
    }

    public String getScenicLink() {
        return scenicLink;
    }

    public void setScenicLink(String scenicLink) {
        this.scenicLink = scenicLink == null ? null : scenicLink.trim();
    }

    public String getScenicTel() {
        return scenicTel;
    }

    public void setScenicTel(String scenicTel) {
        this.scenicTel = scenicTel == null ? null : scenicTel.trim();
    }

    public String getScenicTicket() {
        return scenicTicket;
    }

    public void setScenicTicket(String scenicTicket) {
        this.scenicTicket = scenicTicket == null ? null : scenicTicket.trim();
    }

    public Double getScenicCharge() {
        return scenicCharge;
    }

    public void setScenicCharge(Double scenicCharge) {
        this.scenicCharge = scenicCharge;
    }

    public String getScenicPic() {
        return scenicPic;
    }

    public void setScenicPic(String scenicPic) {
        this.scenicPic = scenicPic == null ? null : scenicPic.trim();
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime == null ? null : openTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType == null ? null : checkType.trim();
    }

    public String getScenicStatus() {
        return scenicStatus;
    }

    public void setScenicStatus(String scenicStatus) {
        this.scenicStatus = scenicStatus == null ? null : scenicStatus.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTypeOne() {
        return typeOne;
    }

    public void setTypeOne(String typeOne) {
        this.typeOne = typeOne == null ? null : typeOne.trim();
    }

    public String getTypeTwo() {
        return typeTwo;
    }

    public void setTypeTwo(String typeTwo) {
        this.typeTwo = typeTwo == null ? null : typeTwo.trim();
    }

    public String getScenicIntro() {
        return scenicIntro;
    }

    public void setScenicIntro(String scenicIntro) {
        this.scenicIntro = scenicIntro == null ? null : scenicIntro.trim();
    }
}