package cn.team.utils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author CangCat
 * @date 2019/4/26 10:06
 */
public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        filePath = "D:/tourImg/scenic/";
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
