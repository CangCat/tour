package cn.team.mapper.cangcat;

import cn.team.entity.Scenic;
import cn.team.entity.Scenicorder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @author CangCat
 * @date 2019/4/23 12:14
 */
@org.apache.ibatis.annotations.Mapper
@Repository
public interface ScenicorderMapper extends Mapper<Scenicorder>, MySqlMapper<Scenicorder>, IdsMapper<Scenicorder> {

    @Select("select order_id,user_id,scenic_id,account,create_time,status,play_time " +
            "from scenicorder " +
            "limit #{startIndex},#{size}")
    List<Scenicorder> selectAllByPage(@Param("startIndex") int startIndex, @Param("size") int size);
}
