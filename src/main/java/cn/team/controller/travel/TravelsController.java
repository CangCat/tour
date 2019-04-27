package cn.team.controller.travel;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.team.entity.Travels;
import cn.team.service.travel.TravelService;
import cn.team.utils.PageBean;
import net.minidev.json.JSONObject;

@Controller
@RequestMapping("travel")
public class TravelsController {
	
	@Autowired
	TravelService service;

	/**
	 * 游记列表页
	 * @param map
	 * @return
	 */
	@RequestMapping("toList")
	public String to_list(ModelMap map,@RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="15")Integer size, String status, String sName, String uName){
		if(pageNum<1){
			pageNum=1;
		}
		if(size<1){
			size=15;
		}
		PageBean<Map<String, Object>> pageBean = service.selectByPage(pageNum, size, status, sName, uName);
		map.put("status", status);
		map.put("sName", sName);
		map.put("uName", uName);
		map.put("pageBean", pageBean);
		return "admin/index/travel-nose-list";
	}
	
	/**
	 * 去到游记保存页面
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd(){
		return "admin/index/travel-nose-add";
	}
	
	/**
	 * 执行新增操作
	 * @return
	 */
	@RequestMapping("doAdd")
	public String doAdd(){
		return "admin/index/travel-nose-add";
	}
	
	/**
	 * 去到游记更新页面
	 * @param id 根据id查找游记信息
	 * @param map
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Integer id, ModelMap map){
		Map<String, Object> travels = service.selectInfoByTravelId(id);
		map.put("map", travels);
		return "admin/index/travel-nose-detail";
	}
	
	
	/**
	 * 执行修改游记操作
	 * @return
	 */
	@RequestMapping("doUpdate")
	@ResponseBody
	public int doUpdate(Travels travels,ModelMap map){
		int i = service.updateTravel(travels);
		if(i>0){
			return  1;
		}
		return 0;
	}
	
	@RequestMapping("doStatus")
	@ResponseBody
	public int doStatus(Integer id){
		Travels travels = new Travels();
		travels.setStatus("0");//直接把状态改为0-表示审核通过
		travels.setTravelId(id);
		int i = service.updateTravels(travels);
		if(i>0){
			return 1;
		}
		return 0;
	}
	
	
	/**
	 * 根据游记id删除游记的操作
	 * 修改游记的状态值status:0-正常发表  1-待审核  2-删除
	 * 所以现在把状态改为'2'
	 * @return
	 */
	@RequestMapping("doDelete")
	@ResponseBody
	public int doDelete(Integer id){
		
		Travels travels = new Travels();
		travels.setStatus("2");//直接把状态改为2-表示删除
		travels.setTravelId(id);
		int i = service.updateTravels(travels);
		if(i>0){
			return 1;
		}
		return 0;
	}
	
	/**
	 * 图片上传
	 */
	public final static String UPLOAD_FILE_PATH = "D:\\ui\\";
    
    @RequestMapping(value = "uploadFile")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            Map<String, String> resObj = new HashMap<>(500000);
            try {
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(UPLOAD_FILE_PATH, file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                resObj.put("msg", "error");
                resObj.put("code", "1");
                return JSONObject.toJSONString(resObj);
            }
            resObj.put("msg", "ok");
            resObj.put("code", "0");
            return JSONObject.toJSONString(resObj);
        } else {
            return null;
        }
    }
    
    
    /** 
     * Java代码实现MySQL数据库导出 
     *  
     * @author GaoHuanjie 
     * @param hostIP MySQL数据库所在服务器地址IP 
     * @param userName 进入数据库所需要的用户名 
     * @param password 进入数据库所需要的密码 
     * @param savePath 数据库导出文件保存路径 
     * @param fileName 数据库导出文件文件名 
     * @param databaseName 要导出的数据库名 
     * @return 返回true表示导出成功，否则返回false。 
     */  
    public static boolean exportDatabaseTool(String hostIP, String userName, String password, String savePath, String fileName, String databaseName) throws InterruptedException {  
        File saveFile = new File(savePath);  
        if (!saveFile.exists()) {// 如果目录不存在  
            saveFile.mkdirs();// 创建文件夹  
        }  
        if(!savePath.endsWith(File.separator)){  
            savePath = savePath + File.separator;  
        }  
          
        PrintWriter printWriter = null;  
        BufferedReader bufferedReader = null;  
        try {  
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));  
            Process process = Runtime.getRuntime().exec(" mysqldump -h" + hostIP + " -u" + userName + " -p" + password + " --set-charset=UTF8 " + databaseName);  
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");  
            bufferedReader = new BufferedReader(inputStreamReader);  
            String line;  
            while((line = bufferedReader.readLine())!= null){  
                printWriter.println(line);  
            }  
            printWriter.flush();  
            if(process.waitFor() == 0){//0 表示线程正常终止。  
                return true;  
            }  
        }catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (bufferedReader != null) {  
                    bufferedReader.close();  
                }  
                if (printWriter != null) {  
                    printWriter.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return false;  
    } 
}
