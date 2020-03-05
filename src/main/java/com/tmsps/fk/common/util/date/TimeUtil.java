package com.tmsps.fk.common.util.date;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 日期工具类
 * 
 * @author 冯晓东
 *
 */
public class TimeUtil {

	private static final DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

	public static long getCreateTime() {
		String dateFmt = df.format(new Timestamp(System.currentTimeMillis()));
		return new Long(dateFmt);
	}

	/**
	 * 将时间转换成需要的格式
	 */
	public static String getTiemModle(Date date, String modle) {
		java.text.SimpleDateFormat sf = new SimpleDateFormat(modle);
		return sf.format(date);
	}

	public static Timestamp getCurrentTimestamp() {
		return Timestamp.valueOf(getCurrentTime("yyyy-MM-dd HH:mm:ss"));
	}

	/**
	 * 获取当前时间戳
	 */
	public static String getCurrentTime(String model) {
		return TimeUtil.getTiemModle(new Date(System.currentTimeMillis()), model);
	}
}
