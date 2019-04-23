package cn.team.entity;

import java.util.Date;

public class Comment {
    private Integer commId;

    private Integer userId;

    private Integer projectId;

    private Date commTime;

    private Integer perfection;

    private String status;

    private Integer lookNum;

    private String projectType;

    private String commIntro;

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Date getCommTime() {
        return commTime;
    }

    public void setCommTime(Date commTime) {
        this.commTime = commTime;
    }

    public Integer getPerfection() {
        return perfection;
    }

    public void setPerfection(Integer perfection) {
        this.perfection = perfection;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getLookNum() {
        return lookNum;
    }

    public void setLookNum(Integer lookNum) {
        this.lookNum = lookNum;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    public String getCommIntro() {
        return commIntro;
    }

    public void setCommIntro(String commIntro) {
        this.commIntro = commIntro == null ? null : commIntro.trim();
    }

	@Override
	public String toString() {
		return "Comment [commId=" + commId + ", userId=" + userId + ", projectId=" + projectId + ", commTime="
				+ commTime + ", perfection=" + perfection + ", status=" + status + ", lookNum=" + lookNum
				+ ", projectType=" + projectType + ", commIntro=" + commIntro + "]";
	}
}