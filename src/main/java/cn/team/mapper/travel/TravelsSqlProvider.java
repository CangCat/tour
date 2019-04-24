package cn.team.mapper.travel;

import org.apache.ibatis.annotations.Param;

public class TravelsSqlProvider {

	public String selectByPage(@Param("startIndex")int startIndex,@Param("size")int size, String status, String scenicName,String userName){
		StringBuilder builder = new StringBuilder();
		builder.append("select t.travel_id tId,t.intro intro,t.like_num likeNum,t.look_num lookNum,t.status status,t.create_time createTime,s.scenic_name sName,s.scenic_id sId,u.user_id uId,u.user_name uName from travels t,scenic s,usersOne u where s.scenic_id = t.scenic_id and u.user_id= t.user_id");
		if(status!=null){
			if(!status.equals("")){
				builder.append(" and status = "+ status);
			}
		}
		
		if(scenicName!=null){
			if(!scenicName.equals("")){
				builder.append(" and  scenic_name like  '%"+ scenicName +"%'");
			}
		}
		
		if(userName!=null){
			if(!userName.equals("")){
				builder.append(" and user_name like  '%"+ userName +"%'");
			}
		}
		
		builder.append(" limit ${startIndex},${size}");
		return builder.toString();
	}
	
	public String selectCountAll(String status, String scenicName,String userName){
		StringBuilder builder = new StringBuilder();
		builder.append("select count(1) from travels t,scenic s,usersOne u where s.scenic_id = t.scenic_id and u.user_id= t.user_id");
		if(status!=null){
			if(!status.equals("")){
				builder.append(" and status = "+ status);
			}
		}
		
		if(scenicName!=null){
			if(!scenicName.equals("")){
				builder.append(" and  scenic_name like  '%"+ scenicName +"%'");
			}
		}
		
		if(userName!=null){
			if(!userName.equals("")){
				builder.append(" and user_name like  '%"+ userName +"%'");
			}
		}
		
		return builder.toString();
	}
}
