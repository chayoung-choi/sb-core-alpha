package com.eden.sbcorealpha.java;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringTest {

  @Test
  void splitExcelTab() {
    String data = """
        31171133	0055165181	SSE
        31171133	0054638284	SSE
        31171133	0055136528	SSE
        31171133	0055947989	SSE
        """;

    String[] arr = data.replaceAll("\n", "\t").split("\t");
    System.out.println(Arrays.toString(arr));
    Assertions.assertThat(arr).hasSizeGreaterThan(2);
  }
}
