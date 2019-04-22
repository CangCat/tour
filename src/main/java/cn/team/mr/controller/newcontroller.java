package cn.team.mr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class newcontroller {
	
	@RequestMapping("hi")
	public String hal(){
		return "halou 11";
	}
	
}
