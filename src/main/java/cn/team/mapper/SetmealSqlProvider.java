package cn.team.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.team.entity.Setmeal;

public class SetmealSqlProvider {

    public String insertSelective(Setmeal record) {
        BEGIN();
        INSERT_INTO("setmeal");

        if (record.getMealId() != null) {
            VALUES("meal_id", "#{mealId,jdbcType=INTEGER}");
        }

        if (record.getMealName() != null) {
            VALUES("meal_name", "#{mealName,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=CHAR}");
        }

        if (record.getPrice() != null) {
            VALUES("price", "#{price,jdbcType=DECIMAL}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Setmeal record) {
        BEGIN();
        UPDATE("setmeal");

        if (record.getMealName() != null) {
            SET("meal_name = #{mealName,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=CHAR}");
        }

        if (record.getPrice() != null) {
            SET("price = #{price,jdbcType=DECIMAL}");
        }

        WHERE("meal_id = #{mealId,jdbcType=INTEGER}");

        return SQL();
    }
}