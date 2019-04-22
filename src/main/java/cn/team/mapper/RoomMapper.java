package cn.team.mapper;

import cn.team.entity.Room;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RoomMapper {
    @Delete({
            "delete from room",
            "where room_id = #{roomId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer roomId);

    @Insert({
            "insert into room (room_id, room_name, ",
            "room_price, room_remark, ",
            "room_pic, hotel_id)",
            "values (#{roomId,jdbcType=INTEGER}, #{roomName,jdbcType=VARCHAR}, ",
            "#{roomPrice,jdbcType=DECIMAL}, #{roomRemark,jdbcType=VARCHAR}, ",
            "#{roomPic,jdbcType=VARCHAR}, #{hotelId,jdbcType=INTEGER})"
    })
    int insert(Room record);

    @InsertProvider(type = RoomSqlProvider.class, method = "insertSelective")
    int insertSelective(Room record);

    @Select({
            "select",
            "room_id, room_name, room_price, room_remark, room_pic, hotel_id",
            "from room",
            "where room_id = #{roomId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "room_id", property = "roomId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "room_name", property = "roomName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "room_price", property = "roomPrice", jdbcType = JdbcType.DECIMAL),
            @Result(column = "room_remark", property = "roomRemark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "room_pic", property = "roomPic", jdbcType = JdbcType.VARCHAR),
            @Result(column = "hotel_id", property = "hotelId", jdbcType = JdbcType.INTEGER)
    })
    Room selectByPrimaryKey(Integer roomId);

    @UpdateProvider(type = RoomSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Room record);

    @Update({
            "update room",
            "set room_name = #{roomName,jdbcType=VARCHAR},",
            "room_price = #{roomPrice,jdbcType=DECIMAL},",
            "room_remark = #{roomRemark,jdbcType=VARCHAR},",
            "room_pic = #{roomPic,jdbcType=VARCHAR},",
            "hotel_id = #{hotelId,jdbcType=INTEGER}",
            "where room_id = #{roomId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Room record);
}