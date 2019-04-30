package cn.team.service.comment;

import java.util.List;
import java.util.Map;

import cn.team.entity.Comment;
import cn.team.utils.PageBean;

public interface CommentService {

	List<Comment> selectAll();


	int selectCountAll(Comment comment);
	
	PageBean<Comment> selectAllByPage(int page,int size,Comment comment);


	Integer toDel(Comment comment);


	Integer updateByPrimaryKeySelective(Comment comment);


	PageBean<Comment> selectAllByPage1(int page, int size, Comment comment);


	PageBean<Map<String, Object>> selectAllAndUname(Integer startIndex, Integer size, Map<String, Object> map);


	int selectCountWithUserName(Map<String, Object> map);


	PageBean<Map<String, Object>> selectAllAndUname(Comment comment, Integer page, Integer size,
			Map<String, Object> map);
	
	
}
