package cn.team.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.KeySql;

@Table
public class Restaurant {
	
	@Id
	@KeySql(useGeneratedKeys=true)
    private Integer restId;

    private Integer scenicId;

    private String restName;

    private String restTel;

    private String restPic;

    private String status;

    private Date createTime;

    private String restIntro;
    
    private String restAddress;
    
    private Scenic scenic;
    
    public Scenic getScenic() {
		return scenic;
	}

	public void setScenic(Scenic scenic) {
		this.scenic = scenic;
	}

	@Override
	public String toString() {
		return "Restaurant [restId=" + restId + ", scenicId=" + scenicId + ", restName=" + restName + ", restTel="
				+ restTel + ", restPic=" + restPic + ", status=" + status + ", createTime=" + createTime
				+ ", restIntro=" + restIntro + ", restAddress=" + restAddress + "]";
	}

	public String getRestAddress() {
		return restAddress;
	}

	public void setRestAddress(String restAddress) {
		this.restAddress = restAddress;
	}

	public Integer getRestId() {
        return restId;
    }

    public void setRestId(Integer restId) {
        this.restId = restId;
    }

    public Integer getScenicId() {
        return scenicId;
    }

    public void setScenicId(Integer scenicId) {
        this.scenicId = scenicId;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName == null ? null : restName.trim();
    }

    public String getRestTel() {
        return restTel;
    }

    public void setRestTel(String restTel) {
        this.restTel = restTel == null ? null : restTel.trim();
    }

    public String getRestPic() {
        return restPic;
    }

    public void setRestPic(String restPic) {
        this.restPic = restPic == null ? null : restPic.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRestIntro() {
        return restIntro;
    }

    public void setRestIntro(String restIntro) {
        this.restIntro = restIntro == null ? null : restIntro.trim();
    }
}