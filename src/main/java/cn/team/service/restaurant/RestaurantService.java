package cn.team.service.restaurant;

import java.util.List;

import cn.team.entity.Restaurant;
import cn.team.utils.PageBean;
/**
 * service接口
 * @author JLB
 *
 */
public interface RestaurantService {
	
	/**
	 * 查询所有的restaurant（餐厅
	 * @return 数据库所有餐厅的数据集合
	 */
	public List<Restaurant> selectAll();
	
	/**
	 * 根据传入的ID查询餐厅
	 * @param restId 餐厅的ID
	 * @return 跟ID对应的餐厅
	 */
	public Restaurant selectByPrimaryKey(Integer restId);
	
	/**
	 * 动态更新，
	 * @param rest 一个餐厅对象，要set主键
	 * @return 受记录条数
	 */
	public int updateByPrimaryKey(Restaurant rest);
	
	/**
	 * 根据ID的集合删除 餐厅
	 * @param ids 餐厅对象的集合，不过是一个string，前台接的时候要注意
	 * @return
	 */
	public int deleteByIds(String ids);
	
	/**
	 * 查询数据库中有多少条数据 select Count(*)
	 * @param restaurant
	 * @return
	 */
	int selectCount(Restaurant restaurant);
	
	/**
	 * 根据传入的参数，生成一个PageBean对象，对象中的自带一个该页的LIST
	 * @param page 第几页
	 * @param size 显示多少条
	 * @param restaurant 传一个这个进去，空的也没啥，selectCount要用到
	 * @return PageBean对象，对象中的自带一个该页的LIST
	 */
	public PageBean<Restaurant> selectAllByPage(int page,int size,Restaurant restaurant);
}
