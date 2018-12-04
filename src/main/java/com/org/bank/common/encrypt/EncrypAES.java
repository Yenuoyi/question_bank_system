package com.org.bank.common.encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * AES可对称性加密
 */
public class EncrypAES {
	
	/**
	 * 加密
	 * @param byteContent 要加密的内容
	 * @param password 加密内容使用的秘钥
	 */
	public static byte[] encry(byte[] byteContent,String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		//获取秘钥
		SecretKeySpec key = KeygenGenerator.getASCKey(password);
		Cipher cipher = Cipher.getInstance("AES");// 创建密码器   
        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化   
        byte[] result = cipher.doFinal(byteContent); 
        return result;
	}
	
	/**
	 * 解密
	 * @param byteContent
	 * @param password
	 */
	public static byte[] decrypt(byte[] byteContent,String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		//获取秘钥
		SecretKeySpec key = KeygenGenerator.getASCKey(password);
		Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.DECRYPT_MODE, key);// 初始化   
        byte[] result = cipher.doFinal(byteContent);  
        return result; //解密
	}
    
}
