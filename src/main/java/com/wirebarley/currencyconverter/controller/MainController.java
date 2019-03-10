package com.wirebarley.currencyconverter.controller;

import com.wirebarley.currencyconverter.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gyumin Kim
 * @since 2019-03-10
 */
@RestController
@Slf4j
@RequestMapping("/api")
public class MainController {

  private MainService mainService;

  public MainController(MainService mainService) {
    this.mainService = mainService;
  }

  @GetMapping("/currencies")
  public ResponseEntity<?> getExchangeRate(@RequestParam String currency) {
    return ResponseEntity.ok(mainService.getCurrencies(currency));
  }

  @GetMapping("/currencies/raw")
  public ResponseEntity<?> getExchangeRateRaw(@RequestParam String currency) {
    return ResponseEntity.ok(mainService.getCurrenciesRaw(currency));
  }
}
