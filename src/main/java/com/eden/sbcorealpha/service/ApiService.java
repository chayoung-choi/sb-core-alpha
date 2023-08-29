package com.eden.sbcorealpha.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings("checkstyle:MissingJavadocType")
@Service
@RequiredArgsConstructor
@Slf4j
public class ApiService {

  private final RestTemplate restTemplate;

  public Map<String, Object> get(String url, HttpHeaders httpHeaders) {
    return callApiEndpoint(url, HttpMethod.GET, httpHeaders, null, null);
  }

  public Map<String, Object> get(String url, HttpHeaders httpHeaders,
      Map<String, Object> uriVariables) {
    return callApiEndpoint(url, HttpMethod.GET, httpHeaders, null, uriVariables);
  }

  public Map<String, Object> post(String url, HttpHeaders httpHeaders, Object body) {
    return callApiEndpoint(url, HttpMethod.POST, httpHeaders, body, null);
  }

  public Map<String, Object> put(String url, HttpHeaders httpHeaders, Object body) {
    return callApiEndpoint(url, HttpMethod.PUT, httpHeaders, body, null);
  }

  public Map<String, Object> delete(String url, HttpHeaders httpHeaders, Object body) {
    return callApiEndpoint(url, HttpMethod.DELETE, httpHeaders, body, null);
  }

  private Map<String, Object> callApiEndpoint(String url, HttpMethod httpMethod,
      HttpHeaders httpHeaders, Object body, Map<String, Object> uriVariables) {
    restTemplate.getInterceptors().add((request, json, execution) -> {
      ClientHttpResponse response = execution.execute(request, json);
      response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
      return response;
    });

    JSONObject json = null;
    if (uriVariables == null) {
      json = restTemplate.exchange(url, httpMethod, new HttpEntity<>(body, httpHeaders),
          JSONObject.class).getBody();
    } else {
      json = restTemplate.exchange(url, httpMethod, new HttpEntity<>(body, httpHeaders),
          JSONObject.class, uriVariables).getBody();
    }

    Map<String, Object> map = new HashMap<>();
    try {
      if (json != null) {
        map = new ObjectMapper().readValue(json.toString(), Map.class);
      }
    } catch (Exception e) {
      log.error(e.getMessage());
    }

    return map;
  }
}
