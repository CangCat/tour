package cn.team.service.UsersOne.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.team.entity.UsersOne;
import cn.team.mapper.UsersOneMapper;
import cn.team.service.UsersOne.UsersOneService;

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

	
	
	
	
}
