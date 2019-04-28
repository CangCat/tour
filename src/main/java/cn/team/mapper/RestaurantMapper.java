package cn.team.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.team.entity.Restaurant;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
/**
 * 餐厅的mapper层，全都是自动生成的所以屁用没有
 * @author mr
 *
 */
@org.apache.ibatis.annotations.Mapper
public interface RestaurantMapper extends Mapper<Restaurant> , MySqlMapper<Restaurant> ,IdsMapper<Restaurant>{
	/**
	 * 分页查询
	 * @param startIndex  第几页
	 * @param size 显示几条
	 * @return 该页的数据集合
	 */
	@Select("select rest_id,scenic_id,rest_name,rest_tel,rest_intro,rest_pic,status,create_time,rest_address from restaurant limit #{startIndex},#{size}")
	List<Restaurant> selectAllByPage(@Param("startIndex")int startIndex,@Param("size")int size);
	
}
