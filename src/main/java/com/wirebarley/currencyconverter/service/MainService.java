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

  @Value("${currencies}")
  private String currencies;

  public MainService(RestTemplateBuilder builder) {
    this.restTemplate = builder.build();
  }

  /**
   * /달러 환율
   * 만약 {@param country}가 KRW라면, KRW/USD(원/달러) 환율을 리턴한다.
   *
   * @param country 국가명
   * @return 해당 국가 화폐/달러 환율
   */
  public String getExchangeRateFromApi(String country) {
    ApiResponseDto apiResponseDto = restTemplate
        .getForObject(url + accessKey + "&currencies=" + currencies, ApiResponseDto.class);

    assert apiResponseDto != null;
    double response = apiResponseDto.getQuotes().get("USD" + country);
    return new DecimalFormat("#,###,###,###.00").format(response);
  }

  /**
   * 최종 수취금액을 계산하여 리턴한다.
   *
   * @param inputDto 수취국가, 환율, 송금액
   * @return 환율과 송금액의 곱
   */
  public String getReceipt(InputDto inputDto) {
    double result = Double.parseDouble(inputDto.getExchangeRate()) * Double.parseDouble(inputDto.getWiringAmounts());
    return new DecimalFormat("#,###,###,###.00").format(result);
  }
}
