package com.eden.sbcorealpha.utils;

public class StringUtil {

  private StringUtil() {
  }

  /**
   * 객체를 String 형으로 변경 후 리턴한다.
   *
   * @param obj 변경할 객체
   * @return String
   */
  public static String toString(Object obj) {
    if (obj == null) {
      return "";
    }
    return String.valueOf(obj);
  }

  /**
   * 해당 값이 null이거나 비어 있는 경우, whitespace(" )이면 true를 반환한다.
   *
   * @param obj 객체
   * @return boolean
   */
  public static boolean isBlank(Object obj) {
    String str = (obj == null) ? "" : String.valueOf(obj).trim();
    return str.length() == 0;
  }

  /**
   * 해당 값이 null일 경우 null을 리턴하고, 그 외는 좌우 공백 제거 후 리턴한다.
   *
   * @param str 문자형 객체
   * @return String (공백제거 후 문자)
   */
  public static String trim(String str) {
    return (str == null) ? null : str.trim();
  }
}
