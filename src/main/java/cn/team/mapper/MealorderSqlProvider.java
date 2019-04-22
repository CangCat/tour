package cn.team.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.team.entity.Mealorder;

public class MealorderSqlProvider {

    public String insertSelective(Mealorder record) {
        BEGIN();
        INSERT_INTO("mealorder");

        if (record.getOrderId() != null) {
            VALUES("order_id", "#{orderId,jdbcType=INTEGER}");
        }

        if (record.getMealId() != null) {
            VALUES("meal_id", "#{mealId,jdbcType=INTEGER}");
        }

        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getPlayTime() != null) {
            VALUES("play_time", "#{playTime,jdbcType=TIMESTAMP}");
        }

        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=CHAR}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Mealorder record) {
        BEGIN();
        UPDATE("mealorder");

        if (record.getMealId() != null) {
            SET("meal_id = #{mealId,jdbcType=INTEGER}");
        }

        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getPlayTime() != null) {
            SET("play_time = #{playTime,jdbcType=TIMESTAMP}");
        }

        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=CHAR}");
        }

        WHERE("order_id = #{orderId,jdbcType=INTEGER}");

        return SQL();
    }
}