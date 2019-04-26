package cn.team.mapper.hotel;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.team.entity.Hotel;

public class HotelMapperSql {

	public String selectAllPage(@Param("startIndex")int page,@Param("size")int size,@Param("name")String name,@Param("status")String status,@Param("desc")int desc,@Param("hotel")Hotel hotel){
		StringBuilder sb=new StringBuilder();
		sb.append("select * from hotel where 1=1 ");
		if(hotel!=null){
			if(hotel.getHotelName()!=null&&hotel.getHotelName().length()>0){
				sb.append(" and hotel_name like '%${hotel.hotelName}%' ");
			}
			
			if(hotel.getStatus()!=null&&hotel.getStatus().length()>0){
				sb.append(" and status='${status}' ");
			}
		}
		if(desc==1){
			sb.append(" order by hotel_id desc");
		}
		if(desc==0){
			sb.append(" order by hotel_id ");
		}
		sb.append("limit #{startIndex},#{size}");
		return sb.toString();
	}
}
