package cn.team.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.team.entity.Restaurant;

public class RestaurantSqlProvider {

    public String insertSelective(Restaurant record) {
        BEGIN();
        INSERT_INTO("restaurant");

        if (record.getRestId() != null) {
            VALUES("rest_id", "#{restId,jdbcType=INTEGER}");
        }

        if (record.getScenicId() != null) {
            VALUES("scenic_id", "#{scenicId,jdbcType=INTEGER}");
        }

        if (record.getRestName() != null) {
            VALUES("rest_name", "#{restName,jdbcType=VARCHAR}");
        }

        if (record.getRestTel() != null) {
            VALUES("rest_tel", "#{restTel,jdbcType=VARCHAR}");
        }

        if (record.getRestPic() != null) {
            VALUES("rest_pic", "#{restPic,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=CHAR}");
        }

        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getRestIntro() != null) {
            VALUES("rest_intro", "#{restIntro,jdbcType=LONGVARCHAR}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Restaurant record) {
        BEGIN();
        UPDATE("restaurant");

        if (record.getScenicId() != null) {
            SET("scenic_id = #{scenicId,jdbcType=INTEGER}");
        }

        if (record.getRestName() != null) {
            SET("rest_name = #{restName,jdbcType=VARCHAR}");
        }

        if (record.getRestTel() != null) {
            SET("rest_tel = #{restTel,jdbcType=VARCHAR}");
        }

        if (record.getRestPic() != null) {
            SET("rest_pic = #{restPic,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=CHAR}");
        }

        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getRestIntro() != null) {
            SET("rest_intro = #{restIntro,jdbcType=LONGVARCHAR}");
        }

        WHERE("rest_id = #{restId,jdbcType=INTEGER}");

        return SQL();
    }
}