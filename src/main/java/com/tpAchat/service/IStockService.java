package com.tpAchat.service;

import java.util.List;
import com.tpAchat.entities.Stock;

public interface IStockService {

	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	void deleteStock(Long id);

	Stock updateStock(Stock u);

	Stock retrieveStock(Long id);

	String retrieveStatusStock();
}
