package com.yearjane.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化日期工具
 * @author 陈小锋
 *
 */
public class DateFormatUtil {
	/**
	 * 将yyyy-MM-dd类型的字符串转为日期类
	 * @param date
	 * @return
	 * @throws ParseException
	 */
  public static Date formatStringDate(String date) throws ParseException {
	  SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	  return format.parse(date);
  }
}
