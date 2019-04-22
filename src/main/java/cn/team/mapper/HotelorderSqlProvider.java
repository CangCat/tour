package cn.team.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.team.entity.Hotelorder;

public class HotelorderSqlProvider {

    public String insertSelective(Hotelorder record) {
        BEGIN();
        INSERT_INTO("hotelorder");

        if (record.getOrderId() != null) {
            VALUES("order_id", "#{orderId,jdbcType=INTEGER}");
        }

        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }

        if (record.getHotelId() != null) {
            VALUES("hotel_id", "#{hotelId,jdbcType=INTEGER}");
        }

        if (record.getHotelCheckin() != null) {
            VALUES("hotel_checkin", "#{hotelCheckin,jdbcType=TIMESTAMP}");
        }

        if (record.getRoomCount() != null) {
            VALUES("room_count", "#{roomCount,jdbcType=INTEGER}");
        }

        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=CHAR}");
        }

        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Hotelorder record) {
        BEGIN();
        UPDATE("hotelorder");

        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }

        if (record.getHotelId() != null) {
            SET("hotel_id = #{hotelId,jdbcType=INTEGER}");
        }

        if (record.getHotelCheckin() != null) {
            SET("hotel_checkin = #{hotelCheckin,jdbcType=TIMESTAMP}");
        }

        if (record.getRoomCount() != null) {
            SET("room_count = #{roomCount,jdbcType=INTEGER}");
        }

        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=CHAR}");
        }

        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        WHERE("order_id = #{orderId,jdbcType=INTEGER}");

        return SQL();
    }
}