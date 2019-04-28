package cn.team.controller.restaurant;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.team.entity.Restaurant;
import cn.team.service.restaurant.RestaurantService;
import cn.team.utils.PageBean;

@Controller
@RequestMapping("res")
public class ResController {

	@Autowired
	RestaurantService service;
	
	
	/**
	 * tolist，用于跳转页面，map的值交给doList解决了，所以删了
	 * @param map
	 * @return
	 */
	@RequestMapping("toList")
	public String toResList(){
		return "admin/index/restaurant-list";
	}
	
	/**
	 * 用于给List分页数据，list数据
	 * @param restaurant 
	 * @param page 第几页
	 * @param limit 查几条
	 * @return 全部条数，从第0页开始，      
	 * */
	@RequestMapping("doList")
	@ResponseBody
	public Map<String, Object> doList(Restaurant restaurant,Integer page,Integer limit){
		System.out.println("dolist");
		Map<String,Object> map=new HashMap<String,Object>();
		PageBean<Restaurant> pageBean = service.selectAllByPage(page, limit, restaurant);
		int count = service.selectCount(restaurant);
		map.put("count", count);
		map.put("code", 0);
		map.put("data", pageBean.getList());
		return map;
	}
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd(){
		return "admin/index/restaurant-add";
	}
	
	/**
	 * 根据传入的ID逻辑删除
	 * @param id
	 * @return
	 */
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable Integer id){
		Restaurant restaurant = new Restaurant();
		restaurant.setRestId(id);
		restaurant.setStatus("3");
		service.updateByPrimaryKey(restaurant);
		
		return "redirect:/res/toList";
		
	}
	
	/**
	 * 根据传入的ids 批量逻辑删除
	 * @param ids id的集合字符串，用逗号隔开
	 * @return
	 */
	@RequestMapping("deleteAll")
	public String deleteAll(String ids){
		//service.deleteByIds(ids);
		String id = ids.substring(0, ids.length()-1);
		String[] strings = id.split(",");
		int[] idss=new int[strings.length];
		for (int i=0;i<strings.length;i++) {
			idss[i] = Integer.valueOf(strings[i]);
			System.out.println(idss[i]);
		}
		
		for (int i : idss) {
			Restaurant restaurant = new Restaurant();
			restaurant.setRestId(i);
			restaurant.setStatus("3");
			service.updateByPrimaryKey(restaurant);
		}
		return "redirect:/res/toList";
	}
	
	/**
	 * 跳转到修改页面，根据传入的id将对象绑定到页面
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping("toDetail")
	public String toDetail(ModelMap map,Integer id){
		Restaurant restaurant = service.selectByPrimaryKey(id);
		map.put("rets", restaurant);
				
		return "admin/index/restaurant-detail";
	}
	

	
}
