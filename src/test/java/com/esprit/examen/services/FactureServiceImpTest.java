package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.FactureRepository;

@SpringBootTest
public class FactureServiceImpTest {

	@Autowired
	IFactureService factureService;
	@Autowired
	FactureRepository factureRepository;
	
	@Test
	public void TestretrieveAllFactures()
	{
		List<Facture> ListFacture=new ArrayList();
		ListFacture.add(new Facture(10,20,false));
		ListFacture.add(new Facture(11,5,true));
		factureService.retrieveAllFactures();
	}
	
	
	@Test
	public void addFacture(){
		Facture fact=new Facture((int)2,(int)6,false);
		Facture savedFact= factureService.addFacture(fact);
		assertNotNull(savedFact.getIdFacture());
	
		assertSame(false, savedFact.getArchivee());
		factureService.cancelFacture(savedFact.getIdFacture());
		
	}
	
	@Test
	public void TestretrieveFactureById()
	{
		Facture fact=new Facture(30,10,true);
		factureService.retrieveFacture(1L);
	}
	
	
	@Test	
	public void	cancelFacture(){
		DetailFacture facture = new DetailFacture();
		Facture fact=new Facture((int)2,(int)6,false);
		Facture savedFact= factureService.addFacture(fact);
		//factureService.retrieveFacture(1L);
		factureService.cancelFacture(fact.getIdFacture());
		}
		
}
