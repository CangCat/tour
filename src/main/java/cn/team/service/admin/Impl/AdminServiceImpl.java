package cn.team.service.admin.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.team.entity.Admin;
import cn.team.mapper.AdminMapper;
import cn.team.service.admin.AdminService;
import cn.team.utils.PageBean;

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

	//分页
	@Override
	public PageBean<Admin> adminselectAllByPage(int page, int size, Admin admin, int desc) {
				// TODO Auto-generated method stub
				int count = ad.AdminselectCountAll(admin,desc);
				
				PageBean<Admin> pageBean = new PageBean<Admin>(size, page, count);
				
				List<Admin> list = ad.adminSelectAllByPage(pageBean.getStartIndex(), size, admin,desc);
				
//				System.out.println(list);
				
				pageBean.setList(list);
				
				return pageBean;
	}

	

	@Override
	public int adminAdd(Admin admin) {
		// TODO Auto-generated method stub
		return ad.insert(admin);
	}

	@Override
	public Admin adminselectOne(String id) {
		// TODO Auto-generated method stub

		return ad.selectByPrimaryKey(id);
	}

	//修改
	@Override
	public int adminupdate(Admin admin) {
		// TODO Auto-generated method stub
		return ad.updateByPrimaryKey(admin);
	}

	@Override
	public int admindelete(int id) {
		// TODO Auto-generated method stub
		return ad.deleteByPrimaryKey(id);
	}

}
