package cn.team.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import tk.mybatis.mapper.annotation.KeySql;

@Table
public class Travels {
	
	@Id
	@KeySql(useGeneratedKeys=true)
    private Integer travelId;

    private Integer userId;

    private Integer scenicId;

    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    private Integer prefaction;

    private Integer lookNum;

    private String picture;

    private String status;

    private Integer likeNum;

    private String intro;

    public Integer getTravelId() {
        return travelId;
    }

    public void setTravelId(Integer travelId) {
        this.travelId = travelId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getScenicId() {
        return scenicId;
    }

    public void setScenicId(Integer scenicId) {
        this.scenicId = scenicId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPrefaction() {
        return prefaction;
    }

    public void setPrefaction(Integer prefaction) {
        this.prefaction = prefaction;
    }

    public Integer getLookNum() {
        return lookNum;
    }

    public void setLookNum(Integer lookNum) {
        this.lookNum = lookNum;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

	@Override
	public String toString() {
		return "Travels [travelId=" + travelId + ", userId=" + userId + ", scenicId=" + scenicId + ", createTime="
				+ createTime + ", prefaction=" + prefaction + ", lookNum=" + lookNum + ", picture=" + picture
				+ ", status=" + status + ", likeNum=" + likeNum + ", intro=" + intro + "]";
	}
    
}