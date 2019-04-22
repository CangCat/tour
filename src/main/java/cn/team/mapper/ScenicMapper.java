package cn.team.mapper;

import cn.team.entity.Scenic;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ScenicMapper {
    @Delete({
            "delete from scenic",
            "where scenic_id = #{scenicId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer scenicId);

    @Insert({
            "insert into scenic (scenic_id, scenic_name, ",
            "scenic_address, scenic_link, ",
            "scenic_tel, scenic_ticket, ",
            "scenic_charge, scenic_pic, ",
            "open_time, end_time, ",
            "check_type, scenic_status, ",
            "create_time, update_time, ",
            "type_one, type_two, scenic_intro)",
            "values (#{scenicId,jdbcType=INTEGER}, #{scenicName,jdbcType=VARCHAR}, ",
            "#{scenicAddress,jdbcType=VARCHAR}, #{scenicLink,jdbcType=VARCHAR}, ",
            "#{scenicTel,jdbcType=VARCHAR}, #{scenicTicket,jdbcType=CHAR}, ",
            "#{scenicCharge,jdbcType=DOUBLE}, #{scenicPic,jdbcType=VARCHAR}, ",
            "#{openTime,jdbcType=VARCHAR}, #{endTime,jdbcType=VARCHAR}, ",
            "#{checkType,jdbcType=CHAR}, #{scenicStatus,jdbcType=CHAR}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
            "#{typeOne,jdbcType=CHAR}, #{typeTwo,jdbcType=CHAR}, #{scenicIntro,jdbcType=LONGVARCHAR})"
    })
    int insert(Scenic record);

    @InsertProvider(type = ScenicSqlProvider.class, method = "insertSelective")
    int insertSelective(Scenic record);

    @Select({
            "select",
            "scenic_id, scenic_name, scenic_address, scenic_link, scenic_tel, scenic_ticket, ",
            "scenic_charge, scenic_pic, open_time, end_time, check_type, scenic_status, create_time, ",
            "update_time, type_one, type_two, scenic_intro",
            "from scenic",
            "where scenic_id = #{scenicId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "scenic_id", property = "scenicId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "scenic_name", property = "scenicName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "scenic_address", property = "scenicAddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "scenic_link", property = "scenicLink", jdbcType = JdbcType.VARCHAR),
            @Result(column = "scenic_tel", property = "scenicTel", jdbcType = JdbcType.VARCHAR),
            @Result(column = "scenic_ticket", property = "scenicTicket", jdbcType = JdbcType.CHAR),
            @Result(column = "scenic_charge", property = "scenicCharge", jdbcType = JdbcType.DOUBLE),
            @Result(column = "scenic_pic", property = "scenicPic", jdbcType = JdbcType.VARCHAR),
            @Result(column = "open_time", property = "openTime", jdbcType = JdbcType.VARCHAR),
            @Result(column = "end_time", property = "endTime", jdbcType = JdbcType.VARCHAR),
            @Result(column = "check_type", property = "checkType", jdbcType = JdbcType.CHAR),
            @Result(column = "scenic_status", property = "scenicStatus", jdbcType = JdbcType.CHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "type_one", property = "typeOne", jdbcType = JdbcType.CHAR),
            @Result(column = "type_two", property = "typeTwo", jdbcType = JdbcType.CHAR),
            @Result(column = "scenic_intro", property = "scenicIntro", jdbcType = JdbcType.LONGVARCHAR)
    })
    Scenic selectByPrimaryKey(Integer scenicId);

    @UpdateProvider(type = ScenicSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Scenic record);

    @Update({
            "update scenic",
            "set scenic_name = #{scenicName,jdbcType=VARCHAR},",
            "scenic_address = #{scenicAddress,jdbcType=VARCHAR},",
            "scenic_link = #{scenicLink,jdbcType=VARCHAR},",
            "scenic_tel = #{scenicTel,jdbcType=VARCHAR},",
            "scenic_ticket = #{scenicTicket,jdbcType=CHAR},",
            "scenic_charge = #{scenicCharge,jdbcType=DOUBLE},",
            "scenic_pic = #{scenicPic,jdbcType=VARCHAR},",
            "open_time = #{openTime,jdbcType=VARCHAR},",
            "end_time = #{endTime,jdbcType=VARCHAR},",
            "check_type = #{checkType,jdbcType=CHAR},",
            "scenic_status = #{scenicStatus,jdbcType=CHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP},",
            "type_one = #{typeOne,jdbcType=CHAR},",
            "type_two = #{typeTwo,jdbcType=CHAR},",
            "scenic_intro = #{scenicIntro,jdbcType=LONGVARCHAR}",
            "where scenic_id = #{scenicId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Scenic record);

    @Update({
            "update scenic",
            "set scenic_name = #{scenicName,jdbcType=VARCHAR},",
            "scenic_address = #{scenicAddress,jdbcType=VARCHAR},",
            "scenic_link = #{scenicLink,jdbcType=VARCHAR},",
            "scenic_tel = #{scenicTel,jdbcType=VARCHAR},",
            "scenic_ticket = #{scenicTicket,jdbcType=CHAR},",
            "scenic_charge = #{scenicCharge,jdbcType=DOUBLE},",
            "scenic_pic = #{scenicPic,jdbcType=VARCHAR},",
            "open_time = #{openTime,jdbcType=VARCHAR},",
            "end_time = #{endTime,jdbcType=VARCHAR},",
            "check_type = #{checkType,jdbcType=CHAR},",
            "scenic_status = #{scenicStatus,jdbcType=CHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP},",
            "type_one = #{typeOne,jdbcType=CHAR},",
            "type_two = #{typeTwo,jdbcType=CHAR}",
            "where scenic_id = #{scenicId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Scenic record);


    /**
     * 查询景区表所有内容
     *
     * @return
     */
    @Select(value = "select scenic_id, scenic_name, scenic_address, scenic_link, scenic_tel, scenic_ticket, " +
            "scenic_charge, scenic_pic, open_time, end_time, check_type, scenic_status, create_time, " +
            "update_time, type_one, type_two, scenic_intro " +
            "from scenic")
    List<Scenic> selectAll();
}