package cn.team.mapper.hotel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import cn.team.entity.Hotel;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface HotelMapper  extends Mapper<Hotel> ,MySqlMapper<Hotel> {
	/**
	 * 查询酒店详情
	 * @return
	 */
	@Select("SELECT  p.pic_name,p.pic_url, p.pic_intro  FROM `picture` p,hotel_pic h,hotel j where p.pic_id=h.pic_id  and h.hotel_id=j.hotel_id")
	List<Map<Object,String>> selectHotelDetail();
	
	/**
	 * 查询酒店的数量
	 * @return
	 */
	@Select("select count(*) from hotel")
	int selectCountAll();
	
	
	/*@Select("select * from hotel h , scenic s where h.scenic_id=s.scenic_id "
			+ "and hotel_name like '%${name}%'  "
			+ "and status='${status}' "
			+ "limit  ${startIndex},${size}"
			)
			根据name
	*/
	/**
	 * page
	 * size
	 * name
	 * status
	 * 
	 * 编写一个方法 传入四个参数，进行动态拼接sql语句  返回一个字符串对象(sql语句)
	 */
	@SelectProvider(method="selectAllPage",type=HotelMapperSql.class)
	List<Hotel> selectAllPage(@Param("startIndex")int page,@Param("size")int size,@Param("name")String name,@Param("status")String status,@Param("desc")int desc,@Param("hotel")Hotel hotel);
	
	
}
