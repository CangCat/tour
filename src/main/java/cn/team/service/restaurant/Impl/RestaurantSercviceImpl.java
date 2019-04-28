package cn.team.service.restaurant.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.team.entity.Restaurant;
import cn.team.entity.Scenic;
import cn.team.mapper.RestaurantMapper;
import cn.team.mapper.cangcat.ScenicMapper;
import cn.team.service.restaurant.RestaurantService;
import cn.team.utils.PageBean;

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

	@Override
	public int deleteByIds(String ids) {
		return mapper.deleteByIds(ids);
	}

	@Override
	public PageBean<Restaurant> selectAllByPage(int page, int size, Restaurant restaurant) {
		int count = mapper.selectCount(restaurant);
		PageBean<Restaurant> pageBean = new PageBean<Restaurant>(size,page,count);
		List<Restaurant> list = mapper.selectAllByPage(pageBean.getStartIndex(), size);
		for (Restaurant res : list) {
			Scenic key = scenicMapper.selectByPrimaryKey(res.getScenicId());
			res.setScenic(key);
		}
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public int selectCount(Restaurant restaurant) {
		return mapper.selectCount(restaurant);
	}
	
}
