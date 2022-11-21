package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;

@SpringBootTest
public class ProduitServiceTestMockito {

	@Mock
	ProduitRepository prodRepository;
	@InjectMocks
	ProduitServiceImpl prodService;
	
	
	@Test
	public void testRetrieveStockById()
	{
		Produit produit=new Produit("produit test",100);
		
		Mockito.when(prodRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
		assertNotNull(prodService.retrieveProduit(1L));
	}

	@Test
	public void testRetrieveAllStocks()
	{
		Produit produit1=new Produit("produit test",100);
		Produit produit2=new Produit("produit test",100);
		Produit produit3=new Produit("produit test",100);
		List<Produit> prods= new ArrayList<Produit>();
		prods.add(produit1);
		prods.add(produit2);
		prods.add(produit3);
		Mockito.when(prodRepository.findAll()).thenReturn(prods);
		assertNotNull(prodService.retrieveAllProduits());
	}
	

	@Test
	public void testUpdateStock()
	{
		Produit produit=new Produit("produit test",100);
		
		
		Mockito.when(prodRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
		produit.setLibelleProduit("test update");
		produit.setPrix(200);
		Mockito.when(prodRepository.save(produit)).thenReturn(produit);
		
	
	}
	

	@Test
	public void testCreateStock()
	{
		Produit produit=new Produit("produit test",100);
		prodService.addProduit(produit);
		
		Mockito.when(prodRepository.save(produit)).thenReturn(produit);
		assertNotNull(prodService.addProduit(produit));
	}
	
	@Test
	public void deleteUserTest() {
		Produit produit=new Produit("produit test",100);
		Mockito.when(prodRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
		prodService.deleteProduit(produit.getIdProduit());;
	
		
	}
	
	
}
