package cn.team.controller.cangcat;

import cn.team.entity.Scenicorder;
import cn.team.service.cangcat.ScenicorderService;
import cn.team.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CangCat
 * @date 2019/4/25 15:50
 */
@Controller
@RequestMapping("scenicOrder")
public class ScenicOrderController {

    @Autowired
    ScenicorderService scenicorderService;

    @RequestMapping("toList")
    public String toList(){
        return "admin/index/order-list";
    }

    @RequestMapping("doList")
    @ResponseBody
    public Map selectAllByPage(Scenicorder scenicorder, Integer page, Integer limit){
        Map map = new HashMap();
        PageBean<Scenicorder> bean = scenicorderService.selectAllByPage(page, limit, scenicorder);
        System.out.println(bean);
        int i = scenicorderService.selectCount(scenicorder);
        System.out.println(i);
        map.put("count", i);
        map.put("code", 0);
        map.put("data", bean.getList());
        return map;
    }

    @RequestMapping("toUpdate/{id}")
    public String toUpdate(@PathVariable int id, ModelMap map){

        return "";
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public String deleteByPrimaryKey(@PathVariable int id){
        scenicorderService.deleteByPrimaryKey(id);
        return "redirect:/scenicOrder/toList";
    }

}
