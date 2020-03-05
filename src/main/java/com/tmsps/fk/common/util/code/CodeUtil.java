package com.tmsps.fk.common.util.code;

import java.lang.reflect.Field;
import java.util.List;

import com.tmsps.fk.common.util.ClassUtil;

/**
 * 代码工具类
 * 
 * @author 冯晓东 398479251@qq.com
 *
 */
public class CodeUtil {

	private static final String model = "setDto.setField(getDto.getField());";

	/**
	 * 生成 get set 函数
	 * 
	 * @param clazz
	 */
	public static void mkSetterAndGetter(Class<?> clazz, String setDto, String getDto) {
		List<Field> fieldList = ClassUtil.getClassFields(clazz);
		fieldList.forEach(field -> {
			String line = model.replace("setDto", setDto).replace("getDto", getDto).replace("Field",
					toUpperFristChar(field.getName()));
			System.err.println(line);
		});
	}

	/**
	 * 首字母大写
	 * 
	 * @param string
	 * @return
	 */
	public static String toUpperFristChar(String string) {
		char[] charArray = string.toCharArray();
		charArray[0] -= 32;
		return String.valueOf(charArray);
	}

}
