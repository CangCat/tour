package cn.team.controller.cangcat;

import cn.team.entity.Scenic;
import cn.team.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author CangCat
 * @date 2019/4/22 18:45
 */
@RestController
@RequestMapping("scenic")
public class ScenicController {

    @Autowired
    ScenicService scenicService;

    @RequestMapping("toCourtTravel")
    public String toCourtTravel() {
        return "";
    }


}
