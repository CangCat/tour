package cn.team.mapper;

import cn.team.entity.Mealorder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MealorderMapper {
    @Delete({
            "delete from mealorder",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer orderId);

    @Insert({
            "insert into mealorder (order_id, meal_id, ",
            "user_id, create_time, ",
            "play_time, status)",
            "values (#{orderId,jdbcType=INTEGER}, #{mealId,jdbcType=INTEGER}, ",
            "#{userId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{playTime,jdbcType=TIMESTAMP}, #{status,jdbcType=CHAR})"
    })
    int insert(Mealorder record);

    @InsertProvider(type = MealorderSqlProvider.class, method = "insertSelective")
    int insertSelective(Mealorder record);

    @Select({
            "select",
            "order_id, meal_id, user_id, create_time, play_time, status",
            "from mealorder",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "order_id", property = "orderId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "meal_id", property = "mealId", jdbcType = JdbcType.INTEGER),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "play_time", property = "playTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "status", property = "status", jdbcType = JdbcType.CHAR)
    })
    Mealorder selectByPrimaryKey(Integer orderId);

    @UpdateProvider(type = MealorderSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Mealorder record);

    @Update({
            "update mealorder",
            "set meal_id = #{mealId,jdbcType=INTEGER},",
            "user_id = #{userId,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "play_time = #{playTime,jdbcType=TIMESTAMP},",
            "status = #{status,jdbcType=CHAR}",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Mealorder record);
}