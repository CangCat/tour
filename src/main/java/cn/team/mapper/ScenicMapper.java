package cn.team.mapper;

import cn.team.entity.Scenic;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author CangCat
 * @date 2019/4/23 11:30
 */
@org.apache.ibatis.annotations.Mapper
@Repository
public interface ScenicMapper extends Mapper<Scenic>, MySqlMapper<Scenic>, IdsMapper<Scenic> {

}
