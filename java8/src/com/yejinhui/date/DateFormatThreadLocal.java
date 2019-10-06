package com.yejinhui.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatThreadLocal {

	/**
	 * ThreadLocal会锁住df么？？？
	 */
	private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd");
		}
	};

	/**
	 * 转换
	 * 
	 * @throws Exception
	 */
	public static Date convert(String source) throws Exception {
		return df.get().parse(source);
	}
}
