package cn.team.controller.hotel;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.team.entity.Room;
import cn.team.service.hotel.HotelService;
import cn.team.service.hotel.RoomService;
import cn.team.utils.PageBean;

@Controller
@RequestMapping("room")
public class RoomController {

	@Autowired
	RoomService service;
	
	@Autowired
	HotelService hservice;
	/**
	 * 分页查询
	 * @param page
	 * @param size
	 * @param map
	 * @return
	 */
	@RequestMapping("toPageList")
	public String toPageList(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="5")int size,ModelMap map){
		map.put("hotels", hservice);
		
		PageBean<Map<String,Object>> pageBean=service.selectAllPage(page, size, map);
		
		System.out.println("参数："+pageBean);
		
		map.put("pageBean", pageBean);
		
		return "admin/index/room-list";
	}
	
	/**
	 * 添加新订单信息
	 */
	@RequestMapping("toRoomAdd")
	public String toRoomAdd(ModelMap map){
		
		map.put("room", service.selectAll());
		map.put("hotel", hservice.selectAll());
		
		return "admin/index/room-add";
	}
	
	@RequestMapping("doRoomAdd")
	public String doRoomAdd(ModelMap map,Room room){
		Integer i = service.insert(room);
		return "redirect:/room/toRoomAdd";
	}
	
}
