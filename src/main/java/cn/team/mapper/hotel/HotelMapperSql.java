package cn.team.mapper.hotel;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.team.entity.Hotel;

public class HotelMapperSql {

	public String selectAllPage(@Param("startIndex")int page,@Param("size")int size,@Param("name")String name,@Param("status")String status,@Param("desc")int desc){
		StringBuilder sb=new StringBuilder();
		sb.append("select * from hotel where 1=1 ");
		
		if(name!=null&&name.length()>0){
			sb.append(" and hotel_name like concat('%',#{name},'%') ");
		}
			
		if(status!=null&&status.length()>0){
			sb.append(" and status=#{status} ");
		}
		
		if(desc==1){
			sb.append(" order by hotel_id desc ");
		}
		if(desc==0){
			sb.append(" order by hotel_id ");
		}
		sb.append(" limit #{startIndex},#{size}");
		
		return sb.toString();
	}
	
	public String updateHotel(Hotel hotel){
		StringBuilder sb=new StringBuilder();
		sb.append("update hotel set ");
		if(hotel.getHotelName()!=null&&hotel.getHotelName().equals("")){
			sb.append(" hotel_name=#{hotelName} ");
		}
		if(hotel.getScenicId()!=null){
			sb.append(" scenic_id=#{scenicId} ");
		}
		if(hotel.getHotelClass()!=null&&hotel.getHotelClass().equals("" )){
			sb.append(" hotel_class=#{hotelClass} ");
		}
		if(hotel.getHotelLink()!=null&&hotel.getHotelLink().equals("")){
			sb.append(" hotel_link=#{hotelLink} ");
		}
		if(hotel.getHotelTel()!=null&&hotel.getHotelTel().equals("")){
			sb.append(" hotel_tel=#{hotelTel} ");
		}
		if(hotel.getHotelAddress()!=null&&hotel.getHotelAddress().equals("")){
			sb.append(" hotel_address=#{hotelAddress} ");
			
		}
		if(hotel.getHotelPic()!=null&&hotel.getHotelPic().equals("")){
			sb.append(" hotel_pic=#{hotelPic} ");
		}
		if(hotel.getStatus()!=null&&!hotel.getStatus().equals("")){
			sb.append(" status=#{status}");
		}
		if(hotel.getCreatTime()!=null&&hotel.getCreatTime().equals("")){
			sb.append(" creat_time=#{creatTime}");
		}
		if(hotel.getHotelDes()!=null&& hotel.getHotelDes().equals("")){
			sb.append(" hotel_des=#{hotelDes}");
		}
		if(hotel.getHotelCount()!=null&& hotel.getHotelCount().equals("")){
			sb.append(" hotel_count=#{hotelCount}");
		}
		
		sb.append(" where hotel_id=#{hotelId}");
		System.out.println(sb.toString());
		return sb.toString();
	}
}
