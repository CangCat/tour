package cn.team.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.team.entity.Travels;

public class TravelsSqlProvider {

    public String insertSelective(Travels record) {
        BEGIN();
        INSERT_INTO("travels");

        if (record.getTravelId() != null) {
            VALUES("travel_id", "#{travelId,jdbcType=INTEGER}");
        }

        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }

        if (record.getScenicId() != null) {
            VALUES("scenic_id", "#{scenicId,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getPrefaction() != null) {
            VALUES("prefaction", "#{prefaction,jdbcType=INTEGER}");
        }

        if (record.getLookNum() != null) {
            VALUES("look_num", "#{lookNum,jdbcType=INTEGER}");
        }

        if (record.getPicture() != null) {
            VALUES("picture", "#{picture,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=CHAR}");
        }

        if (record.getLikeNum() != null) {
            VALUES("like_num", "#{likeNum,jdbcType=INTEGER}");
        }

        if (record.getIntro() != null) {
            VALUES("intro", "#{intro,jdbcType=LONGVARCHAR}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Travels record) {
        BEGIN();
        UPDATE("travels");

        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }

        if (record.getScenicId() != null) {
            SET("scenic_id = #{scenicId,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getPrefaction() != null) {
            SET("prefaction = #{prefaction,jdbcType=INTEGER}");
        }

        if (record.getLookNum() != null) {
            SET("look_num = #{lookNum,jdbcType=INTEGER}");
        }

        if (record.getPicture() != null) {
            SET("picture = #{picture,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=CHAR}");
        }

        if (record.getLikeNum() != null) {
            SET("like_num = #{likeNum,jdbcType=INTEGER}");
        }

        if (record.getIntro() != null) {
            SET("intro = #{intro,jdbcType=LONGVARCHAR}");
        }

        WHERE("travel_id = #{travelId,jdbcType=INTEGER}");

        return SQL();
    }
}