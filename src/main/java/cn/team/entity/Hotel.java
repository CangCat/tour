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
@Table(name="hotel")

public class Hotel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hotel_id")
    private Integer hotelId;

	@Column(name="scenic_id")
    private Integer scenicId;

	@Column(name="hotel_class")
    private String hotelClass;

	@Column(name="hotel_name")
    private String hotelName;

	@Column(name="hotel_link")
    private String hotelLink;

	@Column(name="hotel_tel")
    private String hotelTel;

	@Column(name="hotel_address")
    private String hotelAddress;

	@Column(name="hotel_pic")
    private String hotelPic;

	@Column(name="status")
    private String status;

	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name="creat_time")
    private Date creatTime;

	@Column(name="hotel_des")
	private String hotelDes;
	
	@Column(name="hotel_count")
	private Integer hotelCount;
	
	
	
    public Integer getHotelCount() {
		return hotelCount;
	}

	public void setHotelCount(Integer hotelCount) {
		this.hotelCount = hotelCount;
	}

	public String getHotelDes() {
		return hotelDes;
	}

	public void setHotelDes(String hotelDes) {
		this.hotelDes = hotelDes;
	}

	public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getScenicId() {
        return scenicId;
    }

    public void setScenicId(Integer scenicId) {
        this.scenicId = scenicId;
    }

    public String getHotelClass() {
        return hotelClass;
    }

    public void setHotelClass(String hotelClass) {
        this.hotelClass = hotelClass == null ? null : hotelClass.trim();
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    public String getHotelLink() {
        return hotelLink;
    }

    public void setHotelLink(String hotelLink) {
        this.hotelLink = hotelLink == null ? null : hotelLink.trim();
    }

    public String getHotelTel() {
        return hotelTel;
    }

    public void setHotelTel(String hotelTel) {
        this.hotelTel = hotelTel == null ? null : hotelTel.trim();
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress == null ? null : hotelAddress.trim();
    }

    public String getHotelPic() {
        return hotelPic;
    }

    public void setHotelPic(String hotelPic) {
        this.hotelPic = hotelPic == null ? null : hotelPic.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", scenicId=" + scenicId + ", hotelClass=" + hotelClass + ", hotelName="
				+ hotelName + ", hotelLink=" + hotelLink + ", hotelTel=" + hotelTel + ", hotelAddress=" + hotelAddress
				+ ", hotelPic=" + hotelPic + ", status=" + status + ", creatTime=" + creatTime + ", hotelDes="
				+ hotelDes + ", hotelCount=" + hotelCount + "]";
	}

	
    
}