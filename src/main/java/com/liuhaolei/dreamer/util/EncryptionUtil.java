package com.liuhaolei.dreamer.util;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

public class EncryptionUtil {
	
	public static String md5(String src){
		try{//采用MD5处理
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] output = md.digest(src.getBytes());//加密处理
			//将加密结果output利用Base64转成字符串输出
			String ret =  Base64.encodeBase64String(output);
			return ret;
		}catch(Exception e){
			return "";
		}
	}
}
