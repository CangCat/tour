package cn.team.mapper;

import cn.team.entity.Function;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface FunctionMapper {
    @Delete({
            "delete from function",
            "where fun_id = #{funId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer funId);

    @Insert({
            "insert into function (fun_id, scenic_id, ",
            "fun_name, fun_time, ",
            "fun_address, fun_pic, ",
            "status, create_time, ",
            "fun_intro)",
            "values (#{funId,jdbcType=INTEGER}, #{scenicId,jdbcType=INTEGER}, ",
            "#{funName,jdbcType=VARCHAR}, #{funTime,jdbcType=VARCHAR}, ",
            "#{funAddress,jdbcType=VARCHAR}, #{funPic,jdbcType=VARCHAR}, ",
            "#{status,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{funIntro,jdbcType=LONGVARCHAR})"
    })
    int insert(Function record);

    @InsertProvider(type = FunctionSqlProvider.class, method = "insertSelective")
    int insertSelective(Function record);

    @Select({
            "select",
            "fun_id, scenic_id, fun_name, fun_time, fun_address, fun_pic, status, create_time, ",
            "fun_intro",
            "from function",
            "where fun_id = #{funId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "fun_id", property = "funId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "scenic_id", property = "scenicId", jdbcType = JdbcType.INTEGER),
            @Result(column = "fun_name", property = "funName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "fun_time", property = "funTime", jdbcType = JdbcType.VARCHAR),
            @Result(column = "fun_address", property = "funAddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "fun_pic", property = "funPic", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.CHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "fun_intro", property = "funIntro", jdbcType = JdbcType.LONGVARCHAR)
    })
    Function selectByPrimaryKey(Integer funId);

    @UpdateProvider(type = FunctionSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Function record);

    @Update({
            "update function",
            "set scenic_id = #{scenicId,jdbcType=INTEGER},",
            "fun_name = #{funName,jdbcType=VARCHAR},",
            "fun_time = #{funTime,jdbcType=VARCHAR},",
            "fun_address = #{funAddress,jdbcType=VARCHAR},",
            "fun_pic = #{funPic,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=CHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "fun_intro = #{funIntro,jdbcType=LONGVARCHAR}",
            "where fun_id = #{funId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Function record);

    @Update({
            "update function",
            "set scenic_id = #{scenicId,jdbcType=INTEGER},",
            "fun_name = #{funName,jdbcType=VARCHAR},",
            "fun_time = #{funTime,jdbcType=VARCHAR},",
            "fun_address = #{funAddress,jdbcType=VARCHAR},",
            "fun_pic = #{funPic,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=CHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP}",
            "where fun_id = #{funId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Function record);
}