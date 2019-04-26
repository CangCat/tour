package cn.team.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="hotelorder")
public class Hotelorder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
    private Integer orderId;
	
	@Column(name="user_id")
    private Integer userId;
	
	@Column(name="hotel_id")
    private Integer hotelId;
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name="hotel_checkin")
    private Date hotelCheckin;
	
	@Column(name="room_count")
    private Integer roomCount;
	
	@Column(name="status")
    private String status;
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name="create_time")
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

	@Override
	public String toString() {
		return "Hotelorder [orderId=" + orderId + ", userId=" + userId + ", hotelId=" + hotelId + ", hotelCheckin="
				+ hotelCheckin + ", roomCount=" + roomCount + ", status=" + status + ", createTime=" + createTime + "]";
	}
    
}