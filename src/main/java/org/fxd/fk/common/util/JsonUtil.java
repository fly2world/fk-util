package org.fxd.fk.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 好用的Json工具类
 * 
 * @author 冯晓东 398479251@qq.com
 *
 */
public class JsonUtil {

	private static short MIN_JSON_SIZE = 2;

	/**
	 * json 字符串 转 Map
	 * 
	 * @param json
	 * @return
	 */
	public static Map<String, Object> jsonStrToMap(String json) {
		Map<String, Object> map = new HashMap<String, Object>(20);
		if (ChkUtil.isNull(json)) {
			return map;
		}

		JSONObject jsonObject = JSON.parseObject(json);
		Set<String> keys = jsonObject.keySet();
		for (String key : keys) {
			map.put(key, jsonObject.get(key));
		}

		return map;
	}

	/**
	 * json 字符串 转 JSONObject
	 * 
	 * @param json
	 * @return
	 */
	public static Object jsonStrToJsonObject(String json, Class<?> clazz) {
		if (clazz == String.class) {
			if (json.length() > MIN_JSON_SIZE) {
				// 去掉首尾的引号
				json = json.substring(1, json.length() - 1);
			}
			return json;
		} else {
			JSONObject parse = JSON.parseObject(json);
			return JSON.toJavaObject(parse, clazz);
		}
	}

	/**
	 * 对象 转 json
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		return JSON.toJSONString(obj);
	}

	public static Map<String, Object> objToMap(Object obj) {
		String json = toJson(obj);
		Map<String, Object> map = jsonStrToMap(json);
		return map;
	}

	public static JSONObject jsonStrToJsonObject(String json) {
		JSONObject parse = JSON.parseObject(json);
		return parse;
	}
}
