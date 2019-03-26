package com.wirebarley.currencyconverter.controller;

import com.wirebarley.currencyconverter.dto.InputDto;
import com.wirebarley.currencyconverter.service.MainService;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gyumin Kim
 * @since 2019-03-10
 */
@RestController
@RequestMapping("/api")
public class MainController {

  private MainService mainService;

  public MainController(MainService mainService) {
    this.mainService = mainService;
  }

  @GetMapping("/rate")
  public ResponseEntity<?> getExchangeRate(@RequestParam String currency) {
    return ResponseEntity.ok(mainService.getExchangeRateFromApi(currency));
  }

  @GetMapping("/submit")
  public ResponseEntity<?> submit(@Valid @ModelAttribute InputDto inputDto) {
    return ResponseEntity.ok(mainService.getReceipt(inputDto));
  }
}
