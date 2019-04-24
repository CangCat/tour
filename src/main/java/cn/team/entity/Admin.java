package cn.team.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.KeySql;

@Table(name = "admin")
public class Admin {
	
	
	//
	@Id
    @KeySql(useGeneratedKeys = true)
	//管理员
    private Integer adminId;

    //管理员姓名
    private String name;

    //登陆名
    private String loginName;

    //登陆密码
    private String password;

    //手机号
    private String tel;

    //性别 0-女  1-男
    private String gender;

    //图片
    private String pic;

    //管理员状态 0-正常使用   1-停用
    private String adminStatus;

    //注册时间
    private Date registerTime;

    //修改时间
    private Date updateTime;

    //管理员类型  分配权限用的 0-有所有权限 但不包括审核权限
    private String adminType;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus == null ? null : adminStatus.trim();
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAdminType() {
        return adminType;
    }

    public void setAdminType(String adminType) {
        this.adminType = adminType == null ? null : adminType.trim();
    }

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", loginName=" + loginName + ", password=" + password
				+ ", tel=" + tel + ", gender=" + gender + ", pic=" + pic + ", adminStatus=" + adminStatus
				+ ", registerTime=" + registerTime + ", updateTime=" + updateTime + ", adminType=" + adminType + "]";
	}
    
    
    
    
}