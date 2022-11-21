package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Reglement;
import com.esprit.examen.entities.Stock;

@SpringBootTest
public class ReglementServiceImpTest {

	
	@Autowired
	IReglementService reglementService;
	
	
	@Test
	public void TestretrieveAllReglemet()
	{
		List<Reglement> ListReglement=new ArrayList();
		ListReglement.add(new Reglement(10,4,true));
		reglementService.retrieveAllReglements();	
	}
	
	@Test
	public void TestretrieveReglementById()
	{
		Reglement R=new Reglement(5,10,false);
		reglementService.retrieveReglement(1L);
		
	}
	
	@Test
	public void TestaddReglement(){
		Reglement R=new Reglement(5,10,false);
		Reglement savedReglement= reglementService.addReglement(R);
		
	}
	
}
