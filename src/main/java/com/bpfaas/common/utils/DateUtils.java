/**
* Copyright (c) 2020 Copyright bp All Rights Reserved.
* Author: brian.li
* Date: 2020-08-04 13:57
* Desc: 
*/
package com.bpfaas.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 时间工具, 用于将时间与utc时间进行转换.
 */
public class DateUtils {

  public static final String DEFAULT_FORMAT = "yyyyMMddHHmmssSSS";
  public static final String DEFAULT_TIMEZONE_ID = "GMT";

  private static final SimpleDateFormat dateFormat;

  static {
    dateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
    dateFormat.setTimeZone(TimeZone.getTimeZone(DEFAULT_TIMEZONE_ID));
  }

  /**
   * 将本地时间转换为utc字符串.
   * 
   * @return yyyyMMddHHmmssSSS
   */
  public static String date2utcstr(Date date) {
    if (null == date) {
      return null;
    }

    return dateFormat.format(date);
  }

  /**
   * 将utc字符串时间转换为本地时间.
   * 
   * @param utcstr yyyyMMddHHmmssSSS 或 yyyyMMddHHmmss 或 yyyyMMddHH
   * @return 本地时间.
   */
  public static Date utcstr2date(String utcstr) {
    try {
      if (utcstr == null) {
        return null;
      }
      if (utcstr.length() == 10)
        utcstr += "0000000";
      else if (utcstr.length() == 12)
        utcstr += "00000";
      else if (utcstr.length() == 14)
        utcstr += "000";
      else if (utcstr.length() != 17)
        return null;

      return dateFormat.parse(utcstr);
    } catch (Exception e) {
      return null;
    }
  }
}