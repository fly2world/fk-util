package com.tmsps.fk.common.util;

import org.springframework.util.DigestUtils;

/**
 * MD加密工具
 * 
 * @author 冯晓东 398479251@qq.com
 *
 */
public class Md5Util {
	private static final String MD5_SALT = "TB_KEY_CORE";

	public static String md5(final String str, final String salt) {
		return DigestUtils.md5DigestAsHex(str.concat(salt).getBytes());
	}

	public static String md5(final String str) {
		return md5(str, MD5_SALT);
	}

}
