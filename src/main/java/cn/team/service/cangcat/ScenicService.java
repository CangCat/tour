package cn.team.service.cangcat;

import cn.team.entity.Scenic;

import java.util.List;

/**
 * @author CangCat
 * @date 2019/4/22 17:11
 */
public interface ScenicService {

    /**
     * 查询所有
     *
     * @return
     */
    List<Scenic> selectAll();

    /**
     * 动态查询
     *
     * @param scenic
     * @return
     */
    Scenic selectOne(Scenic scenic);

    /**
     * 根据 id 查询
     *
     * @param id
     * @return
     */
    Scenic selectByPrimaryKey(Integer id);

}
