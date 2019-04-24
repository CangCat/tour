package cn.team.controller.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.team.entity.Comment;
import cn.team.service.comment.CommentService;
import cn.team.utils.PageBean;

/**
 * @author CangCat
 * @date 2019/4/23 11:59
 */


@Controller
@RequestMapping("comment")
public class CommentController {
	
	@Autowired
	CommentService service;
	
	@RequestMapping("doList")
	@ResponseBody
	public Map doList(Comment comment,Integer page,Integer limit){
		Map map = new HashMap();
		  PageBean<Comment> bean = service.selectAllByPage(page, limit, comment);
		int i = service.selectCount(comment);
		map.put("count", i);
		map.put("code", 0);
		map.put("data", bean.getList());
		
		return map;
	}
	
	@RequestMapping("toList")
	public String toList(){
		
		return "admin/index/comment-list";
	}
}
