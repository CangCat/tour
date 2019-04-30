package cn.team.service.comment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
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
	public int selectCountAll(Comment comment){
		
		return mapper.selectCountAll(comment);
		
	}

	@Override
	public PageBean<Comment> selectAllByPage(int page, int size,Comment comment) {
		int count = mapper.selectCountAll(comment);
		PageBean<Comment> bean = new PageBean<Comment>(size,page,count);
		List<Comment> list = mapper.selectAllByPage(bean.getStartIndex(), size, comment);
		
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
	
	@Override
	public PageBean<Comment> selectAllByPage1(int page, int size,Comment comment) {
		int count = mapper.selectCount(comment);
		PageBean<Comment> bean = new PageBean<Comment>(size,page,count);
		List<Comment> list = mapper.selectAllByPage(bean.getStartIndex(), size, comment);
		
		bean.setList(list);
		
		return bean;
	}
	
	@Override
	public PageBean<Map<String,Object>> selectAllAndUname(Comment comment,@Param("startIndex")Integer page,@Param("size")Integer size,Map<String,Object> map){
		Integer count = mapper.selectCount(comment);    
		PageBean<Map<String,Object>> pageBean = new PageBean<Map<String,Object>>(size,page,count);
		List<Map<String, Object>> list = mapper.selectAllAndUname(pageBean.getStartIndex(), size, map);
		
		pageBean.setList(list);
		return pageBean;
	}
	
	@Override
	public int selectCountWithUserName(Map<String,Object> map){
		Integer count = mapper.selectCountWithUserName(map);
		return count;
	}

	@Override
	public PageBean<Map<String, Object>> selectAllAndUname(Integer startIndex, Integer size, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
