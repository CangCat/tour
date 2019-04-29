package cn.team.service.hotel;

import java.util.List;
import java.util.Map;

import cn.team.entity.Room;
import cn.team.utils.PageBean;

public interface RoomService {
	/**
	 * 查询所有
	 * @return
	 */
	List<Room> selectAll();
	
	/**
	 * 插入
	 * @param id
	 * @return
	 */
	Integer insert(Room id);
	
	/**
	 * 根据id进行查询
	 */
	Room selectByPrimaryKey(int id);
	
	/**
	 * 分页查询
	 */
	

	PageBean<Map<String, Object>> selectAllPage(int page, int size, Map<String,Object> map);
}
