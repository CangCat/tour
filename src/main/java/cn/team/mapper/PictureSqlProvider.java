package cn.team.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.team.entity.Picture;

public class PictureSqlProvider {

    public String insertSelective(Picture record) {
        BEGIN();
        INSERT_INTO("picture");

        if (record.getPicId() != null) {
            VALUES("pic_id", "#{picId,jdbcType=INTEGER}");
        }

        if (record.getPicName() != null) {
            VALUES("pic_name", "#{picName,jdbcType=VARCHAR}");
        }

        if (record.getPicUrl() != null) {
            VALUES("pic_url", "#{picUrl,jdbcType=VARCHAR}");
        }

        if (record.getPicIntro() != null) {
            VALUES("pic_intro", "#{picIntro,jdbcType=LONGVARCHAR}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Picture record) {
        BEGIN();
        UPDATE("picture");

        if (record.getPicName() != null) {
            SET("pic_name = #{picName,jdbcType=VARCHAR}");
        }

        if (record.getPicUrl() != null) {
            SET("pic_url = #{picUrl,jdbcType=VARCHAR}");
        }

        if (record.getPicIntro() != null) {
            SET("pic_intro = #{picIntro,jdbcType=LONGVARCHAR}");
        }

        WHERE("pic_id = #{picId,jdbcType=INTEGER}");

        return SQL();
    }
}