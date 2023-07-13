package com.eden.sbcorealpha.spring;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class ParameterTestFixture {

  public static Stream<Arguments> getReport() {
    return Stream.of(
        Arguments.of("국어", "최학생", 95),
        Arguments.of("영어", "박학생", 58),
        Arguments.of("수학", "김학생", 98)
    );
  }
}
