package cn.team.mapper;

import cn.team.entity.Setmeal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SetmealMapper {
    @Delete({
            "delete from setmeal",
            "where meal_id = #{mealId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer mealId);

    @Insert({
            "insert into setmeal (meal_id, meal_name, ",
            "create_time, update_time, ",
            "status, price)",
            "values (#{mealId,jdbcType=INTEGER}, #{mealName,jdbcType=VARCHAR}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
            "#{status,jdbcType=CHAR}, #{price,jdbcType=DECIMAL})"
    })
    int insert(Setmeal record);

    @InsertProvider(type = SetmealSqlProvider.class, method = "insertSelective")
    int insertSelective(Setmeal record);

    @Select({
            "select",
            "meal_id, meal_name, create_time, update_time, status, price",
            "from setmeal",
            "where meal_id = #{mealId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "meal_id", property = "mealId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "meal_name", property = "mealName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "status", property = "status", jdbcType = JdbcType.CHAR),
            @Result(column = "price", property = "price", jdbcType = JdbcType.DECIMAL)
    })
    Setmeal selectByPrimaryKey(Integer mealId);

    @UpdateProvider(type = SetmealSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Setmeal record);

    @Update({
            "update setmeal",
            "set meal_name = #{mealName,jdbcType=VARCHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP},",
            "status = #{status,jdbcType=CHAR},",
            "price = #{price,jdbcType=DECIMAL}",
            "where meal_id = #{mealId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Setmeal record);
}