package cn.team.mapper;

import cn.team.entity.Hotelorder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface HotelorderMapper {
    @Delete({
            "delete from hotelorder",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer orderId);

    @Insert({
            "insert into hotelorder (order_id, user_id, ",
            "hotel_id, hotel_checkin, ",
            "room_count, status, ",
            "create_time)",
            "values (#{orderId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
            "#{hotelId,jdbcType=INTEGER}, #{hotelCheckin,jdbcType=TIMESTAMP}, ",
            "#{roomCount,jdbcType=INTEGER}, #{status,jdbcType=CHAR}, ",
            "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(Hotelorder record);

    @InsertProvider(type = HotelorderSqlProvider.class, method = "insertSelective")
    int insertSelective(Hotelorder record);

    @Select({
            "select",
            "order_id, user_id, hotel_id, hotel_checkin, room_count, status, create_time",
            "from hotelorder",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "order_id", property = "orderId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "hotel_id", property = "hotelId", jdbcType = JdbcType.INTEGER),
            @Result(column = "hotel_checkin", property = "hotelCheckin", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "room_count", property = "roomCount", jdbcType = JdbcType.INTEGER),
            @Result(column = "status", property = "status", jdbcType = JdbcType.CHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP)
    })
    Hotelorder selectByPrimaryKey(Integer orderId);

    @UpdateProvider(type = HotelorderSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Hotelorder record);

    @Update({
            "update hotelorder",
            "set user_id = #{userId,jdbcType=INTEGER},",
            "hotel_id = #{hotelId,jdbcType=INTEGER},",
            "hotel_checkin = #{hotelCheckin,jdbcType=TIMESTAMP},",
            "room_count = #{roomCount,jdbcType=INTEGER},",
            "status = #{status,jdbcType=CHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP}",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Hotelorder record);
}