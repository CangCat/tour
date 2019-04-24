package cn.team.mapper.travel;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import cn.team.entity.Travels;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 游记的持久层处理
 * 
 * Mapper<Travels>,MySqlMapper<Travels>(个人理解是简化持久层的接口，对于单表操作不需要再额外提供mapper的crud操作)
 * @author JLB
 *
 */
@org.apache.ibatis.annotations.Mapper
public interface TravelsMapper extends Mapper<Travels>,MySqlMapper<Travels> {

	
	/**
	 * 游记表，用户表，景点表多表多条件分页查询（提供给游记service使用）
	 * @param startIndex  开始索引
	 * @param size 每页多少行
	 * @param status 评论状态
	 * @param scenicName 景点名模糊
	 * @param userName 用户名模糊
	 * @return
	 */
	@SelectProvider(type=TravelsSqlProvider.class,method="selectByPage")
	List<Map<String,Object>> selectByPage(@Param(value="startIndex")Integer startIndex, @Param(value="size")Integer size, String status, String scenicName,String userName);
	
	/**
	 * 游记表，用户表，景点表 查询过滤条件的总行数 （提供给游记service使用）
	 * @param status 评论状态
	 * @param scenicName 景点名模糊
	 * @param userName 用户名模糊
	 * @return
	 */
	@SelectProvider(type=TravelsSqlProvider.class,method="selectCountAll")
	int selectCountAll(String status, String scenicName,String userName);
}
