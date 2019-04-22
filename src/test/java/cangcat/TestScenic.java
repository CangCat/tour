package cangcat;

import cn.team.MainApplication;
import cn.team.entity.Scenic;
import cn.team.service.ScenicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author CangCat
 * @date 2019/4/22 17:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class TestScenic {

    @Autowired
    ScenicService scenicService;

    @Test
    public void testSelectAll() {
        for (Scenic scenic : scenicService.selectAll()) {
            System.out.println(scenic);
        }
    }
}
