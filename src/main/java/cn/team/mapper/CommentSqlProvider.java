package cn.team.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.team.entity.Comment;

public class CommentSqlProvider {
	
	public String selectAllByPage(@Param("startIndex")int startIndex,@Param("size")int size,@Param("comment")Comment comment){
		StringBuilder sb = new StringBuilder();
		
		sb.append("select comm_id,user_id,project_id,comm_intro,comm_time,perfection,status,look_num,project_type from comment where 1=1 ");
		
		if(comment.getStatus()!=null&&comment.getStatus().length()>0&&comment.getStatus()!=""){
			sb.append(" and status = #{comment.status} ");
		}
		if(comment.getCommIntro()!=null&&comment.getCommIntro().length()>0&&comment.getCommIntro()!="") {
			sb.append(" and comm_intro like concat('%',#{comment.commIntro},'%' ) "  );
		}
			sb.append(" limit #{startIndex},#{size} ");
		
		
		String string = sb.toString();
		
		return string;
	}
	
	
	public String selectCount(@Param("comment")Comment comment){
		StringBuilder sb = new StringBuilder();
		
		sb.append("select count(comm_id) from comment where 1=1 ");
		
		if(comment.getStatus()!=null&&comment.getStatus().length()>0&&comment.getStatus()!=""){
			sb.append(" and status = #{comment.status} ");
		}
		if(comment.getCommIntro()!=null&&comment.getCommIntro().length()>0&&comment.getCommIntro()!="") {
			sb.append(" and comm_intro like concat('%',#{comment.commIntro},'%' ) "  );
		}
			
		
		
		String string = sb.toString();
		
		return string;
	}
	
	
	//多表分页查询
	public String selectAllAndUserName(@Param("startIndex")int startIndex,@Param("size")int size,@Param("map")Map<String,Object> map){
		StringBuilder sb = new StringBuilder();
		
		sb.append("select c.comm_id,c.user_id,project_id,comm_intro,comm_time,perfection,status,look_num,project_type,u.user_name from comment c,usersOne u where c.user_id=u.user_id ");
		
		System.out.println("mapper层："+map+"----"+map.get("status"));
		
			if(map.get("status")!=null){
				String status = (String) map.get("status");
				System.out.println("------------------------------"+status);
				if(status.length()>0){
				sb.append(" and c.status=#{map.status } ");
				}
		    }
			
			
			if(map.get("commIntro")!=null){
				String comm_intro = (String) map.get("commIntro");
				if(comm_intro.length()>0){
					sb.append(" and c.comm_intro like concat('%',#{map.commIntro},'%') ");
				}
			}
			
			sb.append(" order by c.comm_id ");
			sb.append(" limit #{startIndex},#{size}");
			String sql = sb.toString();
			return sql;
		
	}
	
	
	//查询总记录数
	public String selectCountWithUserName(Map<String,Object> map){
		StringBuilder sb = new StringBuilder();
		sb.append("select count(c.comm_id) from comment c,usersOne u where c.user_id=u.user_id ");
		
		System.out.println("count:"+map.get("status"));

			if(map.get("status")!=null){
				String status = (String) map.get("status");
				if(status.length()>0){
				sb.append(" and c.status=#{map.status} ");
				}
		    }
			
		
			if(map.get("commIntro")!=null){
				String comm_intro = (String) map.get("commIntro");
				if(comm_intro.length()>0&&comm_intro!=""){
					sb.append(" and c.comm_intro like concat('%',#{map.commIntro},'%') ");
				}
			}
			
			String sql = sb.toString();
			return sql;
		
	}
}

