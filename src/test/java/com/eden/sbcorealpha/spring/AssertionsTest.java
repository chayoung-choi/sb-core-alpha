package com.eden.sbcorealpha.spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AssertionsTest {

  @DisplayName("정상 동작 -> 성공, exception -> 실패")
  @Test
  void assertThatCode() {
    Assertions.assertThatCode(() -> System.out.println("print")).doesNotThrowAnyException();
  }

  @DisplayName("특정 exception -> 성공, 정상 동작 -> 실패")
  @Test
  void assertThatThrownBy() {
    Assertions.assertThatThrownBy(() -> {
      System.out.println("print");
      throw new IllegalStateException("boom!");
    }).isInstanceOf(Exception.class).hasMessageContaining("boom");
  }
}
