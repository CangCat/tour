package cn.team.controller.cangcat;

import cn.team.service.cangcat.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 跳转到 scenic-list 页面
     *
     * @param map
     * @return
     */
    @RequestMapping("toScenicList")
    public String toScenicList(ModelMap map) {
        map.put("list", scenicService.selectAll());
        return "admin/index/scenic-list";
    }

    /**
     * 跳转到 scenic-add 页面
     *
     * @return
     */
    @RequestMapping("toScenicAdd")
    public String toScenicAdd() {
        return "admin/index/scenic-add";
    }

    /**
     * 根据 id 查找出来景点数据  传递，跳转到景点修改页面
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("toScenicDetail/{id}")
    public String toScenicDetail(Integer id, ModelMap map) {
        map.put("", scenicService.selectByPrimaryKey(id));
        return "admin/index/scenic-detail";
    }

    /**
     * 根据 id 进行删除景点
     * @param id
     * @return
     */
    @RequestMapping("deleteByPrimaryKey/{id}")
    public String deleteByPrimaryKey(@PathVariable int id) {
        System.out.println(id);
        scenicService.deleteByPrimaryKey(id);
        return "redirect:/scenic/toScenicList";
    }

    /**
     * 根据  ids  动态删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("deleteByIds/{ids}")
    public String deleteByIds(@PathVariable String ids) {
        scenicService.deleteByIds(ids);
        return "redirect:/scenic/toScenicList";
    }

//    @RequestMapping()
//    public void

}
