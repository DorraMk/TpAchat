package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.DetailFactureRepository;
import com.esprit.examen.repositories.FactureRepository;

@SpringBootTest
public class FactureServiceImplTestMock {

	@InjectMocks
	FactureServiceImpl factureService;
	@Mock
	FactureRepository factureRepository;
	
	@Mock
	DetailFactureRepository detailFactureRepository;
	
	public void TestretrieveAllFactures()
	{
		List<Facture> ListFacture=new ArrayList();
		ListFacture.add(new Facture(10,20,false));
		ListFacture.add(new Facture(11,5,true));
		Mockito.when(factureRepository.findAll()).thenReturn(ListFacture);	
	}
	
	
	@Test
	public void addFacture(){
		Facture fact=new Facture(2,6,false);
		Mockito.when(factureRepository.save(fact)).thenReturn(fact);
		
	}
	
	@Test
	public void TestretrieveFactureById()
	{
		Facture fact=new Facture(30,10,true);
		Mockito.when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fact));
		
		assertNotNull(factureService.retrieveFacture(1L));
	}
	
	
	@Test	
	public void	cancelFacture(){
		DetailFacture fact = new DetailFacture();
		Mockito.when(detailFactureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fact));
		factureService.cancelFacture(fact.getIdDetailFacture());
		}
		
}
