package cn.team.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import tk.mybatis.mapper.annotation.KeySql;

@Table(name="functional")
public class Functional {
	@Id
	@KeySql(useGeneratedKeys=true)
    private Integer funId;

    private Integer scenicId;

    private String funName;

    private String funTime;

    private String funAddress;

    private String funPic;

    private String status;

    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    private String funIntro;

    public Integer getFunId() {
        return funId;
    }

    public void setFunId(Integer funId) {
        this.funId = funId;
    }

    public Integer getScenicId() {
        return scenicId;
    }

    public void setScenicId(Integer scenicId) {
        this.scenicId = scenicId;
    }

    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName == null ? null : funName.trim();
    }

    public String getFunTime() {
        return funTime;
    }

    public void setFunTime(String funTime) {
        this.funTime = funTime == null ? null : funTime.trim();
    }

    public String getFunAddress() {
        return funAddress;
    }

    public void setFunAddress(String funAddress) {
        this.funAddress = funAddress == null ? null : funAddress.trim();
    }

    public String getFunPic() {
        return funPic;
    }

    public void setFunPic(String funPic) {
        this.funPic = funPic == null ? null : funPic.trim();
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

    public String getFunIntro() {
        return funIntro;
    }

    public void setFunIntro(String funIntro) {
        this.funIntro = funIntro == null ? null : funIntro.trim();
    }

	@Override
	public String toString() {
		return "Function [funId=" + funId + ", scenicId=" + scenicId + ", funName=" + funName + ", funTime=" + funTime
				+ ", funAddress=" + funAddress + ", funPic=" + funPic + ", status=" + status + ", createTime="
				+ createTime + ", funIntro=" + funIntro + "]";
	}
    
}