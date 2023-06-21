package com.eden.sbcorealpha;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProjectTest {
  private ProjectTest() {
  }

  public void printString(String value) {
    log.info("printString :: {}", value);
  }
}
