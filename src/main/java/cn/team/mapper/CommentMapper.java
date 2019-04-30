package cn.team.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import cn.team.entity.Comment;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface CommentMapper extends Mapper<Comment>,MySqlMapper<Comment> {
	
//	@Select("select comm_id,user_id,project_id,comm_intro,comm_time,perfection,status,look_num,project_type from comment limit #{startIndex},#{size}")
//	List<Comment> selectAllByPage(@Param("startIndex")int startIndex,@Param("size")int size);
//	
	/**
	 * 带条件分页查询
	 * @param startIndex
	 * @param size
	 * @param comment
	 * @return
	 */
	@SelectProvider(type = CommentSqlProvider.class,method="selectAllByPage")
	List<Comment> selectAllByPage(@Param("startIndex")int startIndex,@Param("size")int size,@Param("comment")Comment comment);
	
	@SelectProvider(type = CommentSqlProvider.class,method="selectCount")
	int selectCountAll(@Param("comment")Comment comment);
	
	
	@Select("select comm_id,user_id,project_id,comm_intro,comm_time,perfection,status,look_num,project_type from comment where comm_id=#{comment.commId}")
	@Results(value=@Result(property="usersOne",column="user_id",one=@One(fetchType=FetchType.EAGER,select="cn.team.mapper.UsersOneMapper.selectByPrimaryKey")))
	Comment selectAllAndUserNameByid(@Param("comment")Comment comment);
	
	
	
	
	@Select("select comm_id,user_id,project_id,comm_intro,comm_time,perfection,status,look_num,project_type from comment where user_id=#{comment.userId}")
	List<Comment> selectByUserid(@Param("comment")Comment comment);
	
	@SelectProvider(type= CommentSqlProvider.class,method="selectAllAndUserName")
	List<Map<String, Object>> selectAllAndUname(@Param("startIndex")Integer startIndex,@Param("size")Integer size,@Param("map")Map<String,Object> map);
	
	@SelectProvider(type= CommentSqlProvider.class,method="selectCountWithUserName")
	Integer selectCountWithUserName(Map<String,Object> map1);

}
