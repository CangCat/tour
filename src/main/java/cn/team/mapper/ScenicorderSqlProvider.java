package cn.team.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.team.entity.Scenicorder;

public class ScenicorderSqlProvider {

    public String insertSelective(Scenicorder record) {
        BEGIN();
        INSERT_INTO("scenicorder");

        if (record.getOrderId() != null) {
            VALUES("order_id", "#{orderId,jdbcType=INTEGER}");
        }

        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }

        if (record.getScenicId() != null) {
            VALUES("scenic_id", "#{scenicId,jdbcType=INTEGER}");
        }

        if (record.getAccount() != null) {
            VALUES("account", "#{account,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=CHAR}");
        }

        if (record.getPlayTime() != null) {
            VALUES("play_time", "#{playTime,jdbcType=TIMESTAMP}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Scenicorder record) {
        BEGIN();
        UPDATE("scenicorder");

        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }

        if (record.getScenicId() != null) {
            SET("scenic_id = #{scenicId,jdbcType=INTEGER}");
        }

        if (record.getAccount() != null) {
            SET("account = #{account,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=CHAR}");
        }

        if (record.getPlayTime() != null) {
            SET("play_time = #{playTime,jdbcType=TIMESTAMP}");
        }

        WHERE("order_id = #{orderId,jdbcType=INTEGER}");

        return SQL();
    }
}