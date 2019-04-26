package cn.team.service.cangcat;

import cn.team.entity.Scenic;
import cn.team.entity.Scenicorder;
import cn.team.utils.PageBean;

import java.util.List;

/**
 * @author CangCat
 * @date 2019/4/22 17:12
 */
public interface ScenicorderService {

    /**
     * 查询出 景区订单表所有内容
     * @return
     */
    List<Scenicorder> selectAll();


    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     *
     * @param scenicorder
     * @return
     */
    int selectCount(Scenicorder scenicorder);

    /**
     * 查询 所有 并且分页
     *
     * @param page
     * @param size
     * @param scenicorder
     * @return
     */
    PageBean<Scenicorder> selectAllByPage(int page, int size, Scenicorder scenicorder);

    /**
     * 根据 ID 删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

}
