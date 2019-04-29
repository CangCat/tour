package cn.team.mapper.hotel;

import org.apache.ibatis.annotations.Param;


public class HotelOrderMapperSql {


	public String selectAllPage(@Param("startIndex")int page,@Param("size")int size,@Param("name")String name,@Param("status")String status,@Param("desc")int desc){
		StringBuilder sb=new StringBuilder();
		sb.append("select  hr.*,u.user_name,h.hotel_name  ");
		sb.append(" from hotelorder hr,hotel h,usersOne u where ");
		sb.append(" u.user_id=hr.user_id and  hr.hotel_id=h.hotel_id ");
		if(name!=null&&name.length()>0){
			
			sb.append(" and h.hotel_name like concat('%',#{name},'%') ");
		}
		
		if(status!=null&&status.length()>0){
			sb.append(" and hr.status=#{status} ");
		}
		if(desc==1){
			sb.append(" order by hr.order_id desc ");
		}
		if(desc==0){
			sb.append(" order by hr.order_id ");
		}
		sb.append(" limit #{startIndex},#{size}");
		System.out.println(sb.toString());
		return sb.toString();
	}
}
