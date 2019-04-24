package cn.team.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.team.entity.Restaurant;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
/**
 * 餐厅的mapper层，全都是自动生成的所以屁用没有
 * @author mr
 *
 */
@org.apache.ibatis.annotations.Mapper
public interface RestaurantMapper extends Mapper<Restaurant> , MySqlMapper<Restaurant> {
	/**
	 * 分页查询
	 * @return
	 */
	@Select("select res.* from restaurant res")
	public List<Restaurant> selectByPage();
	
}
