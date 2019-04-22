package cn.team.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import cn.team.entity.Users;

public class UsersSqlProvider {

    public String insertSelective(Users record) {
        BEGIN();
        INSERT_INTO("users");

        if (record.getUser() != null) {
            VALUES("USER", "#{user,jdbcType=CHAR}");
        }

        if (record.getCurrentConnections() != null) {
            VALUES("CURRENT_CONNECTIONS", "#{currentConnections,jdbcType=BIGINT}");
        }

        if (record.getTotalConnections() != null) {
            VALUES("TOTAL_CONNECTIONS", "#{totalConnections,jdbcType=BIGINT}");
        }

        return SQL();
    }
}