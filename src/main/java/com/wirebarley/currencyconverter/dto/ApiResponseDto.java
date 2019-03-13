package com.wirebarley.currencyconverter.dto;

import java.util.Map;

/**
 * @author Gyumin Kim
 * @since 2019-03-10
 */
public class ApiResponseDto {

  private boolean success;
  private String timestamp;
  private String source;
  private Map<String, Double> quotes;

  public boolean isSuccess() {
    return success;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public String getSource() {
    return source;
  }

  public Map<String, Double> getQuotes() {
    return quotes;
  }
}
