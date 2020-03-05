package com.tmsps.fk.common.utiltest;

import org.junit.Test;

import com.tmsps.fk.common.util.Md5Util;

/**
 * 
 * @author 冯晓东 398479251@qq.com
 *
 */
public class Md5UtilTest {

	@Test
	public void testMd5() {
		System.err.println(Md5Util.md5("123456"));
	}
}
