package cn.team.mapper;

import cn.team.entity.Scenic;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author CangCat
 * @date 2019/4/23 11:30
 */
@org.apache.ibatis.annotations.Mapper
public interface ScenicMapper extends Mapper<Scenic>, MySqlMapper<Scenic> {

}
