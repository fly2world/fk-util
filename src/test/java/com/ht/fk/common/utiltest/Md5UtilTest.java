package com.ht.fk.common.utiltest;

import org.fxd.fk.common.util.Md5Util;
import org.junit.Test;

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
