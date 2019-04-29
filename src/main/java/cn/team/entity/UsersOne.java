package cn.team.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.KeySql;

@Table(name = "usersOne")
public class UsersOne {
	
	//
	@Id
    @KeySql(useGeneratedKeys = true)
	//用户id
    private Integer userId;

    //用户名
    private String userName;

    //用于登陆的邮件
    private String email;

    //加密的登陆密码
    private String password;

    //联系号码（手机号）
    private String tel;

    //性别：0-女   1-男
    private String gender;

    //用户状态：0-注册   1-删除
    private String userStatus;

    //用户头像
    private String pic;

    //注册时间
    private Date registerTime;

    //修改时间
    private Date updateTime;
    
    private List<Comment> comments;
    
    

    public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
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

	@Override
	public String toString() {
		return "UsersOne [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", tel=" + tel + ", gender=" + gender + ", userStatus=" + userStatus + ", pic=" + pic
				+ ", registerTime=" + registerTime + ", updateTime=" + updateTime + "]";
	}
    
	
    
}