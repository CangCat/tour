package cn.team.mapper.function;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.team.entity.Functional;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface FunctionMapper extends Mapper<Functional>,MySqlMapper<Functional> {

	@Select("select f.*,s.scenic_name from functional f,scenic s where f.scenic_id=s.scenic_id limit #{startIndex},#{size}")
	List<Map<String,Object>> selectFunctions(@Param("startIndex")Integer startIndex, @Param("size")Integer size);
}
