package cn.team.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.team.entity.Room;

public class RoomSqlProvider {

    public String insertSelective(Room record) {
        BEGIN();
        INSERT_INTO("room");

        if (record.getRoomId() != null) {
            VALUES("room_id", "#{roomId,jdbcType=INTEGER}");
        }

        if (record.getRoomName() != null) {
            VALUES("room_name", "#{roomName,jdbcType=VARCHAR}");
        }

        if (record.getRoomPrice() != null) {
            VALUES("room_price", "#{roomPrice,jdbcType=DECIMAL}");
        }

        if (record.getRoomRemark() != null) {
            VALUES("room_remark", "#{roomRemark,jdbcType=VARCHAR}");
        }

        if (record.getRoomPic() != null) {
            VALUES("room_pic", "#{roomPic,jdbcType=VARCHAR}");
        }

        if (record.getHotelId() != null) {
            VALUES("hotel_id", "#{hotelId,jdbcType=INTEGER}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Room record) {
        BEGIN();
        UPDATE("room");

        if (record.getRoomName() != null) {
            SET("room_name = #{roomName,jdbcType=VARCHAR}");
        }

        if (record.getRoomPrice() != null) {
            SET("room_price = #{roomPrice,jdbcType=DECIMAL}");
        }

        if (record.getRoomRemark() != null) {
            SET("room_remark = #{roomRemark,jdbcType=VARCHAR}");
        }

        if (record.getRoomPic() != null) {
            SET("room_pic = #{roomPic,jdbcType=VARCHAR}");
        }

        if (record.getHotelId() != null) {
            SET("hotel_id = #{hotelId,jdbcType=INTEGER}");
        }

        WHERE("room_id = #{roomId,jdbcType=INTEGER}");

        return SQL();
    }
}