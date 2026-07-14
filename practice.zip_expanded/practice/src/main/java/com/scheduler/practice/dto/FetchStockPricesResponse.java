package com.scheduler.practice.dto;

import java.util.Map;

public record FetchStockPricesResponse(String base, Map<String, Double> rates) {

}
