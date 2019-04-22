package cangcat;

import cn.team.MainApplication;
import cn.team.entity.Scenicorder;
import cn.team.service.ScenicorderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author CangCat
 * @date 2019/4/22 18:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class TestScenicorder {

    @Autowired
    ScenicorderService scenicorderService;

    @Test
    public void testSelectAll() {
        for (Scenicorder scenicorder : scenicorderService.selectAll()) {
            System.out.println(scenicorder);
        }
    }
}
