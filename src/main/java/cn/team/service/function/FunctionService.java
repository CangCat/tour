package cn.team.service.function;

import java.util.List;
import java.util.Map;

import cn.team.entity.Functional;


public interface FunctionService {

	List<Functional> functions ();
	
	List<Map<String,Object>> selectFunctions(Integer startIndex, Integer size);

	int selectCount();
}
