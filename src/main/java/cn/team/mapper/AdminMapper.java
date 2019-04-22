package cn.team.mapper;

import cn.team.entity.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AdminMapper {
    @Delete({
            "delete from admin",
            "where admin_id = #{adminId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer adminId);

    @Insert({
            "insert into admin (admin_id, name, ",
            "login_name, password, ",
            "tel, gender, pic, ",
            "admin_status, register_time, ",
            "update_time, admin_type)",
            "values (#{adminId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
            "#{loginName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
            "#{tel,jdbcType=VARCHAR}, #{gender,jdbcType=CHAR}, #{pic,jdbcType=VARCHAR}, ",
            "#{adminStatus,jdbcType=CHAR}, #{registerTime,jdbcType=TIMESTAMP}, ",
            "#{updateTime,jdbcType=TIMESTAMP}, #{adminType,jdbcType=CHAR})"
    })
    int insert(Admin record);

    @InsertProvider(type = AdminSqlProvider.class, method = "insertSelective")
    int insertSelective(Admin record);

    @Select({
            "select",
            "admin_id, name, login_name, password, tel, gender, pic, admin_status, register_time, ",
            "update_time, admin_type",
            "from admin",
            "where admin_id = #{adminId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "admin_id", property = "adminId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "login_name", property = "loginName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "tel", property = "tel", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gender", property = "gender", jdbcType = JdbcType.CHAR),
            @Result(column = "pic", property = "pic", jdbcType = JdbcType.VARCHAR),
            @Result(column = "admin_status", property = "adminStatus", jdbcType = JdbcType.CHAR),
            @Result(column = "register_time", property = "registerTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "admin_type", property = "adminType", jdbcType = JdbcType.CHAR)
    })
    Admin selectByPrimaryKey(Integer adminId);

    @UpdateProvider(type = AdminSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Admin record);

    @Update({
            "update admin",
            "set name = #{name,jdbcType=VARCHAR},",
            "login_name = #{loginName,jdbcType=VARCHAR},",
            "password = #{password,jdbcType=VARCHAR},",
            "tel = #{tel,jdbcType=VARCHAR},",
            "gender = #{gender,jdbcType=CHAR},",
            "pic = #{pic,jdbcType=VARCHAR},",
            "admin_status = #{adminStatus,jdbcType=CHAR},",
            "register_time = #{registerTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP},",
            "admin_type = #{adminType,jdbcType=CHAR}",
            "where admin_id = #{adminId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Admin record);
}