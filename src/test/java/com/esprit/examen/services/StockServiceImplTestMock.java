package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;
import com.fasterxml.jackson.databind.ObjectWriter;

import ch.qos.logback.core.net.ObjectWriterFactory;
import junit.framework.Assert;

@SpringBootTest
public class StockServiceImplTestMock {
	
	@Mock
	StockRepository stockRepository;
	@InjectMocks
	StockServiceImpl StockService; 
	
	
	@Test
	public void testRetrieveStockById()
	{
		Stock stock=new Stock("Stock Test",10,100);
		
		Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
		assertNotNull(StockService.retrieveStock(1L));
	}

	@Test
	public void testRetrieveAllStocks()
	{
		Stock stock1=new Stock("Stock Test",10,100);
		Stock stock2=new Stock("Stock Test2",20,100);
		Stock stock3=new Stock("Stock Test",30,1080);
		List<Stock> stocks= new ArrayList<Stock>();
		stocks.add(stock1);
		stocks.add(stock2);
		stocks.add(stock3);
		Mockito.when(stockRepository.findAll()).thenReturn(stocks);
		assertNotNull(StockService.retrieveStock(1L));
	}
	

	@Test
	public void testUpdateStock()
	{
		Stock stock1=new Stock();
		
		
		Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock1));
		stock1.setLibelleStock("new stock");
		stock1.setQte(100);
		stock1.setQteMin(200);
		Mockito.when(stockRepository.save(stock1)).thenReturn(stock1);
		
	
	}
	

	@Test
	public void testCreateStock()
	{
		Stock stock1=new Stock("Stock Test create",100,1020);
		StockService.addStock(stock1);
		
		Mockito.when(stockRepository.save(stock1)).thenReturn(stock1);
		assertNotNull(StockService.addStock(stock1));
	}
	
	@Test
	public void deleteUserTest() {
		Stock stock = new Stock("Test delete", 33, 330);
		Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
		StockService.deleteStock(stock.getIdStock());;
	
		
	}
	
	
	
}
