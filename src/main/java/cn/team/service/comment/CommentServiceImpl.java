package cn.team.service.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.team.entity.Comment;
import cn.team.mapper.CommentMapper;
import cn.team.utils.PageBean;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentMapper mapper;

	@Override
	public List<Comment> selectAll() {
		
		List<Comment> selectAll = mapper.selectAll();
		
		return selectAll;
	}
	
	@Override
	public int selectCount(Comment comment){
		
		return mapper.selectCount(comment);
		
	}

	@Override
	public PageBean<Comment> selectAllByPage(int page, int size,Comment comment) {
		int count = mapper.selectCount(comment);
		PageBean<Comment> bean = new PageBean<Comment>(size,page,count);
		List<Comment> list = mapper.selectAllByPage(bean.getStartIndex(), size);
		
		bean.setList(list);
		
		return bean;
	}
	
	@Override
	public Integer toDel(Comment comment){
		int delete = mapper.delete(comment);
		return delete;
	}
	
	@Override
	public Integer updateByPrimaryKeySelective(Comment comment){
		int updateByPrimaryKey = mapper.updateByPrimaryKeySelective(comment); 
		return updateByPrimaryKey;
	}
	
	
	
	
}
