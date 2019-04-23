package cn.team.mapper;

import java.util.List;

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

import cn.team.entity.Travels;

@Mapper
public interface TravelsMapper {
    @Delete({
            "delete from travels",
            "where travel_id = #{travelId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer travelId);

    @Insert({
            "insert into travels (travel_id, user_id, ",
            "scenic_id, create_time, ",
            "prefaction, look_num, ",
            "picture, status, like_num, ",
            "intro)",
            "values (#{travelId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
            "#{scenicId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{prefaction,jdbcType=INTEGER}, #{lookNum,jdbcType=INTEGER}, ",
            "#{picture,jdbcType=VARCHAR}, #{status,jdbcType=CHAR}, #{likeNum,jdbcType=INTEGER}, ",
            "#{intro,jdbcType=LONGVARCHAR})"
    })
    int insert(Travels record);

    @InsertProvider(type = TravelsSqlProvider.class, method = "insertSelective")
    int insertSelective(Travels record);

    @Select({
            "select",
            "travel_id, user_id, scenic_id, create_time, prefaction, look_num, picture, status, ",
            "like_num, intro",
            "from travels",
            "where travel_id = #{travelId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "travel_id", property = "travelId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "scenic_id", property = "scenicId", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "prefaction", property = "prefaction", jdbcType = JdbcType.INTEGER),
            @Result(column = "look_num", property = "lookNum", jdbcType = JdbcType.INTEGER),
            @Result(column = "picture", property = "picture", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.CHAR),
            @Result(column = "like_num", property = "likeNum", jdbcType = JdbcType.INTEGER),
            @Result(column = "intro", property = "intro", jdbcType = JdbcType.LONGVARCHAR)
    })
    Travels selectByPrimaryKey(Integer travelId);

    @UpdateProvider(type = TravelsSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Travels record);

    @Update({
            "update travels",
            "set user_id = #{userId,jdbcType=INTEGER},",
            "scenic_id = #{scenicId,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "prefaction = #{prefaction,jdbcType=INTEGER},",
            "look_num = #{lookNum,jdbcType=INTEGER},",
            "picture = #{picture,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=CHAR},",
            "like_num = #{likeNum,jdbcType=INTEGER},",
            "intro = #{intro,jdbcType=LONGVARCHAR}",
            "where travel_id = #{travelId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Travels record);

    @Update({
            "update travels",
            "set user_id = #{userId,jdbcType=INTEGER},",
            "scenic_id = #{scenicId,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "prefaction = #{prefaction,jdbcType=INTEGER},",
            "look_num = #{lookNum,jdbcType=INTEGER},",
            "picture = #{picture,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=CHAR},",
            "like_num = #{likeNum,jdbcType=INTEGER}",
            "where travel_id = #{travelId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Travels record);
    
    
    @Select("select travel_id, user_id, scenic_id, create_time, prefaction, look_num, picture, status, scenic_id, create_time,prefaction, look_num,picture, status, like_num,intro from travels")
    List<Travels> findAllTravels();
}