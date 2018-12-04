package com.org.bank.common.encrypt;

import com.org.bank.common.ExecuteResult;
import org.apache.log4j.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class EncrypUtil {
	private static final Logger LOGGER = Logger.getLogger(EncrypUtil.class);

	/**
	 * 通过AES加密
	 * 
	 * @param key         秘钥
	 * @param content     需要加密的字符串
	 * @return
	 */
	public static ExecuteResult<String> EncrypStrByAES(String key, String content) {
		List<String> message = new ArrayList<String>();
		ExecuteResult<String> er = new ExecuteResult<String>();
		try {
			byte[] byteContent = content.getBytes("utf-8");
			// 执行加密
			byte[] results = EncrypAES.encry(byteContent, key);
			// 转换为字符串
			content = parseByte2HexStr(results);
			er.setResult(content);
		} catch (UnsupportedEncodingException e) {
			message.add("加密失败，失败原因:" + e.getMessage());
			LOGGER.error("", e);
			er.setErrorMessages(message);
		} catch (InvalidKeyException e) {
			message.add("加密失败，失败原因:" + e.getMessage());
			LOGGER.error("", e);
			er.setErrorMessages(message);
		} catch (NoSuchAlgorithmException e) {
			message.add("加密失败，失败原因:" + e.getMessage());
			LOGGER.error("", e);
			er.setErrorMessages(message);
		} catch (NoSuchPaddingException e) {
			message.add("加密失败，失败原因:" + e.getMessage());
			LOGGER.error("", e);
			er.setErrorMessages(message);
		} catch (IllegalBlockSizeException e) {
			message.add("加密失败，失败原因:" + e.getMessage());
			LOGGER.error("", e);
			er.setErrorMessages(message);
		} catch (BadPaddingException e) {
			message.add("加密失败，失败原因:" + e.getMessage());
			LOGGER.error("", e);
			er.setErrorMessages(message);
		} catch (Exception e) {
			message.add("加密失败，失败原因:" + e.getMessage());
			LOGGER.error("", e);
			er.setErrorMessages(message);
		}
		return er;
	}

	/**
	 * 通过AES解密
	 * 
	 * @param key      秘钥
	 * @param content      需要解密的字符串
	 * @return
	 */
	public static ExecuteResult<String> DecryptStrByAES(String key, String content) {
		List<String> message = new ArrayList<String>();
		ExecuteResult<String> er = new ExecuteResult<String>();
		try {
			// 解密
			byte[] byteContent = parseHexStr2Byte(content);
			byte[] decryptResult = EncrypAES.decrypt(byteContent, key);
			content = new String(decryptResult);
			er.setResult(content);
		} catch (InvalidKeyException e) {
			message.add("加密失败，失败原因:" + e.getMessage());
			LOGGER.error("", e);
			er.setErrorMessages(message);
		} catch (UnsupportedEncodingException e) {
			message.add("加密失败，失败原因:" + e.getMessage());
			LOGGER.error("", e);
			er.setErrorMessages(message);
		} catch (NoSuchAlgorithmException e) {
			message.add("加密失败，失败原因:" + e.getMessage());
			LOGGER.error("", e);
			er.setErrorMessages(message);
		} catch (NoSuchPaddingException e) {
			message.add("加密失败，失败原因:" + e.getMessage());
			LOGGER.error("", e);
			er.setErrorMessages(message);
		} catch (IllegalBlockSizeException e) {
			message.add("加密失败，失败原因:" + e.getMessage());
			LOGGER.error("", e);
			er.setErrorMessages(message);
		} catch (BadPaddingException e) {
			message.add("加密失败，失败原因:" + e.getMessage());
			LOGGER.error("", e);
			er.setErrorMessages(message);
		}
		return er;
	}

	/**
	 * 将二进制转换成16进制
	 * 
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 * 
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	public static void main(String[] args) {
		String key = "www";
		ExecuteResult<String> con = EncrypUtil.EncrypStrByAES(key, "123456");
		System.out.println("加密后:" + con.getResult());
		System.out.println("解密后:" + EncrypUtil.DecryptStrByAES(key, con.getResult()).getResult());
	}

}
