package cn.team.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.team.entity.Restorder;

public class RestorderSqlProvider {

    public String insertSelective(Restorder record) {
        BEGIN();
        INSERT_INTO("restorder");

        if (record.getOrderId() != null) {
            VALUES("order_id", "#{orderId,jdbcType=INTEGER}");
        }

        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }

        if (record.getRestId() != null) {
            VALUES("rest_id", "#{restId,jdbcType=INTEGER}");
        }

        if (record.getEatTime() != null) {
            VALUES("eat_time", "#{eatTime,jdbcType=TIMESTAMP}");
        }

        if (record.getTableCount() != null) {
            VALUES("table_count", "#{tableCount,jdbcType=INTEGER}");
        }

        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=CHAR}");
        }

        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Restorder record) {
        BEGIN();
        UPDATE("restorder");

        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }

        if (record.getRestId() != null) {
            SET("rest_id = #{restId,jdbcType=INTEGER}");
        }

        if (record.getEatTime() != null) {
            SET("eat_time = #{eatTime,jdbcType=TIMESTAMP}");
        }

        if (record.getTableCount() != null) {
            SET("table_count = #{tableCount,jdbcType=INTEGER}");
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