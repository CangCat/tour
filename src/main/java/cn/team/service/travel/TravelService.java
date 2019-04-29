package cn.team.service.travel;

import java.util.List;
import java.util.Map;

import cn.team.entity.Travels;
import cn.team.utils.PageBean;

public interface TravelService {

	/**
	 * 查询所有景点游记
	 * @return
	 */
	List<Travels> findAllTravels();
	
	
	/**
	 * 根据游记id查询游记的详细信息
	 * @return
	 */
	Travels selectOneById(Travels travel);


	/**
	 * 带条件动态分页查询
	 * @param pageNum
	 * @param size
	 * @param status
	 * @param sName
	 * @param uName
	 * @return
	 */
	PageBean<Map<String, Object>> selectByPage(Integer pageNum, Integer size, String status, String sName, String uName);


	/**
	 * 修改游记信息
	 * @param travels
	 * @return
	 */
	int updateTravels(Travels travels);


	/**
	 * 通过游记id查询详细信息
	 * @param id
	 * @return
	 */
	Map<String, Object> selectInfoByTravelId(Integer id);
	
	
	/**
	 * 修改游记信息
	 * @param travels
	 * @return
	 */
	int updateTravel(Travels travels);


	/**
	 * 新增游记数据信息
	 * @param travels
	 * @return
	 */
	int addTravel(Travels travels);

	

	/**
	 * 批量改游记状态
	 * @param travels
	 * @return
	 */
	int deleteTravels(int[] aids);
	
}
