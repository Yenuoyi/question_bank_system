package com.org.bank.common.encrypt;

import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 秘钥生成器
 * 
 */
public class KeygenGenerator {

	/**
	 * 将固定字符串转换为ASC加密的秘钥
	 * 
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 */
	public static SecretKeySpec getASCKey(String password) throws NoSuchAlgorithmException, NoSuchPaddingException {
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		random.setSeed(password.getBytes());
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, random);
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		return key;
	}

}
