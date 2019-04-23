package cn.team.mapper;

import cn.team.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CommentMapper {
    @Delete({
            "delete from comment",
            "where comm_id = #{commId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer commId);

    @Insert({
            "insert into comment (comm_id, user_id, ",
            "project_id, comm_time, ",
            "perfection, status, ",
            "look_num, project_type, ",
            "comm_intro)",
            "values (#{commId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
            "#{projectId,jdbcType=INTEGER}, #{commTime,jdbcType=TIMESTAMP}, ",
            "#{perfection,jdbcType=INTEGER}, #{status,jdbcType=CHAR}, ",
            "#{lookNum,jdbcType=INTEGER}, #{projectType,jdbcType=CHAR}, ",
            "#{commIntro,jdbcType=LONGVARCHAR})"
    })
    int insert(Comment record);

    @InsertProvider(type = CommentSqlProvider.class, method = "insertSelective")
    int insertSelective(Comment record);

    @Select({
            "select",
            "comm_id, user_id, project_id, comm_time, perfection, status, look_num, project_type, ",
            "comm_intro",
            "from comment",
            "where comm_id = #{commId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "comm_id", property = "commId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "project_id", property = "projectId", jdbcType = JdbcType.INTEGER),
            @Result(column = "comm_time", property = "commTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "perfection", property = "perfection", jdbcType = JdbcType.INTEGER),
            @Result(column = "status", property = "status", jdbcType = JdbcType.CHAR),
            @Result(column = "look_num", property = "lookNum", jdbcType = JdbcType.INTEGER),
            @Result(column = "project_type", property = "projectType", jdbcType = JdbcType.CHAR),
            @Result(column = "comm_intro", property = "commIntro", jdbcType = JdbcType.LONGVARCHAR)
    })
    Comment selectByPrimaryKey(Integer commId);

    @UpdateProvider(type = CommentSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Comment record);

    @Update({
            "update comment",
            "set user_id = #{userId,jdbcType=INTEGER},",
            "project_id = #{projectId,jdbcType=INTEGER},",
            "comm_time = #{commTime,jdbcType=TIMESTAMP},",
            "perfection = #{perfection,jdbcType=INTEGER},",
            "status = #{status,jdbcType=CHAR},",
            "look_num = #{lookNum,jdbcType=INTEGER},",
            "project_type = #{projectType,jdbcType=CHAR},",
            "comm_intro = #{commIntro,jdbcType=LONGVARCHAR}",
            "where comm_id = #{commId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Comment record);

    @Update({
            "update comment",
            "set user_id = #{userId,jdbcType=INTEGER},",
            "project_id = #{projectId,jdbcType=INTEGER},",
            "comm_time = #{commTime,jdbcType=TIMESTAMP},",
            "perfection = #{perfection,jdbcType=INTEGER},",
            "status = #{status,jdbcType=CHAR},",
            "look_num = #{lookNum,jdbcType=INTEGER},",
            "project_type = #{projectType,jdbcType=CHAR}",
            "where comm_id = #{commId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Comment record);
}