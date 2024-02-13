package com.eden.sbcorealpha.java;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
@Slf4j
class StreamTest {

  private static long processSequentially(List<Integer> numbers) {
    long startTime = System.currentTimeMillis();

    numbers.stream()
        .map(number -> {
          // 여기서 각 요소에 대한 처리 작업이 수행됩니다.
          simulateProcessing();
          return number;
        })
        .forEach(System.out::println);

    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }

  private static long processInParallel(List<Integer> numbers) {
    long startTime = System.currentTimeMillis();

    numbers.parallelStream()
        .map(number -> {
          // 여기서 각 요소에 대한 병렬 처리 작업이 수행됩니다.
          simulateProcessing();
          return number;
        })
        .forEach(System.out::println);

    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }

  private static void simulateProcessing() {
    try {
      Thread.sleep(1000); // 1초 대기 (처리 시간을 시뮬레이션하기 위해)
    } catch (InterruptedException e) {
      log.error(e.getMessage());
    }
  }

  @Test
  void testParallelStream() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // 순차 스트림으로 처리
    long sequentialTime = processSequentially(numbers);

    // 병렬 스트림으로 처리
    long parallelTime = processInParallel(numbers);

    log.info("Sequential Time: {} ms", sequentialTime);
    log.info("Parallel Time: {} ms", parallelTime);
  }
}
