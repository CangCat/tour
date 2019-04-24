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


	PageBean<Map<String, Object>> selectByPage(Integer pageNum, Integer size, String status, String sName, String uName);
	
	
}
