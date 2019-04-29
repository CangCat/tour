package cn.team.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.team.entity.Admin;
import cn.team.entity.CreateImageCode;
import cn.team.service.admin.AdminService;
import cn.team.utils.Md5Utils;
import cn.team.utils.PageBean;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	//注入服务
	AdminService ads;
	
	//进入后台登录界面
	@RequestMapping("toLogin")
	public String toLogin(ModelMap map){
//		System.out.println("进入后台登录界面");

		
		return "admin/index/login";
	}
	
	
	
	
	
	/*验证码生成*/
	@RequestMapping("code.jpg")
 	public void getCode3(HttpServletRequest req, HttpServletResponse response, HttpSession session) throws IOException {
        // 设置响应的类型格式为图片格式
            response.setContentType("image/jpeg");
            //禁止图像缓存。
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            CreateImageCode vCode = new CreateImageCode(100,30,5,10);
            //vcode验证码的值
            session.setAttribute("vcode", vCode.getCode());
            vCode.write(response.getOutputStream());

            Object vcode = session.getAttribute("vcode");
           
            System.out.println("验证码："+vcode);

     }
	
	
	
	//开始登录功能
	@RequestMapping("doLogin")
	public String doLogin(ModelMap map,String adminName,String adminPassword,String adminverity,HttpSession session){
//		System.out.println("提交数据");
//		System.out.println("登录名:"+adminName);
//		System.out.println("密码:"+adminPassword);
//		System.out.println("前段传过来的验证码:"+adminverity);
		
		Object vcode = session.getAttribute("vcode");
//		System.out.println("验证码："+object);
		Admin admins = new Admin();
		admins.setLoginName(adminName);
		Admin admin = ads.selectlogin(admins);
//		System.out.println("登录查询的："+admin);
		//密码加密
		if(adminPassword!=null){
//			System.out.println("进入密码加密功能");
//			System.out.println("adminPassword是什么："+adminPassword);
			adminPassword = Md5Utils.getMd5(adminPassword);
//			System.out.println("编译后 ："+adminPassword);
		}
		
//		System.out.println("开始进入");
		
		//admin账号存在
		if(admin!=null){
			
			String loginName = admin.getLoginName();
			String password = admin.getPassword();
			//验证码校验
		if(adminverity.equals(vcode)){
			if(admin.getLoginName()!=null){
				if(adminName.equals(loginName)&&adminPassword.equals(password)){
//					System.out.println("登录成功");
					
					//默认转发
//					return "admin/index/admin-list";
					
					map.put("adminOne", admin );
					
					return "admin/index/index";
					
				}
				else {
//					System.out.println("登录失败");
					//登录失败重定向返回
					//这个要按模块来重定向
					map.put("prompt", "用户名或密码错误" );
					//后期可添加改变输入宽的文字
//					return "redirect:/admin/toLogin";
					return "admin/index/login";
				}
			}
			
		}else{
			map.put("prompt", "验证码错误" );
			//后期可添加改变输入宽的文字
//			return "redirect:/admin/toLogin";
			return "admin/index/login";
			
		}
		}
		else {
			map.put("prompt", "请注册账号" );
			return "admin/index/login";
		}
		return "admin/index/login";
	}
	
	
	//进入toadmint_list
	@RequestMapping("toadmint_list")
	public String toadmint_list(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="5")int size,Admin admin,ModelMap modelMap,@RequestParam(defaultValue="0")int desc){
	
//		System.out.println("传进来的desc："+desc);
		String status = admin.getAdminStatus();
//		admin.setAdminStatus(states);
		
//		System.out.println("传输过来的status："+status);
		
		//当前页数  每页显示几行  条件
		PageBean<Admin> pageBean = ads.adminselectAllByPage(page, size, admin,desc);
		
		modelMap.put("pageBean", pageBean);
		//这里要给他返回回去
		modelMap.put("admin", admin);
//		System.out.println("传输回去的status："+status);
		//返回一个排序给他
		//搜索
		modelMap.put("desc", desc);
//		System.out.println("排序装态"+desc);
		
		return "admin/index/admin-list";
	}
	
	
	@RequestMapping("toadmint_add")
	public String toadmint_add(ModelMap modelMap){
		
		return "admin/index/admin-add";
	
	}
	
	//添加
	@RequestMapping("doadmint_add")
	public String doadmint_add(ModelMap modelMap,MultipartFile file,Admin admin){
		

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
			admin.setPic(file.getOriginalFilename());
			
		}else{
			
			admin.setPic("555.png");
			
		}
		
		
		
		admin.setRegisterTime(new Date());
		admin.setAdminStatus("0");
		
		String password = admin.getPassword();
		if(password!=null){
//			System.out.println("进入密码加密功能");
//			System.out.println("adminPassword是什么："+adminPassword);
			password = Md5Utils.getMd5(password);
//			System.out.println("编译后 ："+password);
		}
		
		int i = ads.adminAdd(admin);
		
		
		return "admin/index/admin-add";
	
	}
	
	//进入修改
	@RequestMapping("toadmint_info")
	public String toadmint_info(ModelMap modelMap,String adminId){
	
		Admin one = ads.adminselectOne(adminId);
		
		
//		System.out.println("前端传过来查到的"+one);
		
		modelMap.put("admin", one);
		
		return "admin/index/admin-info";
		
	}
	
	
	//修改
	@RequestMapping("doadmint_info")
	public String doadmint_info(ModelMap modelMap,MultipartFile file,Admin admin){
	
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
			admin.setPic(file.getOriginalFilename());
			
			
			
			
		}else{
			
//			System.out.println("没有图片的");
			
			Integer id = admin.getAdminId();
			
			Admin one = ads.adminselectOne(id.toString());
			
//			System.out.println("数据库里面的图片名字："+one.getPic());
			
			admin.setPic(one.getPic());
			
			
		}
		admin.setUpdateTime(new Date());
