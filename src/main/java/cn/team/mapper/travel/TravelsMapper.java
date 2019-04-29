package cn.team.mapper.travel;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

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
	List<Map<String,Object>> selectByPage(@Param(value="startIndex")Integer startIndex, @Param(value="size")Integer size,  @Param("status")String status, @Param("scenicName")String scenicName,@Param("userName")String userName);
	
	/**
	 * 游记表，用户表，景点表 查询过滤条件的总行数 （提供给游记service使用）
	 * @param status 评论状态
	 * @param scenicName 景点名模糊
	 * @param userName 用户名模糊
	 * @return
	 */
	@SelectProvider(type=TravelsSqlProvider.class,method="selectCountAll")
	int selectCountAll(String status, String scenicName,String userName);
	
	/**
	 * 通过游记id动态修改游记信息
	 * @param id
	 * @return
	 */
	@UpdateProvider(type=TravelsSqlProvider.class,method="updateTravel")
	int updateTravel(Travels travels);
	
	/**
	 * 查询所有游记详细信息
	 * @param id
	 * @return
	 */
	@Select("select t.travel_id tId,t.intro intro,t.like_num likeNum,t.look_num lookNum,t.status status,t.create_time createTime,t.prefaction prefaction,t.picture picture,s.scenic_name sName,s.scenic_id sId,u.user_id uId,u.user_name uName from travels t,scenic s,usersOne u where s.scenic_id = t.scenic_id and u.user_id= t.user_id and t.travel_id=#{id}")
	Map<String,Object> selectInfoByTravelId(@Param(value="id")Integer id);
	
	 @UpdateProvider(type=TravelsSqlProvider.class,method="deleteTravels")
	 int deleteTravels(int... ids);
}
