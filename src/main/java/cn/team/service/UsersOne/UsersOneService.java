package cn.team.service.UsersOne;

import java.util.List;

import cn.team.entity.Admin;
import cn.team.entity.UsersOne;
import cn.team.utils.PageBean;

public interface UsersOneService {

	//查询全部
	List<UsersOne> UsersOneSelectAll();
	
	//查一个
	UsersOne UsersOneSelectOne(int id);
	
	//分页
	PageBean<UsersOne> UserselectAllByPage(int page, int size, UsersOne user,int desc);
	
	//登录
	UsersOne selectlogin(UsersOne user);
	
	
	//添加
	int UsersOneAdd(UsersOne user);
		
		
	//查询单个
	UsersOne UsersOneselectOne(String id);
	
	//修改
	int UsersOneupdate(UsersOne user);
	
	//删除
	int UsersOnedelete(int id);
	
	
	
}
