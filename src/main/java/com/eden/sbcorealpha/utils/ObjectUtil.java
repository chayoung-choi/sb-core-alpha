package com.eden.sbcorealpha.utils;

import org.springframework.util.ObjectUtils;

public class ObjectUtil {

  private ObjectUtil() {
  }

  /**
   * 해당 값이 null이거나 비어 있는 경우 true를 반환한다.
   *
   * @param obj 객체
   * @return boolean
   */
  public static boolean isEmpty(Object obj) {
    return ObjectUtils.isEmpty(obj);
  }
}
