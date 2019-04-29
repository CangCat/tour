package cn.team.mapper.hotel;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public class RoomMapperSql {

	public String selectAllPage(@Param("startIndex")int page,@Param("size")int size,@Param("map")Map<String,Object> map){
		
		StringBuilder sb=new StringBuilder();
		
		sb.append("select r.room_id,r.room_name,r.room_price,r.room_remark,r.room_pic ,h.hotel_name ");
		sb.append(" from hotel h,room r where ");
		
		sb.append(" h.hotel_id=r.hotel_id  ");
		sb.append(" limit #{startIndex},#{size}");
		return sb.toString();
		
	}
	
}
