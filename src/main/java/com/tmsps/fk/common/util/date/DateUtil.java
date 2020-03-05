package com.tmsps.fk.common.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author 冯晓东
 *
 */
public class DateUtil {

	private static final DateFormat dfYearMonth = new SimpleDateFormat("yyyyMM");
	private static final DateFormat df = new SimpleDateFormat("yyyyMMdd");

	/**
	 * 按月份增量后的日期
	 * 
	 * @param month
	 * @return
	 */
	public static int getTimeFromNowByMonth(int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.MONTH, month);
		String dateFmt = df.format(calendar.getTime());
		return new Integer(dateFmt);
	}

	/**
	 * 按天增量后的日期
	 * 
	 * @param month
	 * @return
	 */
	public static int getTimeFromNowByDay(int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.DAY_OF_YEAR, day);
		String dateFmt = df.format(calendar.getTime());
		return new Integer(dateFmt);
	}

	public static int getToday() {
		return getTimeFromNowByDay(0);
	}

	public static int addDay(String startDateStr, int day) {
		Date startDate;
		try {
			startDate = df.parse(startDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			// 如果有异常,设置为当前时间
			startDate = new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.DAY_OF_YEAR, day);
		String dateFmt = df.format(calendar.getTime());
		return new Integer(dateFmt);
	}

	public static String getYearMonth() {
		return dfYearMonth.format(new Date());
	}

	// 获取当前月份的总天数
	public static int getCurrentMonthDays() {
		Calendar a = Calendar.getInstance();
		// 把日期设置为当月第一天
		a.set(Calendar.DATE, 1);
		// 日期回滚一天，也就是最后一天
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

}
