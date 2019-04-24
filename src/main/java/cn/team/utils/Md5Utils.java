package cn.team.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Md5摘要算法工具  
 * 
 * @author JLB
 *
 */
public class Md5Utils {

	
	/**
	 * 将传入字符串通过摘要算法计算，返回一个不可逆的数据字符串
	 * @param code		需要加密的字符串
	 * @return			md5运算后的字符串
	 */
	public static String getMd5(String code){
		try {
			//MessageDigest: java提供的工具类，用于创建一个加密对象     getInstance("MD5")  根据传入的MD5字符串，来创建一个MD5的加密对象
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			//digest(byte[])  传入需要进行md5摘要算法的字符串的字节数组
			byte[] digest = md5.digest(code.getBytes());
			//Base64 		JDK1.8以后提供的工具类    可以实现传入数据，编码和解码
			//getEncoder().encodeToString(src)	  将二进制转换成字符串
			return Base64.getEncoder().encodeToString(digest);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Md5Utils.getMd5("1234"));
	}
}
