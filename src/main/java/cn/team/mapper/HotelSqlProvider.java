package cn.team.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.team.entity.Hotel;

public class HotelSqlProvider {

    public String insertSelective(Hotel record) {
        BEGIN();
        INSERT_INTO("hotel");

        if (record.getHotelId() != null) {
            VALUES("hotel_id", "#{hotelId,jdbcType=INTEGER}");
        }

        if (record.getScenicId() != null) {
            VALUES("scenic_id", "#{scenicId,jdbcType=INTEGER}");
        }

        if (record.getHotelClass() != null) {
            VALUES("hotel_class", "#{hotelClass,jdbcType=CHAR}");
        }

        if (record.getHotelName() != null) {
            VALUES("hotel_name", "#{hotelName,jdbcType=VARCHAR}");
        }

        if (record.getHotelLink() != null) {
            VALUES("hotel_link", "#{hotelLink,jdbcType=VARCHAR}");
        }

        if (record.getHotelTel() != null) {
            VALUES("hotel_tel", "#{hotelTel,jdbcType=VARCHAR}");
        }

        if (record.getHotelAddress() != null) {
            VALUES("hotel_address", "#{hotelAddress,jdbcType=VARCHAR}");
        }

        if (record.getHotelPic() != null) {
            VALUES("hotel_pic", "#{hotelPic,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=CHAR}");
        }

        if (record.getCreatTime() != null) {
            VALUES("creat_time", "#{creatTime,jdbcType=TIMESTAMP}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Hotel record) {
        BEGIN();
        UPDATE("hotel");

        if (record.getScenicId() != null) {
            SET("scenic_id = #{scenicId,jdbcType=INTEGER}");
        }

        if (record.getHotelClass() != null) {
            SET("hotel_class = #{hotelClass,jdbcType=CHAR}");
        }

        if (record.getHotelName() != null) {
            SET("hotel_name = #{hotelName,jdbcType=VARCHAR}");
        }

        if (record.getHotelLink() != null) {
            SET("hotel_link = #{hotelLink,jdbcType=VARCHAR}");
        }

        if (record.getHotelTel() != null) {
            SET("hotel_tel = #{hotelTel,jdbcType=VARCHAR}");
        }

        if (record.getHotelAddress() != null) {
            SET("hotel_address = #{hotelAddress,jdbcType=VARCHAR}");
        }

        if (record.getHotelPic() != null) {
            SET("hotel_pic = #{hotelPic,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=CHAR}");
        }

        if (record.getCreatTime() != null) {
            SET("creat_time = #{creatTime,jdbcType=TIMESTAMP}");
        }

        WHERE("hotel_id = #{hotelId,jdbcType=INTEGER}");

        return SQL();
    }
}