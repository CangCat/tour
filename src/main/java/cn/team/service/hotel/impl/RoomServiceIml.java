package cn.team.service.hotel.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.team.entity.Room;
import cn.team.mapper.hotel.RoomMapper;
import cn.team.service.hotel.RoomService;
import cn.team.utils.PageBean;
@Service
@Transactional
public class RoomServiceIml implements RoomService{

	@Autowired
	RoomMapper mapper;
	
	
	
	@Override
	public List<Room> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}



	@Override
	public Integer insert(Room id) {
		
		return mapper.insert(id);
	}



	@Override
	public PageBean<Map<String,Object>> selectAllPage(int page, int size,Map<String,Object> map) {
		Integer total = mapper.selectCountAll();
		PageBean<Map<String,Object>> pageBean=new PageBean<Map<String,Object>>(size,page,total);
		List<Map<String,Object>> list = mapper.selectAllPage(pageBean.getStartIndex(), size, map);
		pageBean.setList(list);
		return pageBean;
	}



	@Override
	public Room selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}



	



}
