package com.eden.sbcorealpha.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilTest {

  @Test
  void trim() {
    Assertions.assertThat(StringUtil.trim("")).isEmpty();
    Assertions.assertThat(StringUtil.trim(" ")).isEmpty();
    Assertions.assertThat(StringUtil.trim(" abc ")).isEqualTo("abc");
    Assertions.assertThat(StringUtil.trim(null)).isNull();
  }
}
