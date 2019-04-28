package cn.team.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import cn.team.entity.Comment;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface CommentMapper extends Mapper<Comment>,MySqlMapper<Comment> {
	
//	@Select("select comm_id,user_id,project_id,comm_intro,comm_time,perfection,status,look_num,project_type from comment limit #{startIndex},#{size}")
//	List<Comment> selectAllByPage(@Param("startIndex")int startIndex,@Param("size")int size);
//	
	@SelectProvider(type = CommentSqlProvider.class,method="selectAllByPage")
	List<Comment> selectAllByPage(@Param("startIndex")int startIndex,@Param("size")int size,@Param("comment")Comment comment);
	
	@SelectProvider(type = CommentSqlProvider.class,method="selectCount")
	int selectCountAll(@Param("comment")Comment comment);
}
