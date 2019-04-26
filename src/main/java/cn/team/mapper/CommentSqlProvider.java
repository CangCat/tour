package cn.team.mapper;

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
}
