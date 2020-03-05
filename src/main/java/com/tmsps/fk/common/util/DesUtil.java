package com.tmsps.fk.common.util;

import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * Des 加密算法
 * 
 * @author 冯晓东 398479251@qq.com
 *
 */
public class DesUtil {
	private final static String DES = "DES";

	/**
	 * 
	 * @Description: 根据键值进行加密
	 * @param data 加密数据
	 * @param key  加密key
	 * @return
	 */
	public static String encrypt(String data, String key) {
		try {
			byte[] bt = encrypt(data.getBytes(), key.getBytes());
			String strs = new String(Base64.getEncoder().encode(bt));
			return strs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Description: 根据键值进行解密
	 * @param data 解密字符串
	 * @param key  解密key
	 * @return
	 */
	public static String decrypt(String data, String key) {
		try {
			if (data == null) {
				return null;
			}
			byte[] buf = Base64.getDecoder().decode(data);
			byte[] bt = decrypt(buf, key.getBytes());
			return new String(bt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Description 根据键值进行加密
	 * 
	 * @param data
	 * @param key  加密键byte数组
	 * @return
	 * @throws Exception
	 */
	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}

	/**
	 * Description 根据键值进行解密
	 * 
	 * @param data
	 * @param key  加密键byte数组
	 * @return
	 * @throws Exception
	 */
	private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(DES);

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}
}
