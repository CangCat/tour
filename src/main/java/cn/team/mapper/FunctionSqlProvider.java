package cn.team.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.team.entity.Function;

public class FunctionSqlProvider {

    public String insertSelective(Function record) {
        BEGIN();
        INSERT_INTO("function");

        if (record.getFunId() != null) {
            VALUES("fun_id", "#{funId,jdbcType=INTEGER}");
        }

        if (record.getScenicId() != null) {
            VALUES("scenic_id", "#{scenicId,jdbcType=INTEGER}");
        }

        if (record.getFunName() != null) {
            VALUES("fun_name", "#{funName,jdbcType=VARCHAR}");
        }

        if (record.getFunTime() != null) {
            VALUES("fun_time", "#{funTime,jdbcType=VARCHAR}");
        }

        if (record.getFunAddress() != null) {
            VALUES("fun_address", "#{funAddress,jdbcType=VARCHAR}");
        }

        if (record.getFunPic() != null) {
            VALUES("fun_pic", "#{funPic,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=CHAR}");
        }

        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getFunIntro() != null) {
            VALUES("fun_intro", "#{funIntro,jdbcType=LONGVARCHAR}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Function record) {
        BEGIN();
        UPDATE("function");

        if (record.getScenicId() != null) {
            SET("scenic_id = #{scenicId,jdbcType=INTEGER}");
        }

        if (record.getFunName() != null) {
            SET("fun_name = #{funName,jdbcType=VARCHAR}");
        }

        if (record.getFunTime() != null) {
            SET("fun_time = #{funTime,jdbcType=VARCHAR}");
        }

        if (record.getFunAddress() != null) {
            SET("fun_address = #{funAddress,jdbcType=VARCHAR}");
        }

        if (record.getFunPic() != null) {
            SET("fun_pic = #{funPic,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=CHAR}");
        }

        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getFunIntro() != null) {
            SET("fun_intro = #{funIntro,jdbcType=LONGVARCHAR}");
        }

        WHERE("fun_id = #{funId,jdbcType=INTEGER}");

        return SQL();
    }
}