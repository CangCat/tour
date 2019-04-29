package cn.team.mapper.hotel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import cn.team.entity.Hotel;
import cn.team.entity.Hotelorder;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface HotelRoderMapper extends Mapper<Hotelorder> ,MySqlMapper<Hotel>  {
	
	
	
	@Select("select count(*) from hotelorder")
	int selectCountAll();
	
	@SelectProvider(method="selectAllPage",type=HotelOrderMapperSql.class)
	List<Map<String,Object>> selectAllPage(@Param("startIndex")int page,@Param("size")int size,@Param("name")String name,@Param("status")String status,@Param("desc")int desc);
	
}
