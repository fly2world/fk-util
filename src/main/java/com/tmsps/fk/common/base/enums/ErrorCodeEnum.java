package com.tmsps.fk.common.base.enums;

/**
 * 错误码
 * 
 * @author 冯晓东 398479251@qq.com
 *
 */
public enum ErrorCodeEnum {

	// 500
	GL500(500, "%s"),
	// 9999100
	GL99990100(9999100, "参数异常"),
	// 99990401
	GL99990401(99990401, "无访问权限"),
	// 500
	GL99990500(500, "未知异常"),
	// 9999403
	GL99990403(9999403, "无权访问"),
	// 9999404
	GL9999404(9999404, "找不到指定资源"),
	// 99990001
	GL99990001(99990001, "注解使用错误"),
	// 99990002
	GL99990002(99990002, "微服务不在线,或者网络超时"),
	/**
	 * cloud 相关
	 */
	// 1000501
	CL1000501(1000501, "账号密码错误"),
	// 1000502
	CL1000502(1000502, "短信验证码错误"),
	/**
	 * shop 相关
	 */
	// 2000501
	SHOP2000501(2000501, "手机号已被注册"),
	// 2000502
	SHOP2000502(2000502, "用户名不存在"),

	// end
	;
	private int code;
	private String msg;

	/**
	 * Msg string.
	 *
	 * @return the string
	 */
	public String msg() {
		return msg;
	}

	/**
	 * Code int.
	 *
	 * @return the int
	 */
	public int code() {
		return code;
	}

	ErrorCodeEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * Gets enum.
	 *
	 * @param code the code
	 *
	 * @return the enum
	 */
	public static ErrorCodeEnum getEnum(int code) {
		for (ErrorCodeEnum ele : ErrorCodeEnum.values()) {
			if (ele.code() == code) {
				return ele;
			}
		}
		return null;
	}
}
