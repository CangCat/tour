package cn.team.entity;

import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "scenic")
public class Scenic {

    @Id
    @KeySql(useGeneratedKeys = true)  //主键策略  true代表主键递增
    //景点ID
    private Integer scenicId;

    //景点名称
    private String scenicName;

    //景点详细地址
    private String scenicAddress;

    //联系人
    private String scenicLink;

    //联系电话
    private String scenicTel;

    //购票类型：0-1人票  6-团票
    private String scenicTicket;

    //收费金额
    private Double scenicCharge;

    //景点图片
    private String scenicPic;

    //开放时间
    private String openTime;

    //结束时间
    private String endTime;

    //审核状态：0-审核 1-未审核
    private String checkType;

    //状态 0-开放  1-删除
    private String scenicStatus;

    //创建时间
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date createTime;

    //修改时间
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date updateTime;

    //类型1    1-省内游  2-国内游  3-港澳台游  4-国外游
    private String typeOne;

    //类型2    1-热门主题  2-热门目的地  3-自由行  4-跟团  5-邮轮游
    private String typeTwo;

    //景点简介
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

    @Override
    public String toString() {
        return "Scenic{" +
                "scenicId=" + scenicId +
                ", scenicName='" + scenicName + '\'' +
                ", scenicAddress='" + scenicAddress + '\'' +
                ", scenicLink='" + scenicLink + '\'' +
                ", scenicTel='" + scenicTel + '\'' +
                ", scenicTicket='" + scenicTicket + '\'' +
                ", scenicCharge=" + scenicCharge +
                ", scenicPic='" + scenicPic + '\'' +
                ", openTime='" + openTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", checkType='" + checkType + '\'' +
                ", scenicStatus='" + scenicStatus + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", typeOne='" + typeOne + '\'' +
                ", typeTwo='" + typeTwo + '\'' +
                ", scenicIntro='" + scenicIntro + '\'' +
                '}';
    }
}