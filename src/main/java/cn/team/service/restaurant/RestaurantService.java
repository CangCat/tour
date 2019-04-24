package cn.team.service.restaurant;

import java.util.List;

import cn.team.entity.Restaurant;

public interface RestaurantService {
	public List<Restaurant> selectAll();
	
	public Restaurant selectByPrimaryKey(Integer restId);
	
	public int updateByPrimaryKey(Restaurant rest);
}
