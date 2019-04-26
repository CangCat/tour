package cn.team.service.comment;

import java.util.List;

import cn.team.entity.Comment;
import cn.team.utils.PageBean;

public interface CommentService {

	List<Comment> selectAll();


	int selectCount(Comment comment);
	
	PageBean<Comment> selectAllByPage(int page,int size,Comment comment);


	Integer toDel(Comment comment);


	Integer updateByPrimaryKeySelective(Comment comment);


	PageBean<Comment> selectAllByPage1(int page, int size, Comment comment);
	
	
}
