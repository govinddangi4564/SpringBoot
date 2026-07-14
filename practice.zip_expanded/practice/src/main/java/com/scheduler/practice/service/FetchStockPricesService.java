package com.scheduler.practice.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.scheduler.practice.dto.FetchStockPricesResponse;
import com.scheduler.practice.entity.FetchStockPrices;
import com.scheduler.practice.repository.FetchStockPricesRepository;

import tools.jackson.databind.ObjectMapper;

@Service
public class FetchStockPricesService {

	@Autowired
	private FetchStockPricesRepository repo;

	private static final String URL = "https://api.exchangerate-api.com/v4/latest/USD";

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Scheduled(cron = "*/10 * * * * *")
	public void fetchRate() {

		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).GET().build();

			HttpResponse<String> respose = client.send(request, HttpResponse.BodyHandlers.ofString());

			FetchStockPricesResponse apiResponse = objectMapper.readValue(respose.body(),
					FetchStockPricesResponse.class);

			FetchStockPrices rate = new FetchStockPrices();

			rate.setBase(apiResponse.base());
			rate.setInRate(apiResponse.rates().get("INR"));
			rate.setFetchedAt(LocalDateTime.now());

			repo.save(rate);

			System.out.println("Save Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<FetchStockPrices> getAll() {
		return repo.findAll();
	}

}
