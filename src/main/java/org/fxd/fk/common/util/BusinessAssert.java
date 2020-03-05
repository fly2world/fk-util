package org.fxd.fk.common.util;

import org.fxd.fk.common.base.enums.ErrorCodeEnum;
import org.fxd.fk.common.base.exception.BusinessException;

/**
 * 业务检测 Assert,抛出的异常都是 BusinessException
 * 
 * @author 冯晓东 398479251@qq.com
 *
 */
public class BusinessAssert {

	public static void isTrue(boolean expression, ErrorCodeEnum codeEnum, Object... args) {
		if (expression != true) {
			throw new BusinessException(codeEnum, args);
		}
	}

	public static void isFalse(boolean expression, ErrorCodeEnum codeEnum, Object... args) {
		isTrue(!expression, codeEnum, args);
	}

	public static void notNull(Object object, ErrorCodeEnum codeEnum, Object... args) {
		isTrue(object != null, codeEnum, args);
	}

	public static void isNull(Object object, ErrorCodeEnum codeEnum, Object... args) {
		isTrue(object == null, codeEnum, args);
	}

}
