package cn.team.mapper;

import cn.team.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface UsersMapper {
    @Insert({
            "insert into users (USER, CURRENT_CONNECTIONS, ",
            "TOTAL_CONNECTIONS)",
            "values (#{user,jdbcType=CHAR}, #{currentConnections,jdbcType=BIGINT}, ",
            "#{totalConnections,jdbcType=BIGINT})"
    })
    int insert(Users record);

    @InsertProvider(type = UsersSqlProvider.class, method = "insertSelective")
    int insertSelective(Users record);
}