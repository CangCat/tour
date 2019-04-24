package cn.team.mapper.cangcat;

import cn.team.entity.Scenic;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @author CangCat
 * @date 2019/4/23 11:30
 */
@org.apache.ibatis.annotations.Mapper
@Repository
public interface ScenicMapper extends Mapper<Scenic>, MySqlMapper<Scenic>, IdsMapper<Scenic> {

    @Select("select scenic_id,scenic_name,scenic_intro,scenic_address,scenic_link ," +
            "scenic_tel,scenic_ticket,scenic_charge,scenic_pic,open_time,end_time ," +
            "check_type,scenic_status,create_time,update_time,type_one,type_two " +
            "from scenic limit #{startIndex},#{size}")
    List<Scenic> selectAllByPage(@Param("startIndex") int startIndex, @Param("size") int size);
}
