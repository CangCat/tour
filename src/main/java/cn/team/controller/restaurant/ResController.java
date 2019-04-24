package cn.team.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.team.entity.Restaurant;
import cn.team.service.restaurant.RestaurantService;

@Controller
@RequestMapping("res")
public class ResController {

	@Autowired
	RestaurantService service;
	
	@RequestMapping("toList")
	public String toResList(ModelMap map){
		map.put("list", service.selectAll());
		return "admin/index/restaurant-list";
	}
	
	@RequestMapping("toAdd")
	public String toAdd(){
		return "admin/index/restaurant-add";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable Integer id){
		Restaurant restaurant = new Restaurant();
		restaurant.setRestId(id);
		restaurant.setStatus("3");
		service.updateByPrimaryKey(restaurant);
		
		return "redirect:/res/toList";
		
	}
	
	@RequestMapping("deleteAll")
	public String deleteAll(int...dis){
		return "toList";
	}
	
	@RequestMapping("toDetail")
	public String toDetail(ModelMap map,Integer id){
		Restaurant restaurant = service.selectByPrimaryKey(id);
		map.put("rets", restaurant);
		
		
		return "admin/index/restaurant-detail";
	}
	
}
