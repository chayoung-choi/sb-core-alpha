package com.eden.sbcorealpha.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Slf4j
class ParameterTest {

  static Stream<Arguments> getReport() {
    return ParameterTestFixture.getReport();
  }

  @ParameterizedTest(name = "{1}의 {0} 점수는 {2}")
  @MethodSource("getReport")
  void testMethodSource(String subjName, String studentName, int score) {
    log.info("{}의 {} 점수는 {}입니다.", studentName, subjName, score);
    assertThat(score).isGreaterThan(10);
  }
}
