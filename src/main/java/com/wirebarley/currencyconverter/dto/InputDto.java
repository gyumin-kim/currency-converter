package com.wirebarley.currencyconverter.dto;

import com.wirebarley.currencyconverter.custom.WiringAmountsConstraint;

/**
 * @author Gyumin Kim
 * @since 2019-03-13
 */
public class InputDto {

  private String recipientCountry;
  private String exchangeRate;

  @WiringAmountsConstraint
  private String wiringAmounts;

  public String getRecipientCountry() {
    return recipientCountry;
  }

  public void setRecipientCountry(String recipientCountry) {
    this.recipientCountry = recipientCountry;
  }

  public String getExchangeRate() {
    return exchangeRate;
  }

  public void setExchangeRate(String exchangeRate) {
    this.exchangeRate = exchangeRate;
  }

  public String getWiringAmounts() {
    return wiringAmounts;
  }

  public void setWiringAmounts(String wiringAmounts) {
    this.wiringAmounts = wiringAmounts;
  }
}
