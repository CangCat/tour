package cn.team.mapper;

import cn.team.entity.Restaurant;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RestaurantMapper {
    @Delete({
            "delete from restaurant",
            "where rest_id = #{restId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer restId);

    @Insert({
            "insert into restaurant (rest_id, scenic_id, ",
            "rest_name, rest_tel, ",
            "rest_pic, status, create_time, ",
            "rest_intro)",
            "values (#{restId,jdbcType=INTEGER}, #{scenicId,jdbcType=INTEGER}, ",
            "#{restName,jdbcType=VARCHAR}, #{restTel,jdbcType=VARCHAR}, ",
            "#{restPic,jdbcType=VARCHAR}, #{status,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{restIntro,jdbcType=LONGVARCHAR})"
    })
    int insert(Restaurant record);

    @InsertProvider(type = RestaurantSqlProvider.class, method = "insertSelective")
    int insertSelective(Restaurant record);

    @Select({
            "select",
            "rest_id, scenic_id, rest_name, rest_tel, rest_pic, status, create_time, rest_intro",
            "from restaurant",
            "where rest_id = #{restId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "rest_id", property = "restId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "scenic_id", property = "scenicId", jdbcType = JdbcType.INTEGER),
            @Result(column = "rest_name", property = "restName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "rest_tel", property = "restTel", jdbcType = JdbcType.VARCHAR),
            @Result(column = "rest_pic", property = "restPic", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.CHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "rest_intro", property = "restIntro", jdbcType = JdbcType.LONGVARCHAR)
    })
    Restaurant selectByPrimaryKey(Integer restId);

    @UpdateProvider(type = RestaurantSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Restaurant record);

    @Update({
            "update restaurant",
            "set scenic_id = #{scenicId,jdbcType=INTEGER},",
            "rest_name = #{restName,jdbcType=VARCHAR},",
            "rest_tel = #{restTel,jdbcType=VARCHAR},",
            "rest_pic = #{restPic,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=CHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "rest_intro = #{restIntro,jdbcType=LONGVARCHAR}",
            "where rest_id = #{restId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Restaurant record);

    @Update({
            "update restaurant",
            "set scenic_id = #{scenicId,jdbcType=INTEGER},",
            "rest_name = #{restName,jdbcType=VARCHAR},",
            "rest_tel = #{restTel,jdbcType=VARCHAR},",
            "rest_pic = #{restPic,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=CHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP}",
            "where rest_id = #{restId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Restaurant record);
}