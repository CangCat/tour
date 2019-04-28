package cn.team.service.UsersOne.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.team.entity.Admin;
import cn.team.entity.UsersOne;
import cn.team.mapper.UsersOneMapper;
import cn.team.service.UsersOne.UsersOneService;
import cn.team.utils.PageBean;

@Service
@Transactional
public class UsersOneServiceImpl implements UsersOneService {

	@Autowired
	UsersOneMapper uo;
	
	@Override
	public List<UsersOne> UsersOneSelectAll() {
		// TODO Auto-generated method stub
		return uo.selectAll();
	}

	@Override
	public UsersOne UsersOneSelectOne(int id) {
		// TODO Auto-generated method stub
		return uo.selectByPrimaryKey(id);
	}

	//分页
	@Override
	public PageBean<UsersOne> UserselectAllByPage(int page, int size, UsersOne user, int desc) {
		// TODO Auto-generated method stub
		
		int count = uo.UserselectCountAll(user,desc);
		
		PageBean<UsersOne> pageBean = new PageBean<UsersOne>(size, page, count);
		
		List<UsersOne> list = uo.UserselectAllByPage(pageBean.getStartIndex(), size, user,desc);
		
//		System.out.println(list);
		
		pageBean.setList(list);
		
		return pageBean;
	}

	//登录
	@Override
	public UsersOne selectlogin(UsersOne user) {
		// TODO Auto-generated method stub
		return uo.selectOne(user);
	}

	//添加
	@Override
	public int UsersOneAdd(UsersOne user) {
		// TODO Auto-generated method stub
		return uo.insert(user);
	}

	//查询单个
	@Override
	public UsersOne UsersOneselectOne(String id) {
		// TODO Auto-generated method stub
		return uo.selectByPrimaryKey(id);
	}

	//修改一个
	@Override
	public int UsersOneupdate(UsersOne user) {
		// TODO Auto-generated method stub
		return uo.updateByPrimaryKey(user);
	}

	//删除
	@Override
	public int UsersOnedelete(int id) {
		// TODO Auto-generated method stub
		return uo.deleteByPrimaryKey(id);
	}

	
	
	
	
}
