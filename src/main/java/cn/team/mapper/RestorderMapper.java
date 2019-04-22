package cn.team.mapper;

import cn.team.entity.Restorder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RestorderMapper {
    @Delete({
            "delete from restorder",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer orderId);

    @Insert({
            "insert into restorder (order_id, user_id, ",
            "rest_id, eat_time, ",
            "table_count, status, ",
            "create_time)",
            "values (#{orderId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
            "#{restId,jdbcType=INTEGER}, #{eatTime,jdbcType=TIMESTAMP}, ",
            "#{tableCount,jdbcType=INTEGER}, #{status,jdbcType=CHAR}, ",
            "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(Restorder record);

    @InsertProvider(type = RestorderSqlProvider.class, method = "insertSelective")
    int insertSelective(Restorder record);

    @Select({
            "select",
            "order_id, user_id, rest_id, eat_time, table_count, status, create_time",
            "from restorder",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "order_id", property = "orderId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "rest_id", property = "restId", jdbcType = JdbcType.INTEGER),
            @Result(column = "eat_time", property = "eatTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "table_count", property = "tableCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "status", property = "status", jdbcType = JdbcType.CHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP)
    })
    Restorder selectByPrimaryKey(Integer orderId);

    @UpdateProvider(type = RestorderSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Restorder record);

    @Update({
            "update restorder",
            "set user_id = #{userId,jdbcType=INTEGER},",
            "rest_id = #{restId,jdbcType=INTEGER},",
            "eat_time = #{eatTime,jdbcType=TIMESTAMP},",
            "table_count = #{tableCount,jdbcType=INTEGER},",
            "status = #{status,jdbcType=CHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP}",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Restorder record);
}