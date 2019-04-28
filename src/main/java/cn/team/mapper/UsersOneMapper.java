package cn.team.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import cn.team.entity.Admin;
import cn.team.entity.UsersOne;
import cn.team.mapper.admin.AdminSqlProvider;
import cn.team.mapper.userOne.UsersOneSqlProvider;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface UsersOneMapper extends Mapper<UsersOne>, MySqlMapper<UsersOne>{

	
	//动态sql查询
	@SelectProvider(type=UsersOneSqlProvider.class,method="UserselectAllByPage")
    //参数map 对应 查询条件  封装的map 按照查询条件应该有  "os_username"=xx,"unix_host"=xxx,"idcard_no"=xxx,"status"=xxx
    List<UsersOne> UserselectAllByPage(@Param("startIndex")int startIndex,@Param("size")int size,@Param("user")UsersOne user,@Param("desc")Integer desc);
		 
	
	//查询总数
	@SelectProvider(type=UsersOneSqlProvider.class,method="UserselectCountAll")
    int UserselectCountAll(@Param("user")UsersOne user,@Param("desc")int desc);

	
}
