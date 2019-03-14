package com.wirebarley.currencyconverter.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.wirebarley.currencyconverter.service.MainService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class MainControllerTest {

  private MockMvc mockMvc;

  @Before
  public void setup() {
    this.mockMvc = MockMvcBuilders
        .standaloneSetup(new MainController(new MainService(new RestTemplateBuilder()))).build();
  }

  @Test
  public void givenInputDataSubmitTest() throws Exception {
    MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders
        .get("/api/submit")
        .param("recipientCountry", "KRW")
        .param("exchangeRate", "1132.46")
        .param("wiringAmounts", "9248.34"))
        .andReturn().getResponse();

    assertThat(response.getStatus()).isEqualTo(200);
  }
}