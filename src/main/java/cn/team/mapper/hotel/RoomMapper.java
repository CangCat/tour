package cn.team.mapper.hotel;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import cn.team.entity.Room;
import tk.mybatis.mapper.common.MySqlMapper;

@Mapper
public interface RoomMapper extends tk.mybatis.mapper.common.Mapper<Room>,MySqlMapper<Room>{

	@Select("select count(*) from room ")
	Integer selectCountAll();
	
	@SelectProvider(method="selectAllPage",type=RoomMapperSql.class)
	List<Map<String, Object>> selectAllPage(@Param("startIndex")int page,@Param("size")int size,@Param("map")Map<String,Object> map);

	
}
