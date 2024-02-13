package com.eden.sbcorealpha.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.net.URLEncoder;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class StringUtilTest {

  @Test
  void trim() {
    Assertions.assertThat(StringUtil.trim("")).isEmpty();
    Assertions.assertThat(StringUtil.trim(" ")).isEmpty();
    Assertions.assertThat(StringUtil.trim(" abc ")).isEqualTo("abc");
    Assertions.assertThat(StringUtil.trim(null)).isNull();
  }

  @Test
  void jsonToString() throws JSONException, JsonProcessingException {
    String strJson = """
        [{"type":"section","text":{"type":"mrkdwn","text":"This is a section block with a button."},"accessory":{"type":"button","text":{"type":"plain_text","text":"Slack","emoji":true},"value":"click_me","url": "https://google.com",","action_id":"button-action"}}]
        """;

    strJson = URLEncoder.encode(strJson);
    System.out.println(strJson);
    Assertions.assertThat(strJson).isNotEmpty();
  }
}
