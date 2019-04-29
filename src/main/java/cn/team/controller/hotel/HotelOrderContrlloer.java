package cn.team.controller.hotel;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.team.entity.Hotel;
import cn.team.entity.Hotelorder;
import cn.team.entity.UsersOne;
import cn.team.service.UsersOne.UsersOneService;
import cn.team.service.hotel.HotelRoderService;
import cn.team.service.hotel.HotelService;
import cn.team.utils.PageBean;

@Controller
@RequestMapping("hotelOrder")
public class HotelOrderContrlloer {

	@Autowired
	HotelRoderService hrservice;
	
	@Autowired
	HotelService hservice;
	
	@Autowired
	UsersOneService uservice;
	/**
	 * 酒店订单详情
	 * @param page
	 * @param size
	 * @param name
	 * @param status
	 * @param desc
	 * @param map
	 * @return
	 */
	@RequestMapping("toPageList")
	public String toPageList(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="5")int size,String name ,String status,@RequestParam(defaultValue="0")int desc,ModelMap map){
		PageBean<Map<String,Object>> pageBean = hrservice.selectAllPage(page, size, name, status, desc);
		map.put("pageBean", pageBean);
		map.put("desc", desc);
		
		return "admin/index/hotel-order";
		
	}
	/**
	 * 修改订单详情
	 */
	@RequestMapping("toHotelOrderDetail")
	public String toHotelOrderDetail(ModelMap map,int id){
		Hotelorder order = hrservice.selectByPrimayKey(id);
		map.put("order", order);
		Hotel hotel = hservice.selectByPrimaryKey(order.getHotelId());
		map.put("hotel", hotel);
		UsersOne user = uservice.UsersOneSelectOne(order.getUserId());
		map.put("user", user);
		System.out.println(user);
		return "admin/index/hotelorder-detail";
	}
	@RequestMapping("toHotelOrderUpdate")
	public String toHotelOrderUpdate(ModelMap map,int id){
		Hotelorder order = hrservice.selectByPrimayKey(id);
		map.put("hotel", hservice.selectAll());
		map.put("user", uservice.UsersOneSelectAll());
		map.put("order", order);
		return "forward:/hotelOder/doHotelOrderUpdate";
	}
	
	@RequestMapping("doHotelOrderUpdate")
	public String doHotelOrderUpdate(ModelMap map,Hotelorder order){
		Integer i = hrservice.updateByPrimaryKeySelective(order);
		return "admin/index/hotelorder-detail";
		
		
	}
	
}
