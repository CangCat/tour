package cn.team.mapper;

import cn.team.entity.Scenicorder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ScenicorderMapper {
    @Delete({
            "delete from scenicorder",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer orderId);

    @Insert({
            "insert into scenicorder (order_id, user_id, ",
            "scenic_id, account, ",
            "create_time, status, ",
            "play_time)",
            "values (#{orderId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
            "#{scenicId,jdbcType=INTEGER}, #{account,jdbcType=INTEGER}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{status,jdbcType=CHAR}, ",
            "#{playTime,jdbcType=TIMESTAMP})"
    })
    int insert(Scenicorder record);

    @InsertProvider(type = ScenicorderSqlProvider.class, method = "insertSelective")
    int insertSelective(Scenicorder record);

    @Select({
            "select",
            "order_id, user_id, scenic_id, account, create_time, status, play_time",
            "from scenicorder",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "order_id", property = "orderId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "scenic_id", property = "scenicId", jdbcType = JdbcType.INTEGER),
            @Result(column = "account", property = "account", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "status", property = "status", jdbcType = JdbcType.CHAR),
            @Result(column = "play_time", property = "playTime", jdbcType = JdbcType.TIMESTAMP)
    })
    Scenicorder selectByPrimaryKey(Integer orderId);

    @UpdateProvider(type = ScenicorderSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Scenicorder record);

    @Update({
            "update scenicorder",
            "set user_id = #{userId,jdbcType=INTEGER},",
            "scenic_id = #{scenicId,jdbcType=INTEGER},",
            "account = #{account,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "status = #{status,jdbcType=CHAR},",
            "play_time = #{playTime,jdbcType=TIMESTAMP}",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Scenicorder record);
}