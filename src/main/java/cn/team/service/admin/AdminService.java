package cn.team.service.admin;


import cn.team.entity.Admin;
import cn.team.utils.PageBean;

public interface AdminService {

	//登录
	Admin selectlogin(Admin admin);
	
	//分页
	PageBean<Admin> adminselectAllByPage(int page, int size, Admin admin,int desc);
		
	
	//添加
	int adminAdd(Admin admin);
	
	
	//查询单个
	Admin adminselectOne(String id);
	
	//修改
	int adminupdate(Admin admin);
	
	//删除
	int admindelete(int id);
	
}
