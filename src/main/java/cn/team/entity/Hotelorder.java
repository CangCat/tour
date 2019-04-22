package cn.team.entity;

import java.util.Date;

public class Hotelorder {
    private Integer orderId;

    private Integer userId;

    private Integer hotelId;

    private Date hotelCheckin;

    private Integer roomCount;

    private String status;

    private Date createTime;

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

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Date getHotelCheckin() {
        return hotelCheckin;
    }

    public void setHotelCheckin(Date hotelCheckin) {
        this.hotelCheckin = hotelCheckin;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
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
}