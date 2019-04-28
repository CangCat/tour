package cn.team.mapper.userOne;

import org.apache.ibatis.annotations.Param;

import cn.team.entity.Admin;
import cn.team.entity.UsersOne;

public class UsersOneSqlProvider {

	
		public String UserselectAllByPage(@Param("startIndex")int startIndex,@Param("size")int size,@Param("user")UsersOne user,@Param("desc")Integer desc){
		
//		System.out.println("测试传过来的admin"+admin);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(" select ");
		sb.append(" u.user_id,u.user_name,u.email,u.password,u.tel,u.gender,u.user_status,u.pic,u.register_time,u.update_time ");
		sb.append(" from usersOne u where 1=1 ");
		
		if(user.getUserName()!=null&&user.getUserName().length()>0){
			
			sb.append(" and u.user_name like '%${user.userName}%' ");
			
			//sb.append(" and u.user_name=#{user.userName} ");	
		}
		
		
		if(user.getUserStatus()!=null&&user.getUserStatus().length()>0){
			
			sb.append(" and u.user_status=#{user.userStatus} ");
		}
		
		if(desc==1){
			sb.append(" order by u.user_id desc ");
		}
		
		if(desc==0){
			sb.append(" order by u.user_id asc ");
		}
		
	//	sb.append(" and a.admin_status=0 ");
		sb.append(" limit #{startIndex},#{size}");
	//	System.out.println("生成的动态sql为------"+sb.toString());

		return sb.toString();
	}
	
		
		//总数S
		public String UserselectCountAll(@Param("user")UsersOne user,@Param("desc")Integer desc){
			
			//		System.out.println("测试传过来的admin"+admin);
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(" select count(*) from usersOne u where 1=1 ");
			
			if(user.getUserName()!=null&&user.getUserName().length()>0){
				
				sb.append(" and u.user_name like '%${user.userName}%' ");
				
				//sb.append(" and u.user_name=#{user.userName} ");	
			}
			
			
			
			if(user.getUserStatus()!=null&&user.getUserStatus().length()>0){
				
				sb.append(" and u.user_status=#{user.userStatus} ");
			}
			
			
			return sb.toString();
		}
	
	
}
