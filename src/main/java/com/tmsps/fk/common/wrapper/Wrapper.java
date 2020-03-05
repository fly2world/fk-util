/*
 * Copyright (c) 2018. 冯晓东 All Rights Reserved.
 * 项目名称：企业级分布式微服务平台
 * 类名称：Wrapper.java
 * 创建人：冯晓东
 */

package com.tmsps.fk.common.wrapper;

import lombok.Data;

import java.io.Serializable;

/**
 * The class HtWrapper.
 *
 * @param <T> the type parameter @author paascloud.net@gmail.com
 */
@Data
public class Wrapper<T> implements Serializable {
	/**
	 * 序列化标识
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 成功码.
	 */
	public static final int SUCCESS_CODE = 200;

	/**
	 * 成功信息.
	 */
	public static final String SUCCESS_MESSAGE = "操作成功";

	/**
	 * 错误码.
	 */
	public static final int ERROR_CODE = 500;

	/**
	 * 错误信息.
	 */
	public static final String ERROR_MESSAGE = "内部异常";

	/**
	 * 错误码：参数非法
	 */
	public static final int ILLEGAL_ARGUMENT_CODE_ = 100;

	/**
	 * 错误信息：参数非法
	 */
	public static final String ILLEGAL_ARGUMENT_MESSAGE = "参数非法";

	/**
	 * 坑爹的extjs,必须返回此字段,才能进入success
	 */
	private boolean success = true;
	/**
	 * 编号.
	 */
	private int code;

	/**
	 * 信息.
	 */
	private String message;

	/**
	 * 结果数据
	 */
	private T result;

	/**
	 * Instantiates a new wrapper. default code=200
	 */
	Wrapper() {
		this(SUCCESS_CODE, SUCCESS_MESSAGE);
	}

	/**
	 * Instantiates a new wrapper.
	 *
	 * @param code    the code
	 * @param message the message
	 */
	Wrapper(int code, String message) {
		this(code, message, null);
	}

	/**
	 * Instantiates a new wrapper.
	 *
	 * @param code    the code
	 * @param message the message
	 * @param result  the result
	 */
	Wrapper(int code, String message, T result) {
		super();
		this.code(code).message(message).result(result);
	}

	/**
	 * Sets the 编号 , 返回自身的引用.
	 *
	 * @param code the new 编号
	 *
	 * @return the wrapper
	 */
	private Wrapper<T> code(int code) {
		this.setCode(code);
		return this;
	}

	/**
	 * Sets the 信息 , 返回自身的引用.
	 *
	 * @param message the new 信息
	 *
	 * @return the wrapper
	 */
	private Wrapper<T> message(String message) {
		this.setMessage(message);
		return this;
	}

	/**
	 * Sets the 结果数据 , 返回自身的引用.
	 *
	 * @param result the new 结果数据
	 *
	 * @return the wrapper
	 */
	public Wrapper<T> result(T result) {
		this.setResult(result);
		return this;
	}

	/**
	 * 判断是否成功： 依据 HtWrapper.SUCCESS_CODE == this.code
	 *
	 * @return code =200,true;否则 false.
	 */
	public boolean success() {
		return Wrapper.SUCCESS_CODE == this.code;
	}

	/**
	 * 判断是否成功： 依据 HtWrapper.SUCCESS_CODE != this.code
	 *
	 * @return code !=200,true;否则 false.
	 */
	public boolean error() {
		return !success();
	}

}
