package cn.team.service.admin.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.team.entity.Admin;
import cn.team.mapper.AdminMapper;
import cn.team.service.admin.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService  {

	
	@Autowired
	AdminMapper ad;
	
	@Override
	public Admin selectlogin(Admin admin) {
		// TODO Auto-generated method stub
//		return null;
		return ad.selectOne(admin);
	}

}
