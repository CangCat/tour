package cn.team.service.hotel.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.team.entity.Hotelorder;
import cn.team.mapper.hotel.HotelRoderMapper;
import cn.team.service.hotel.HotelRoderService;
import cn.team.utils.PageBean;

@Service
@Transactional
public class HotelRoderImpl implements HotelRoderService {

	@Autowired
	HotelRoderMapper hrmapper;

	@Override
	public List<Hotelorder> selectAll() {
		// TODO Auto-generated method stub
		return hrmapper.selectAll();
	}

	
	@Override
	public PageBean<Map<String,Object>> selectAllPage(int page, int size, String name, String status, int desc) {
		int total= hrmapper.selectCountAll();
		PageBean<Map<String,Object>> pageBean = new PageBean<Map<String,Object>>(size,page,total);
		List<Map<String,Object>> list = hrmapper.selectAllPage(pageBean.getStartIndex(), size, name, status, desc);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public Integer updateByPrimaryKeySelective(Hotelorder record) {
		// TODO Auto-generated method stub
		return hrmapper.updateByPrimaryKeySelective(record);
	}


	@Override
	public Hotelorder selectByPrimayKey(int id) {
		Hotelorder order = hrmapper.selectByPrimaryKey(id);
		return order;
	}


    
	
}
