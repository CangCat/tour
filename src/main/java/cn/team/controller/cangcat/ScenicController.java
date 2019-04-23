package cn.team.controller.cangcat;

import cn.team.entity.Scenic;
import cn.team.service.cangcat.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CangCat
 * @date 2019/4/22 18:45
 */
@Controller
@RequestMapping("scenic")
public class ScenicController {

    @Autowired
    ScenicService scenicService;

    @RequestMapping("toScenicList")
    public String toScenicList(ModelMap map) {
        map.put("list", scenicService.selectAll());
        return "admin/index/scenic-list";
    }

    @RequestMapping("toScenicAdd/{id}")
    public String toScenicAdd(Integer id, ModelMap map) {
        map.put("scenic", scenicService.selectByPrimaryKey(id));
        return "admin/index/scenic-add";
    }


}
