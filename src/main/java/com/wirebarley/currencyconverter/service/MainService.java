package com.wirebarley.currencyconverter.service;

import com.wirebarley.currencyconverter.dto.ApiResponseDto;
import com.wirebarley.currencyconverter.dto.InputDto;
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

  @Value("${api-url}")
  private String url;

  @Value("${access-key}")
  private String accessKey;

  public MainService(RestTemplateBuilder builder) {
    this.restTemplate = builder.build();
  }

  public String getCurrencies(String currency) {
    ApiResponseDto apiResponseDto = restTemplate
        .getForObject(url + accessKey + "&currencies=KRW,JPY,PHP", ApiResponseDto.class);

    assert apiResponseDto != null;
    double response = apiResponseDto.getQuotes().get("USD" + currency);
    return new DecimalFormat("#,###,###,###.00").format(response);
  }

//  public double getCurrenciesRaw(String currency) {
//    ApiResponseDto apiResponseDto = restTemplate
//        .getForObject(url + accessKey + "&currencies=KRW,JPY,PHP", ApiResponseDto.class);
//    assert apiResponseDto != null;
//    return apiResponseDto.getQuotes().get("USD" + currency);
//  }

  /**
   * 수취금액을 계산하여 리턴한다.
   *
   * @param inputDto 수취국가, 환율, 송금액
   * @return 환율과 송금액의 곱
   */
  public String getReceipt(InputDto inputDto) {
    double result = Double.parseDouble(inputDto.getExchangeRate()) * Double.parseDouble(inputDto.getWiringAmounts());
    return new DecimalFormat("#,###,###,###.00").format(result);
  }
}
