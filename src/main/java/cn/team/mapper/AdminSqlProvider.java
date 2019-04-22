package cn.team.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.team.entity.Admin;

public class AdminSqlProvider {

    public String insertSelective(Admin record) {
        BEGIN();
        INSERT_INTO("admin");

        if (record.getAdminId() != null) {
            VALUES("admin_id", "#{adminId,jdbcType=INTEGER}");
        }

        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }

        if (record.getLoginName() != null) {
            VALUES("login_name", "#{loginName,jdbcType=VARCHAR}");
        }

        if (record.getPassword() != null) {
            VALUES("password", "#{password,jdbcType=VARCHAR}");
        }

        if (record.getTel() != null) {
            VALUES("tel", "#{tel,jdbcType=VARCHAR}");
        }

        if (record.getGender() != null) {
            VALUES("gender", "#{gender,jdbcType=CHAR}");
        }

        if (record.getPic() != null) {
            VALUES("pic", "#{pic,jdbcType=VARCHAR}");
        }

        if (record.getAdminStatus() != null) {
            VALUES("admin_status", "#{adminStatus,jdbcType=CHAR}");
        }

        if (record.getRegisterTime() != null) {
            VALUES("register_time", "#{registerTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getAdminType() != null) {
            VALUES("admin_type", "#{adminType,jdbcType=CHAR}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Admin record) {
        BEGIN();
        UPDATE("admin");

        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }

        if (record.getLoginName() != null) {
            SET("login_name = #{loginName,jdbcType=VARCHAR}");
        }

        if (record.getPassword() != null) {
            SET("password = #{password,jdbcType=VARCHAR}");
        }

        if (record.getTel() != null) {
            SET("tel = #{tel,jdbcType=VARCHAR}");
        }

        if (record.getGender() != null) {
            SET("gender = #{gender,jdbcType=CHAR}");
        }

        if (record.getPic() != null) {
            SET("pic = #{pic,jdbcType=VARCHAR}");
        }

        if (record.getAdminStatus() != null) {
            SET("admin_status = #{adminStatus,jdbcType=CHAR}");
        }

        if (record.getRegisterTime() != null) {
            SET("register_time = #{registerTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getAdminType() != null) {
            SET("admin_type = #{adminType,jdbcType=CHAR}");
        }

        WHERE("admin_id = #{adminId,jdbcType=INTEGER}");

        return SQL();
    }
}