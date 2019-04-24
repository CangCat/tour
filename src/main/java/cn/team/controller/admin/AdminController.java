package cn.team.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.team.entity.Admin;
import cn.team.entity.CreateImageCode;
import cn.team.service.admin.AdminService;
import cn.team.utils.Md5Utils;

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
		
		if(adminPassword!=null){
//			System.out.println("进入密码加密功能");
//			System.out.println("adminPassword是什么："+adminPassword);
			adminPassword = Md5Utils.getMd5(adminPassword);
//			System.out.println("编译后 ："+adminPassword);
		}
		
		
		
		if(admin!=null){
			String loginName = admin.getLoginName();
			String password = admin.getPassword();
		if(adminverity.equals(vcode)){
			
			
			if(admin.getLoginName()!=null){
				
				if(adminName.equals(loginName)&&adminPassword.equals(password)){
					System.out.println("登录成功");
					//默认转发
					return "admin/index/admin-list";
				}
				else {
					System.out.println("登录失败");
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
	
}
