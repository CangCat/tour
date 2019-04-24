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


    /**
     * 根据 ID 删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段
     *
     * @param ids 如 "1,2,3,4"
     * @return
     */
    int deleteByIds(String ids);


    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     *
     * @param scenic
     * @return
     */
    int insert(Scenic scenic);


}
