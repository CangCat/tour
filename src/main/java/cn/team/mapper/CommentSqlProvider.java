package cn.team.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.team.entity.Comment;

public class CommentSqlProvider {

    public String insertSelective(Comment record) {
        BEGIN();
        INSERT_INTO("comment");

        if (record.getCommId() != null) {
            VALUES("comm_id", "#{commId,jdbcType=INTEGER}");
        }

        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }

        if (record.getProjectId() != null) {
            VALUES("project_id", "#{projectId,jdbcType=INTEGER}");
        }

        if (record.getCommTime() != null) {
            VALUES("comm_time", "#{commTime,jdbcType=TIMESTAMP}");
        }

        if (record.getPerfection() != null) {
            VALUES("perfection", "#{perfection,jdbcType=INTEGER}");
        }

        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=CHAR}");
        }

        if (record.getLookNum() != null) {
            VALUES("look_num", "#{lookNum,jdbcType=INTEGER}");
        }

        if (record.getProjectType() != null) {
            VALUES("project_type", "#{projectType,jdbcType=CHAR}");
        }

        if (record.getCommIntro() != null) {
            VALUES("comm_intro", "#{commIntro,jdbcType=LONGVARCHAR}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Comment record) {
        BEGIN();
        UPDATE("comment");

        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }

        if (record.getProjectId() != null) {
            SET("project_id = #{projectId,jdbcType=INTEGER}");
        }

        if (record.getCommTime() != null) {
            SET("comm_time = #{commTime,jdbcType=TIMESTAMP}");
        }

        if (record.getPerfection() != null) {
            SET("perfection = #{perfection,jdbcType=INTEGER}");
        }

        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=CHAR}");
        }

        if (record.getLookNum() != null) {
            SET("look_num = #{lookNum,jdbcType=INTEGER}");
        }

        if (record.getProjectType() != null) {
            SET("project_type = #{projectType,jdbcType=CHAR}");
        }

        if (record.getCommIntro() != null) {
            SET("comm_intro = #{commIntro,jdbcType=LONGVARCHAR}");
        }

        WHERE("comm_id = #{commId,jdbcType=INTEGER}");

        return SQL();
    }
}