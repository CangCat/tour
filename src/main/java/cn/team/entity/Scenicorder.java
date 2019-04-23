package cn.team.entity;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table
public class Scenicorder {

    @Id
    @KeySql(useGeneratedKeys = true)  //主键策略  true代表主键递增
    //订单id
    private Integer orderId;

    //用户id
    private Integer userId;

    //风景id
    private Integer scenicId;

    //购买数量
    private Integer account;

    //订单创建时间
    private Date createTime;

    //订单状态  0-下单成功  1-订单过时  2-订单删除
    private String status;

    //游玩时间
    private Date playTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Date playTime) {
        this.playTime = playTime;
    }

    @Override
    public String toString() {
        return "Scenicorder{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", scenicId=" + scenicId +
                ", account=" + account +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", playTime=" + playTime +
                '}';
    }
}