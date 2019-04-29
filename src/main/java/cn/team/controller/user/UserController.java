package cn.team.controller.user;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.team.entity.Admin;
import cn.team.entity.UsersOne;
import cn.team.service.UsersOne.UsersOneService;
import cn.team.utils.Md5Utils;
import cn.team.utils.PageBean;

@Controller
@RequestMapping("user")
public class UserController {

	
	@Autowired
	UsersOneService uos;
	
	
	@RequestMapping("toUserList")
	public String toUserList(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="5")int size,UsersOne user,ModelMap modelMap,@RequestParam(defaultValue="0")int desc){
		
		
		System.out.println("传进来的desc："+desc);
		String status = user.getUserStatus();
//		admin.setAdminStatus(states);
		
//		System.out.println("传输过来的status："+status);
		
		//当前页数  每页显示几行  条件
		PageBean<UsersOne> pageBean = uos.UserselectAllByPage(page, size, user,desc);
		
		modelMap.put("pageBean", pageBean);
		//这里要给他返回回去
		modelMap.put("user", user);
//		System.out.println("传输回去的status："+status);
		//返回一个排序给他
		//搜索
		modelMap.put("desc", desc);
//		System.out.println("排序装态"+desc);
		
		
		return "admin/index/user-list";
		
	}
	
	//进入添加
	@RequestMapping("toUserAdd")
	public String toUserAdd(ModelMap modelMap){
		
		return "admin/index/user-add";
	}
	
	//添加
	@RequestMapping("doUserAdd")
	public String doUserAdd(ModelMap modelMap,MultipartFile file,UsersOne user){

		if(!file.isEmpty()){
			
//				System.out.println("有图片的");
			
			File target = new File("D:\\img\\admin\\"+file.getOriginalFilename());
			
//				System.out.println("图片的名字："+file.getOriginalFilename());
			
			try {
				file.transferTo(target);//文件上传
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setPic(file.getOriginalFilename());
			
		}else{
			user.setPic("555.png");
		}
		
		user.setRegisterTime(new Date());
		//密码
		String password = user.getPassword();
		if(password!=null){
//				System.out.println("进入密码加密功能");
//				System.out.println("adminPassword是什么："+adminPassword);
			password = Md5Utils.getMd5(password);

		}
		
		user.setUserStatus("0");
		
		int i = uos.UsersOneAdd(user);
		return "redirect:/user/toUserList";
	
	}
	
	
	
	//进入删除
	@RequestMapping("toUserDelete")
	public String toUserDelete(ModelMap modelMap,int adId){
		
//		System.out.println("删除输出的是："+adId);
		
		UsersOne one = uos.UsersOneSelectOne(adId);
		
		one.setUpdateTime(new Date());
		one.setUserStatus("1");
		
		uos.UsersOneupdate(one);
		
		return "redirect:/user/toUserList";
	}

	//批量删除
	@RequestMapping("toUserdeleteList")
	@ResponseBody
	public String toUserdeleteList(ModelMap modelMap,@RequestParam("o_id[]") ArrayList<Integer>  o_id){
	
		
		
		int dei=0;
		String dele = "";
		
		for(int a:o_id){
			
			UsersOne one = uos.UsersOneSelectOne(a);
			
			one.setUpdateTime(new Date());
			one.setUserStatus("1");
			
			dei=uos.UsersOneupdate(one);
			
//			System.out.println("删除的数组："+a);
		}
		
//		System.out.println("删除是啥"+dei);
		
		if(dei==1){
			
			dele="1";
		}else{
			
			dele="2";
		}
		
		return dele;
	
	}
	
	//进入修改
	//toUserInfo
	@RequestMapping("toUserInfo")
	public String toadmint_info(ModelMap modelMap,String userId){
	
//		Admin one = ads.adminselectOne(adminId);
		
		UsersOne one = uos.UsersOneselectOne(userId);
		
//		System.out.println("前端传过来查到的"+one);
		
		modelMap.put("user", one);
		
		return "admin/index/user-info";
		
	}
	
	//doUserInfo
	
	@RequestMapping("doUserInfo")
	public String doUserInfo(ModelMap modelMap,MultipartFile file,UsersOne user){
	
		if(!file.isEmpty()){
			
//			System.out.println("有图片的");
			
			File target = new File("D:\\img\\admin\\"+file.getOriginalFilename());
			
//			System.out.println("图片的名字："+file.getOriginalFilename());
			
			try {
				file.transferTo(target);//文件上传
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setPic(file.getOriginalFilename());
			
			
			
			
		}else{
			
//			System.out.println("没有图片的");
			
			Integer id = user.getUserId();
			
//			Admin one = uos.adminselectOne(id.toString());
			
			UsersOne one = uos.UsersOneselectOne(id.toString());
			
//			System.out.println("数据库里面的图片名字："+one.getPic());
			
			user.setPic(one.getPic());
			
			
		}
		user.setUpdateTime(new Date());
//		System.out.println("要修改的："+admin);
		
		//需要剪切的
		
		
//		System.out.println("修改最终提交的："+admin);
		
		
		int i = uos.UsersOneupdate(user);
		
		return "redirect:/user/toUserList";
		
	}
	
	
	//修改密码
		@RequestMapping("doadmint_info_password")
		public String doadmint_info_password(ModelMap modelMap,UsersOne user){
			
			String password = user.getPassword();
			
			if(password!=null){
//				System.out.println("进入密码加密功能");
//				System.out.println("adminPassword是什么："+password);
				password = Md5Utils.getMd5(password);
//				System.out.println("编译后 ："+password);
			}
			
			user.setPassword(password);
			user.setUpdateTime(new Date());
//			System.out.println("收到的是："+admin);
			
			int i = uos.UsersOneupdate(user);
			
			return "redirect:/admin/toLogin";
			
		}
		
		//验证密码
		
		@RequestMapping("toadmint_info_passw")
		@ResponseBody
		public String toadmint_info_passw(ModelMap modelMap,String pwd1,int userId){
			
//			System.out.println("前端传过来的密码:"+pwd1);
			
//			System.out.println("前端传过来的登录名:"+loginName);
			
			
			
			
			UsersOne one = uos.UsersOneSelectOne(userId);
			
	
			
			if(one!=null){
//				System.out.println("查找到的："+admin);
				if(pwd1!=null){
//					System.out.println("进入密码加密功能");
//					System.out.println("adminPassword是什么："+adminPassword);
					pwd1 = Md5Utils.getMd5(pwd1);
//					System.out.println("编译后 ："+pwd1);
				}
				if(pwd1.equals(one.getPassword())){
//					System.out.println("验证成功");
					return "0";
				}else{
//					System.out.println("验证失败");
					return "1";
				}
			}
			//死码是一定不会运行的
			return "hellow";
			
			
		}
	
		//登录
		//1登录成功0邮箱或密码错误，请确认,2账号已被封冷冻联系客服3请注册
		@RequestMapping("userlogin")
		@ResponseBody
		public String touserlogin(ModelMap modelMap,String Name,String Password){
			System.out.println("邮箱："+Name);
			
			UsersOne usersOne = new UsersOne();
			
			usersOne.setEmail(Name);
			
			UsersOne one = uos.selectlogin(usersOne);
			
			System.out.println("邮箱："+one);
			
			if(!one.equals(null)){
				System.out.println("查找到");
				//判断前台登录页面传过来的值
				if(Password!=null){
					System.out.println("前台登录密码："+Password);
					Password=Md5Utils.getMd5(Password);
					System.out.println("加密后的密码："+Password);
			}
			//判断登录
			if(Name.equals(one.getEmail())&&Password.equals(one.getPassword())){
				
				System.out.println("登录进来，查看是否有冻结账号");
				
				if(one.getUserStatus().equals("1")){
					System.out.println("冻结账号");
					//2账号已被封冷冻联系客服
					return "2";
					
				}else{
					System.out.println("登录成功");
					//1登录成功
					return "1";
				}
				
			}else{
				System.out.println("密码错误");
				//0邮箱或密码错误
				return "0";
				
			}
			}else{
				System.out.println("请注册");
				
				//3请注册
				return "3";
			}
		}
		
		//跳转到
		@RequestMapping("userloginindex")
		public String userloginindex(ModelMap modelMap){
		
			return "admin/index/index";
		}
		
	
}