//		System.out.println("要修改的："+admin);
		
		//管理员类型
		String adminType = admin.getAdminType();
		
		//需要剪切的
		String[] split = adminType.split(",");
		
//		System.out.println("adminType:"+split[1]);
		
		admin.setAdminType(split[1]);
		
//		System.out.println("修改最终提交的："+admin);
		
		int i = ads.adminupdate(admin);
		return "redirect:/admin/toadmint_list";
		
	}
	
	//修改密码
	@RequestMapping("doadmint_info_password")
	public String doadmint_info_password(ModelMap modelMap,Admin admin){
		
		String password = admin.getPassword();
		
		if(password!=null){
//			System.out.println("进入密码加密功能");
//			System.out.println("adminPassword是什么："+password);
			password = Md5Utils.getMd5(password);
//			System.out.println("编译后 ："+password);
		}
		
		admin.setPassword(password);
		admin.setUpdateTime(new Date());
//		System.out.println("收到的是："+admin);
		
		int i = ads.adminupdate(admin);
		
		return "redirect:/admin/toLogin";
		
	}
	
	//验证密码
	
	@RequestMapping("toadmint_info_passw")
	@ResponseBody
	public String toadmint_info_passw(ModelMap modelMap,String pwd1,String loginName){
		
//		System.out.println("前端传过来的密码:"+pwd1);
		
//		System.out.println("前端传过来的登录名:"+loginName);
		
		Admin admin = new Admin();
		
		admin.setLoginName(loginName);
		
		//
		admin = ads.selectlogin(admin);
		
		if(admin!=null){
//			System.out.println("查找到的："+admin);
			if(pwd1!=null){
//				System.out.println("进入密码加密功能");
//				System.out.println("adminPassword是什么："+adminPassword);
				pwd1 = Md5Utils.getMd5(pwd1);
//				System.out.println("编译后 ："+pwd1);
			}
			if(pwd1.equals(admin.getPassword())){
//				System.out.println("验证成功");
				return "0";
			}else{
//				System.out.println("验证失败");
				return "1";
			}
		}
		//死码是一定不会运行的
		return "hellow";
		
		
	}
	
	//删除
	@RequestMapping("toadmint_delete")
	public String toadmint_delete(ModelMap modelMap,int adId){
		
//		System.out.println("删除输出的是："+adId);
		
		ads.admindelete(adId);
		
		
		return "redirect:/admin/toadmint_list";
	}

	//删除集合
	@RequestMapping("toadmint_delete_list")
	@ResponseBody
	public String toadmint_delete_list(ModelMap modelMap,@RequestParam("o_id[]") ArrayList<Integer>  o_id){
		
//		System.out.println("进入批量删除");
		
//		System.out.println(o_id);
		
		int dei=0;
		String dele = "";
		
		for(int a:o_id){
			
			 dei = ads.admindelete(a);
			
			System.out.println("删除的数组："+a);
			
			
		}
		
//		System.out.println("删除是啥"+dei);
		
		if(dei==1){
			
			dele="1";
		}else{
			
			dele="2";
		}
		
		return dele;
	}
	
	
	
}
