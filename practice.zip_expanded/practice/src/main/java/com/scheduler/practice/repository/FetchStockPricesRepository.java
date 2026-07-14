package com.scheduler.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scheduler.practice.entity.FetchStockPrices;

@Repository
public interface FetchStockPricesRepository extends JpaRepository<FetchStockPrices, Long> {

}
