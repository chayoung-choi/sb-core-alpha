package com.eden.sbcorealpha.utils;


import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Slf4j
public class DateUtil {

  public static final DateTimeFormatter DATETIME_FORMAT
          = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE;
  public static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ISO_LOCAL_TIME;

  private DateUtil() {
  }

  /**
   * <p>
   * 현재의 날짜와 시간을 리턴한다.
   * </p>
   *
   * @return String (현재 날짜와 시간)
   */
  public static String getNow() {
    LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    return now.format(DATETIME_FORMAT);
  }

  /**
   * <p>
   * 현재의 날짜과 시간을 포맷으로 변환하여 리턴한다.
   * </p>
   *
   * @param format (포맷)
   * @return String (현재 날짜와 시간)
   */
  public static String getNow(String format) {
    LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    try {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
      return now.format(formatter);
    } catch (IllegalArgumentException e) {
      log.error("잘못된 형식입니다. {}", e.getMessage());
      return "";
    }
  }
}
