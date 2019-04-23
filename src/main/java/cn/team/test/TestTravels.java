package cn.team.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.team.entity.Travels;
import cn.team.mapper.TravelsMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTravels {
	
	@Autowired
	TravelsMapper mapper;

	@Test
	public void testFindAll(){
		List<Travels> list = mapper.findAllTravels();
		for (Travels travels : list) {
			System.out.println(travels);
		}
	}
}
