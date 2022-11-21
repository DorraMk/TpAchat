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

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.ProduitRepository;

@SpringBootTest
public class CategorieProduitServiceTestMockito {

	
	@Mock
	CategorieProduitRepository catRepo;
	
	@InjectMocks
	CategorieProduitServiceImpl catService;
	
	
	@Test
	public void testRetrieveCatkById()
	{
		CategorieProduit catproduit=new CategorieProduit("12h","cat1");
		
		Mockito.when(catRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(catproduit));
		assertNotNull(catService.retrieveCategorieProduit(1L));
	}

	@Test
	public void testRetrieveAllCategories()
	{
		CategorieProduit catproduit1=new CategorieProduit("12h","cat1");
		CategorieProduit catproduit2=new CategorieProduit("12h","cat1");
		CategorieProduit catproduit3=new CategorieProduit("12h","cat1");
		List<CategorieProduit> prods= new ArrayList<CategorieProduit>();
		prods.add(catproduit1);
		prods.add(catproduit2);
		prods.add(catproduit3);
		Mockito.when(catRepo.findAll()).thenReturn(prods);
		assertNotNull(catService.retrieveAllCategorieProduits());
	}
	

	@Test
	public void testUpdateCat()
	{
		CategorieProduit catproduit=new CategorieProduit("12h","cat1");
		
		
		Mockito.when(catRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(catproduit));
		catproduit.setCodeCategorie("136 JF");
		catproduit.setLibelleCategorie("categorie testupdate");
		Mockito.when(catRepo.save(catproduit)).thenReturn(catproduit);
		
	
	}
	

	@Test
	public void testCreateCat()
	{
		CategorieProduit catproduit=new CategorieProduit("12h","cat1");
		catService.addCategorieProduit(catproduit);
		
		Mockito.when(catRepo.save(catproduit)).thenReturn(catproduit);
		assertNotNull(catService.addCategorieProduit(catproduit));
	}
	
	@Test
	public void deleteCatTest() {
		CategorieProduit catproduit=new CategorieProduit("12h","cat1");
		Mockito.when(catRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(catproduit));
		catService.deleteCategorieProduit(catproduit.getSerialversionuid());;
	
		
	}
	
	

}
