package cn.team.controller.cangcat;

import cn.team.service.cangcat.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String toScenicList() {
        return "/WEB-INF/admin/index/scenic-list.jsp";
    }


}
