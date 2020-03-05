package com.tmsps.fk.common.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 反射工具类
 * 
 * @author 冯晓东 398479251@qq.com
 *
 */
public class ClassUtil {

	public static List<Field> getClassFields(Class<?> clazz) {
		List<Field> clazzField = new ArrayList<Field>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			clazzField.add(field);
		} // #for
		return clazzField;
	}

	public static void setClassVal(Field field, Object obj, Object val) {
		boolean acc = field.isAccessible();
		field.setAccessible(true);
		try {
			field.set(obj, val);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			field.setAccessible(acc);
		}
	}

	public static <T> T fillMapToBean(final Class<T> clazz, Map<String, Object> map) {
		if (ChkUtil.isNull(map)) {
			return null;
		}
		try {
			T obj = clazz.getDeclaredConstructor().newInstance();
			List<Field> fs = ClassUtil.getClassFields(clazz);
			for (Field field : fs) {
				Object val = map.get(field.getName());
				ClassUtil.setClassVal(field, obj, val);
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
