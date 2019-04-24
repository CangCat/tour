package cn.team.controller.travel;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.team.entity.Travels;
import cn.team.service.travel.TravelService;
import cn.team.utils.PageBean;

@Controller
@RequestMapping("travel")
public class TravelsController {
	
	@Autowired
	TravelService service;

	/**
	 * 游记列表页
	 * @param map
	 * @return
	 */
	@RequestMapping("toList")
	public String to_list(ModelMap map,@RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="15")Integer size, String status, String sName, String uName){
		if(pageNum<1){
			pageNum=1;
		}
		if(size<1){
			size=15;
		}
		PageBean<Map<String, Object>> pageBean = service.selectByPage(pageNum, size, status, sName, uName);
		map.put("status", status);
		map.put("sName", sName);
		map.put("uName", uName);
		map.put("pageBean", pageBean);
		return "admin/index/travel-nose-list";
	}
	
	/**
	 * 去到游记保存页面
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd(){
		return "admin/index/travel-nose-add";
	}
	
	/**
	 * 执行新增操作
	 * @return
	 */
	@RequestMapping("doAdd")
	public String doAdd(){
		return "admin/index/travel-nose-add";
	}
	
	/**
	 * 去到游记更新页面
	 * @param id 根据id查找游记信息
	 * @param map
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Integer id, ModelMap map){
		Travels travel = new Travels();
		travel.setTravelId(id);
		service.selectOneById(travel);
		map.put("travel", travel);
		return "admin/index/travel-nose-detail";
	}
	
	
	/**
	 * 修改游记操作
	 * @return
	 */
	@RequestMapping("doUpdate")
	public String doUpdate(){
		return "admin/index/travel-nose-detail";
	}
	
	
	/**
	 * 伤处游记的操作
	 * @return
	 */
	@RequestMapping("doDelete")
	public String doDelete(){
		return "admin/index/travel-nose-detail";
	}
}
