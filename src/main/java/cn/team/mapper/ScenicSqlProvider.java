package cn.team.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.team.entity.Scenic;

public class ScenicSqlProvider {

    public String insertSelective(Scenic record) {
        BEGIN();
        INSERT_INTO("scenic");

        if (record.getScenicId() != null) {
            VALUES("scenic_id", "#{scenicId,jdbcType=INTEGER}");
        }

        if (record.getScenicName() != null) {
            VALUES("scenic_name", "#{scenicName,jdbcType=VARCHAR}");
        }

        if (record.getScenicAddress() != null) {
            VALUES("scenic_address", "#{scenicAddress,jdbcType=VARCHAR}");
        }

        if (record.getScenicLink() != null) {
            VALUES("scenic_link", "#{scenicLink,jdbcType=VARCHAR}");
        }

        if (record.getScenicTel() != null) {
            VALUES("scenic_tel", "#{scenicTel,jdbcType=VARCHAR}");
        }

        if (record.getScenicTicket() != null) {
            VALUES("scenic_ticket", "#{scenicTicket,jdbcType=CHAR}");
        }

        if (record.getScenicCharge() != null) {
            VALUES("scenic_charge", "#{scenicCharge,jdbcType=DOUBLE}");
        }

        if (record.getScenicPic() != null) {
            VALUES("scenic_pic", "#{scenicPic,jdbcType=VARCHAR}");
        }

        if (record.getOpenTime() != null) {
            VALUES("open_time", "#{openTime,jdbcType=VARCHAR}");
        }

        if (record.getEndTime() != null) {
            VALUES("end_time", "#{endTime,jdbcType=VARCHAR}");
        }

        if (record.getCheckType() != null) {
            VALUES("check_type", "#{checkType,jdbcType=CHAR}");
        }

        if (record.getScenicStatus() != null) {
            VALUES("scenic_status", "#{scenicStatus,jdbcType=CHAR}");
        }

        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getTypeOne() != null) {
            VALUES("type_one", "#{typeOne,jdbcType=CHAR}");
        }

        if (record.getTypeTwo() != null) {
            VALUES("type_two", "#{typeTwo,jdbcType=CHAR}");
        }

        if (record.getScenicIntro() != null) {
            VALUES("scenic_intro", "#{scenicIntro,jdbcType=LONGVARCHAR}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Scenic record) {
        BEGIN();
        UPDATE("scenic");

        if (record.getScenicName() != null) {
            SET("scenic_name = #{scenicName,jdbcType=VARCHAR}");
        }

        if (record.getScenicAddress() != null) {
            SET("scenic_address = #{scenicAddress,jdbcType=VARCHAR}");
        }

        if (record.getScenicLink() != null) {
            SET("scenic_link = #{scenicLink,jdbcType=VARCHAR}");
        }

        if (record.getScenicTel() != null) {
            SET("scenic_tel = #{scenicTel,jdbcType=VARCHAR}");
        }

        if (record.getScenicTicket() != null) {
            SET("scenic_ticket = #{scenicTicket,jdbcType=CHAR}");
        }

        if (record.getScenicCharge() != null) {
            SET("scenic_charge = #{scenicCharge,jdbcType=DOUBLE}");
        }

        if (record.getScenicPic() != null) {
            SET("scenic_pic = #{scenicPic,jdbcType=VARCHAR}");
        }

        if (record.getOpenTime() != null) {
            SET("open_time = #{openTime,jdbcType=VARCHAR}");
        }

        if (record.getEndTime() != null) {
            SET("end_time = #{endTime,jdbcType=VARCHAR}");
        }

        if (record.getCheckType() != null) {
            SET("check_type = #{checkType,jdbcType=CHAR}");
        }

        if (record.getScenicStatus() != null) {
            SET("scenic_status = #{scenicStatus,jdbcType=CHAR}");
        }

        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getTypeOne() != null) {
            SET("type_one = #{typeOne,jdbcType=CHAR}");
        }

        if (record.getTypeTwo() != null) {
            SET("type_two = #{typeTwo,jdbcType=CHAR}");
        }

        if (record.getScenicIntro() != null) {
            SET("scenic_intro = #{scenicIntro,jdbcType=LONGVARCHAR}");
        }

        WHERE("scenic_id = #{scenicId,jdbcType=INTEGER}");

        return SQL();
    }
}