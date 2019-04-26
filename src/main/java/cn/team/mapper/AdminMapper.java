package cn.team.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import cn.team.entity.Admin;
import cn.team.mapper.admin.AdminSqlProvider;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface AdminMapper extends Mapper<Admin>, MySqlMapper<Admin>{

	
		//动态sql查询
		@SelectProvider(type=AdminSqlProvider.class,method="AdminselectAllByPage")
	    //参数map 对应 查询条件  封装的map 按照查询条件应该有  "os_username"=xx,"unix_host"=xxx,"idcard_no"=xxx,"status"=xxx
	    List<Admin> adminSelectAllByPage(@Param("startIndex")int startIndex,@Param("size")int size,@Param("admin")Admin admin,@Param("desc")Integer desc);
	    
		//查询总数
		@SelectProvider(type=AdminSqlProvider.class,method="AdminselectCountAll")
	    int AdminselectCountAll(@Param("admin")Admin admin,@Param("desc")int desc);

}
