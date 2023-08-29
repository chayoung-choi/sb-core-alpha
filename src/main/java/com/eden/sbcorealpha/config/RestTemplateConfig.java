/*
 *
 * PROJ : 대교 차세대 드림스 구축 프로젝트
 * Copyright © 2022 DAEKYO. All Rights Reserved
 *
 */

package com.eden.sbcorealpha.config;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings("checkstyle:MissingJavadocType")
@Configuration
@Slf4j
public class RestTemplateConfig {

  public RestTemplateConfig() {
    log.debug("RestTemplateConfig 초기화");
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
    log.debug("factory : " + factory);

    BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory
        = new BufferingClientHttpRequestFactory(factory);

    return restTemplateBuilder
        .requestFactory(() -> bufferingClientHttpRequestFactory)
        .setConnectTimeout(Duration.ofMillis(5000))
        .setReadTimeout(Duration.ofMillis(5000))
        .additionalInterceptors(new RequestResponseLoggingInterceptor())
        .build();
  }
}
