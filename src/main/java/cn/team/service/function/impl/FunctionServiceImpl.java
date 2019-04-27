package cn.team.service.function.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.team.entity.Functional;
import cn.team.mapper.function.FunctionMapper;
import cn.team.service.function.FunctionService;
import cn.team.utils.PageBean;

@Service
public class FunctionServiceImpl implements FunctionService {

	@Autowired
	FunctionMapper mapper;
	@Override
	public List<Functional> functions() {
		return mapper.selectAll();
	}
	@Override
	public List<Map<String,Object>> selectFunctions(Integer page, Integer size) {
		int total = mapper.selectCount(null);
		PageBean<Map<String,Object>> bean = new PageBean<Map<String,Object>>(size,page,total);
		return mapper.selectFunctions(bean.getStartIndex(), size);
	}
	
	@Override
	public int selectCount(){
		return mapper.selectCount(null);
	}

}
