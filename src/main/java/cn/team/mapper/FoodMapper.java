package cn.team.mapper;

import cn.team.entity.Food;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface FoodMapper {
    @Delete({
            "delete from food",
            "where food_id = #{foodId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer foodId);

    @Insert({
            "insert into food (food_id, rest_id, ",
            "food_name, food_tel, ",
            "food_pic, status, create_time, ",
            "food_intro)",
            "values (#{foodId,jdbcType=INTEGER}, #{restId,jdbcType=INTEGER}, ",
            "#{foodName,jdbcType=VARCHAR}, #{foodTel,jdbcType=VARCHAR}, ",
            "#{foodPic,jdbcType=VARCHAR}, #{status,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{foodIntro,jdbcType=LONGVARCHAR})"
    })
    int insert(Food record);

    @InsertProvider(type = FoodSqlProvider.class, method = "insertSelective")
    int insertSelective(Food record);

    @Select({
            "select",
            "food_id, rest_id, food_name, food_tel, food_pic, status, create_time, food_intro",
            "from food",
            "where food_id = #{foodId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "food_id", property = "foodId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "rest_id", property = "restId", jdbcType = JdbcType.INTEGER),
            @Result(column = "food_name", property = "foodName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "food_tel", property = "foodTel", jdbcType = JdbcType.VARCHAR),
            @Result(column = "food_pic", property = "foodPic", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.CHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "food_intro", property = "foodIntro", jdbcType = JdbcType.LONGVARCHAR)
    })
    Food selectByPrimaryKey(Integer foodId);

    @UpdateProvider(type = FoodSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Food record);

    @Update({
            "update food",
            "set rest_id = #{restId,jdbcType=INTEGER},",
            "food_name = #{foodName,jdbcType=VARCHAR},",
            "food_tel = #{foodTel,jdbcType=VARCHAR},",
            "food_pic = #{foodPic,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=CHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "food_intro = #{foodIntro,jdbcType=LONGVARCHAR}",
            "where food_id = #{foodId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Food record);

    @Update({
            "update food",
            "set rest_id = #{restId,jdbcType=INTEGER},",
            "food_name = #{foodName,jdbcType=VARCHAR},",
            "food_tel = #{foodTel,jdbcType=VARCHAR},",
            "food_pic = #{foodPic,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=CHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP}",
            "where food_id = #{foodId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Food record);
}