package com.wirebarley.currencyconverter.service;

import com.wirebarley.currencyconverter.dto.ApiResponse;
import java.text.DecimalFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gyumin Kim
 * @since 2019-03-10
 */
@Service
@Slf4j
public class MainService {

  private RestTemplate restTemplate;

  @Value("${access-key}")
  private String accessKey;

  @Value("${api-url}")
  private String url;

  public MainService(RestTemplateBuilder builder) {
    this.restTemplate = builder.build();
  }

  public String getCurrencies(String currency) {
    ApiResponse apiResponse = restTemplate
        .getForObject(url + accessKey + "&currencies=KRW,JPY,PHP", ApiResponse.class);

    assert apiResponse != null;
    double response = apiResponse.getQuotes().get("USD" + currency);
    return new DecimalFormat("#,###,###,###.00").format(response);
  }

  public double getCurrenciesRaw(String currency) {
    ApiResponse apiResponse = restTemplate
        .getForObject(url + accessKey + "&currencies=KRW,JPY,PHP", ApiResponse.class);
    assert apiResponse != null;
    return apiResponse.getQuotes().get("USD" + currency);
  }
}
