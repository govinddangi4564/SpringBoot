package com.scheduler.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.practice.entity.FetchStockPrices;
import com.scheduler.practice.service.FetchStockPricesService;

@RestController
@RequestMapping("exchange")
public class FetchStockPricesController {

	@Autowired
	private FetchStockPricesService service;

	@GetMapping
	public List<FetchStockPrices> getAll() {
		return service.getAll();
	}
}
