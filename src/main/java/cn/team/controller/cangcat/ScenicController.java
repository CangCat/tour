package cn.team.controller.cangcat;

import cn.team.entity.Scenic;
import cn.team.service.cangcat.ScenicService;
import org.apache.ibatis.annotations.Param;
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

    @RequestMapping("toScenicAdd")
    public String toScenicAdd() {
        return "admin/index/scenic-add";
    }

    @RequestMapping("toScenicDetail/{id}")
    public String toScenicDetail(Integer id, ModelMap map) {
        map.put("", scenicService.selectByPrimaryKey(id));
        return "admin/index/scenic-detail";
    }

    @RequestMapping("deleteByPrimaryKey/{id}")
    public String deleteByPrimaryKey(@Param("id") Integer id) {
        System.out.println(id);
        scenicService.deleteByPrimaryKey(id);
        return "redirect:/scenic/toScenicList";
    }

    @RequestMapping("deleteByIds")
    public String deleteByIds(Integer... ids) {

        return "";
    }

}
