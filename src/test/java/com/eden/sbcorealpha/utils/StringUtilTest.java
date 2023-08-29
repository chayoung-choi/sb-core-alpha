package com.eden.sbcorealpha.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

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
    JSONObject jsonObject;
    jsonObject = new JSONObject(
        "{ " +
            "\"name\":\"John\"," +
            "\"age\":31," +
            "\"city\":\"New York\"" +
            "}"
    );
    System.out.println(jsonObject.toString());

    ObjectMapper mapper = new ObjectMapper();
    String jsonString = mapper.writeValueAsString(jsonObject);

  }
}
