package cn.team.service.hotel.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.team.entity.Hotel;
import cn.team.mapper.hotel.HotelMapper;
import cn.team.service.hotel.HotelService;
import cn.team.utils.PageBean;

@Service
@Transactional
public class HotelServicelmpl implements HotelService{

	@Autowired
	HotelMapper hmapper;
	
	@Override
	public List<Hotel> selectAll() {
		// TODO Auto-generated method stub
		return hmapper.selectAll();
	}
	@Override
	public Integer insert(Hotel record) {
		// TODO Auto-generated method stub
		return hmapper.insert(record);
	}

	@Override
	public Hotel selectByPrimaryKey(int id) {
		
		Hotel h = hmapper.selectByPrimaryKey(id);
		return h;
	}
	@Override
	public Integer deleteByPrimayKey(Hotel record) {
		// TODO Auto-generated method stub
		return hmapper.deleteByPrimaryKey(record);
	}
	
	@Override
	public List<Map<Object, String>> selectHotelDetail() {
		
		return hmapper.selectHotelDetail();
	}
	@Override
	public Integer updateByPrimaryKeySelective(Hotel record) {
		// TODO Auto-generated method stub
		return hmapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public PageBean<Hotel> selectAllPage(int page, int size,String name,String status,int desc) {
		int total = hmapper.selectCountAll();
		PageBean<Hotel> pageBean=new PageBean<Hotel>(size,page,total);
		List<Hotel> list = hmapper.selectAllPage(pageBean.getStartIndex(), size, name, status, desc);
		pageBean.setList(list);
		
		return pageBean;
	}
	@Override
	public Integer updateHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hmapper.updateHotel(hotel);
	}
	
	
	
	

}
