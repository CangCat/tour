package cn.team.service.hotel;

import java.util.List;
import java.util.Map;


import cn.team.entity.Hotelorder;
import cn.team.utils.PageBean;

public interface HotelRoderService {

	/**
	 * 查询酒店订单
	 * @return
	 */
	List<Hotelorder> selectAll();
	
	/**
	 * 根据酒店id进行查询
	 */
	Hotelorder selectByPrimayKey(int id);
	/**
	 * 修改酒店订单
	 * @param record
	 * @return
	 */
	Integer updateByPrimaryKeySelective(Hotelorder record);

	/**
	 * 带条件的分页
	 * @param page
	 * @param size
	 * @param name
	 * @param status
	 * @param desc
	 * @return
	 */
	PageBean<Map<String, Object>> selectAllPage(int page, int size, String name, String status, int desc);
	
}
