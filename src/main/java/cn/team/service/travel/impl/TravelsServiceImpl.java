package cn.team.service.travel.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.team.entity.Travels;
import cn.team.mapper.travel.TravelsMapper;
import cn.team.service.travel.TravelService;
import cn.team.utils.PageBean;

@Service
public class TravelsServiceImpl implements TravelService {

	@Autowired
	TravelsMapper mapper;
	
	/**
	 * 查询所有游记
	 */
	@Override
	public List<Travels> findAllTravels() {
		return mapper.selectAll();
	}

	/**
	 * 查询游记详细信息通过游记id
	 */
	@Override
	public Travels selectOneById(Travels travel) {
		return mapper.selectByPrimaryKey(travel);
	}

	

	/**
	 * 查询所有信息通过分页
	 */
	@Override
	public PageBean<Map<String, Object>> selectByPage(Integer pageNum, Integer size, String status, String sName, String uName){
		int total = mapper.selectCountAll(status, sName, uName);
		PageBean<Map<String, Object>> pageBean = new PageBean<Map<String, Object>>( size,  pageNum,  total);
		List<Map<String, Object>> list = mapper.selectByPage(pageBean.getStartIndex(), size, status, sName, uName);
		pageBean.setList(list);
		return pageBean;
	}
	
	/**
	 * 修改游记信息
	 */
	@Override
	public int updateTravels(Travels travels){
		return mapper.updateTravel(travels);
	}
	
	@Override
	public Map<String,Object> selectInfoByTravelId(Integer id){
		return mapper.selectInfoByTravelId(id);
	}

	@Override
	public int updateTravel(Travels travels) {
		return mapper.updateTravel(travels);
	}
}
