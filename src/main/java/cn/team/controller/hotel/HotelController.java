package cn.team.controller.hotel;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import cn.team.entity.Hotel;

import cn.team.service.cangcat.ScenicService;
import cn.team.service.hotel.HotelService;
import cn.team.utils.PageBean;

@Controller
@RequestMapping("hotel")
public class HotelController {

	@Autowired
	HotelService hservice;
	
	
	@Autowired
	ScenicService sc;
	/**
	 * 分页查询
	 */

	@RequestMapping("toPageList")
	public String toPageList(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="5")int size,String name ,String status,@RequestParam(defaultValue="0")int desc,Hotel hotel,ModelMap map){
		
		map.put("scenic", sc.selectAll());
		PageBean<Hotel> pageBean= hservice.selectAllPage(page, size,name,status,desc,hotel);
		
		List<Hotel> list = pageBean.getList();
	
		
		map.put("pageBean", pageBean);
		
		map.put("name", name);
		
		map.put("status", status);
		map.put("desc", desc);
		
		return "admin/index/hotel-list";
	
	}
	
	/**
	 * 更改
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(int id,ModelMap map){
		Hotel hotel = hservice.selectByPrimaryKey(id);
		map.put("hotel", hotel);
		map.put("scenic", sc.selectAll());
		return "forward:/hotel/doUpdate";
	}
	
	@RequestMapping("doUpdate")
	public String doUpdate(Hotel hotel,ModelMap map){
		Integer result = hservice.updateByPrimaryKeySelective(hotel);
		return "forward:/hotel/doUpdate";
	}
	
	
	
	/**
	 * 酒店详情
	 * @param map
	 * @return
	 */
	@RequestMapping("toHotelDetail")
	public String toHotelDetailList(ModelMap map,int id){
		Hotel hoteles = hservice.selectByPrimaryKey(id);
		map.put("scenic", sc.selectAll());
		map.put("hoteles",hoteles );
		return "admin/index/hotel-detail";
	}
	
	@RequestMapping("toHotelDetailUpdate")
	public String toHotelDetailUpdate(ModelMap map,int id){
		Hotel hoteles = hservice.selectByPrimaryKey(id);
		map.put("scenic", sc.selectAll());
		map.put("hoteles",hoteles );
		return "forward:/hotel/doHotelDetailUpdate";
	}
	
	@RequestMapping("doHotelDetailUpdate")
	
	public String doHotelDetailUpdate(ModelMap map,Hotel hotel){
		System.out.println(hotel);
		Integer i = hservice.updateByPrimaryKeySelective(hotel);
		return "admin/index/hotel-detail";
	}
	
	
	
	/**
	 * 酒店添加
	 * @param map
	 * @return
	 */
	
	
	@RequestMapping("toHotelAdd")
	public String toHotelAddList(ModelMap map){
		map.put("scenic", sc.selectAll());
		map.put("detail", hservice.selectHotelDetail());
		
		return "admin/index/hotel-add";
	}
	@RequestMapping("doHotelAdd")
	public String doHotelAdd(Hotel hotel, ModelMap map){
		int i = hservice.insert(hotel);
		return "redirect:/hotel/toHotelAdd";
	}
	
	
	
	
}
