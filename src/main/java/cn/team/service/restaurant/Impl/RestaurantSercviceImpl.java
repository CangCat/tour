package cn.team.service.restaurant.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.team.entity.Restaurant;
import cn.team.mapper.RestaurantMapper;
import cn.team.mapper.cangcat.ScenicMapper;
import cn.team.service.restaurant.RestaurantService;

@Service
public class RestaurantSercviceImpl implements RestaurantService{
	
	@Autowired
	RestaurantMapper mapper;
	
	@Autowired
	ScenicMapper scenicMapper;
	
	@Override
	public List<Restaurant> selectAll() {
		List<Restaurant> list = mapper.selectAll();
		for (Restaurant restaurant : list) {
			restaurant.setScenic(scenicMapper.selectByPrimaryKey(restaurant.getScenicId()));
		}
		
		return list;
	}

	@Override
	public Restaurant selectByPrimaryKey(Integer restId) {
		return mapper.selectByPrimaryKey(restId);
	}

	@Override
	public int updateByPrimaryKey(Restaurant rest) {
		return mapper.updateByPrimaryKeySelective(rest);
	}
	
}
