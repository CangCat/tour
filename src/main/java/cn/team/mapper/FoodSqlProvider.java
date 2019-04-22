package cn.team.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.team.entity.Food;

public class FoodSqlProvider {

    public String insertSelective(Food record) {
        BEGIN();
        INSERT_INTO("food");

        if (record.getFoodId() != null) {
            VALUES("food_id", "#{foodId,jdbcType=INTEGER}");
        }

        if (record.getRestId() != null) {
            VALUES("rest_id", "#{restId,jdbcType=INTEGER}");
        }

        if (record.getFoodName() != null) {
            VALUES("food_name", "#{foodName,jdbcType=VARCHAR}");
        }

        if (record.getFoodTel() != null) {
            VALUES("food_tel", "#{foodTel,jdbcType=VARCHAR}");
        }

        if (record.getFoodPic() != null) {
            VALUES("food_pic", "#{foodPic,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=CHAR}");
        }

        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getFoodIntro() != null) {
            VALUES("food_intro", "#{foodIntro,jdbcType=LONGVARCHAR}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Food record) {
        BEGIN();
        UPDATE("food");

        if (record.getRestId() != null) {
            SET("rest_id = #{restId,jdbcType=INTEGER}");
        }

        if (record.getFoodName() != null) {
            SET("food_name = #{foodName,jdbcType=VARCHAR}");
        }

        if (record.getFoodTel() != null) {
            SET("food_tel = #{foodTel,jdbcType=VARCHAR}");
        }

        if (record.getFoodPic() != null) {
            SET("food_pic = #{foodPic,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=CHAR}");
        }

        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getFoodIntro() != null) {
            SET("food_intro = #{foodIntro,jdbcType=LONGVARCHAR}");
        }

        WHERE("food_id = #{foodId,jdbcType=INTEGER}");

        return SQL();
    }
}