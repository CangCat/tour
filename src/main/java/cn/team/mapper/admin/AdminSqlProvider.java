package cn.team.mapper.admin;

import org.apache.ibatis.annotations.Param;

import cn.team.entity.Admin;

public class AdminSqlProvider {

public String AdminselectAllByPage(@Param("startIndex")int startIndex,@Param("size")int size,@Param("admin")Admin admin,@Param("desc")Integer desc){
		
//		System.out.println("测试传过来的admin"+admin);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(" select ");
		sb.append(" a.admin_id,a.name,a.login_name,a.password,a.tel,a.gender,a.pic, "+" a.admin_status,a.register_time,a.update_time,a.admin_type ");
		sb.append(" from admin a where 1=1 ");
		
		if(admin.getName()!=null&&admin.getName().length()>0){
			
			sb.append(" and a.name=#{admin.name} ");	
		}
		
		
		if(admin.getAdminStatus()!=null&&admin.getAdminStatus().length()>0){
			
			sb.append(" and a.admin_status=#{admin.adminStatus} ");
		}
		
		if(desc==1){
			sb.append(" order by a.admin_id desc ");
		}
		
		if(desc==0){
			sb.append(" order by a.admin_id asc ");
		}
		
//	sb.append(" and a.admin_status=0 ");
	sb.append(" limit #{startIndex},#{size}");
//	System.out.println("生成的动态sql为------"+sb.toString());

		return sb.toString();
	}
	
	public String AdminselectCountAll(@Param("admin")Admin admin,@Param("desc")int desc){
		
		//		System.out.println("测试传过来的admin"+admin);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(" select count(*) from admin a where 1=1 ");
		
		if(admin.getName()!=null&&admin.getName().length()>0){
			
			sb.append(" and a.name=#{admin.name} ");	
		}
		
		
		if(admin.getAdminStatus()!=null&&admin.getAdminStatus().length()>0){
			
			sb.append(" and a.admin_status=#{admin.adminStatus} ");
		}
		
		return sb.toString();
	}
	
	
}
