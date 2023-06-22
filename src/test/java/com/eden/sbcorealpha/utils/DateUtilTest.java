package com.eden.sbcorealpha.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class DateUtilTest {
  @Test
  void getNow() {
    String now = DateUtil.getNow();
    System.out.println(now);
    assertThat(now).isNotEmpty();
  }

  @Test
  void getNowAsFormat() {
    assertThatNoException().isThrownBy(() -> {
      System.out.println(DateUtil.getNow("yyyy/MM/dd"));
      System.out.println(DateUtil.getNow("HH:mm"));
    });
    assertThat(DateUtil.getNow("HH:mm:ss3f")).isEmpty();
  }

  @DisplayName("DateTimeFormatter 정보")
  @Test
  void printDateTimeFormatter() {
    assertThatNoException().isThrownBy(() -> {
      LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

      System.out.println(now.format(DateTimeFormatter.BASIC_ISO_DATE)); // 20230622
      System.out.println(now.format(DateTimeFormatter.ISO_DATE)); // 2023-06-22
      System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE)); // 2023-06-22
      System.out.println(now.format(DateTimeFormatter.ISO_DATE_TIME)); // 2023-06-22T17:32:05.406282
      System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // 2023-06-22T17:32:05.406282
      System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_TIME)); // 17:32:05.406282
      System.out.println(now.format(DateTimeFormatter.ISO_WEEK_DATE)); // 2023-W25-4

      System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))); // 2023년 6월 22일 목요일
      System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))); // 2023년 6월 22일
      System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))); // 2023. 6. 22.
      System.out.println(now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))); // 23. 6. 22.

      System.out.println(now.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM))); // 오후 5:36:06
      System.out.println(now.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))); // 오후 5:36

      System.out.println(now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))); // 2023. 6. 22. 오후 5:36:06
      System.out.println(now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT))); // 23. 6. 22. 오후 5:36
    });
  }
}
