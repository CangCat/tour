package cn.team.controller.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.team.service.function.FunctionService;

@Controller
@RequestMapping("function")
public class FunctionController {

	@Autowired
	FunctionService service;
	
	@RequestMapping("toList")
	public String toList(ModelMap map/*,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer size*/){
		map.put("list", service.functions());
		

		return "admin/index/function-list";
	}
	
	
	@RequestMapping("doList")
    @ResponseBody
    public Map<String,Object> doList(@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer size) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> list = service.selectFunctions(page, size);
        System.out.println(list);
        map.put("code",0);
		map.put("msg","");
		int i = service.selectCount();
        map.put("count", i);
        map.put("data", list);
        return map;
    }
}
