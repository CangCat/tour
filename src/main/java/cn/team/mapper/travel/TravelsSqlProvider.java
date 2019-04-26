package cn.team.mapper.travel;

import org.apache.ibatis.annotations.Param;

import cn.team.entity.Travels;

public class TravelsSqlProvider {

	/**
	 * 多表多条件动态分页查询
	 * @param startIndex
	 * @param size
	 * @param status
	 * @param scenicName
	 * @param userName
	 * @return
	 */
	public String selectByPage(@Param("startIndex")int startIndex,@Param("size")int size, @Param("status")String status, @Param("scenicName")String scenicName,@Param("userName")String userName){
		StringBuilder builder = new StringBuilder();
		builder.append("select t.travel_id tId,t.intro intro,t.like_num likeNum,t.look_num lookNum,t.status status,t.create_time createTime,s.scenic_name sName,s.scenic_id sId,u.user_id uId,u.user_name uName from travels t,scenic s,usersOne u where s.scenic_id = t.scenic_id and u.user_id= t.user_id");
		if(status!=null){
			if(!status.equals("")){
				builder.append(" and status = #{status}");
			}
		}
		
		if(scenicName!=null){
			if(!scenicName.equals("")){
				builder.append(" and  scenic_name like  '%#{scenicName}%'");
			}
		}
		
		if(userName!=null){
			if(!userName.equals("")){
				builder.append(" and user_name like  '%#{userName}%'");
			}
		}
		builder.append("  ORDER BY travel_id desc");
		builder.append(" limit #{startIndex},#{size}");
		return builder.toString();
	}
	
	/**
	 * 分页的总数
	 * @param status
	 * @param scenicName
	 * @param userName
	 * @return
	 */
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
	
	/**
	 * 动态修改
	 * @param travels
	 * @return
	 */
	public String updateTravel(Travels travels){
		StringBuilder builder =  new StringBuilder();
		builder.append("update travels set ");
		if(travels.getIntro()!=null&&!travels.getIntro().equals("")){
			builder.append(" intro=#{intro},");
		}
		if(travels.getPrefaction()!=null&& !travels.getPrefaction().equals("")){
			builder.append(" prefaction=#{prefaction},");
		}
		if(travels.getLookNum()!=null){
			builder.append(" look_num=#{lookNum},");
		}
		if(travels.getPicture()!=null && !travels.getPicture().equals("")){
			builder.append(" picture=#{picture},");
		}
		if(travels.getStatus()!=null && !travels.getStatus().equals("")){
			builder.append(" status=#{status},");
		}
		if(travels.getLikeNum()!=null){
			builder.append(" like_num=#{likeNum},");
		}
		builder.deleteCharAt(builder.length()-1);
		builder.append(" where travel_id=#{travelId}");
		return builder.toString();
	}
}
