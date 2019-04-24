package cn.team.mapper.cangcat;

import cn.team.entity.Scenicorder;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author CangCat
 * @date 2019/4/23 12:14
 */
@org.apache.ibatis.annotations.Mapper
@Repository
public interface ScenicorderMapper extends Mapper<Scenicorder>, MySqlMapper<Scenicorder> {

}
