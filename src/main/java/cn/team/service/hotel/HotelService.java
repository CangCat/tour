package cn.team.service.hotel;


import java.util.List;
import java.util.Map;

import cn.team.entity.Hotel;
import cn.team.utils.PageBean;

public interface HotelService {

	/**
	 * 查询所有酒店
	 * @return
	 */
	
	List<Hotel> selectAll();
	
	/**
	 * 插入酒店信息
	 * @param record
	 * @return
	 */
	Integer insert(Hotel record);
	
	
	/**
	 * 根据id进行查询
	 */
	Hotel selectByPrimaryKey(int id);
	
	/**
	 * 删除
	 */
	Integer deleteByPrimayKey(Hotel record);
	/**
	 * 更新
	 */
	Integer updateByPrimaryKeySelective(Hotel record);
	Integer updateHotel(Hotel hotel);
	
	/**
	 * 酒店详情
	 */
	List<Map<Object,String>> selectHotelDetail();
	/**
	 * 分页
	 */
	

	PageBean<Hotel> selectAllPage(int page, int size, String name, String status, int desc);
	
	
}
