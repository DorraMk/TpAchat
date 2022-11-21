package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.ReglementRepository;

public class ReglementServiceTestMock {
	
	@InjectMocks
	ReglementServiceImpl reglementService;
	
	@Mock
	ReglementRepository reglementRepository;
	
	@Test
	public void TestretrieveAllReglemet()
	{
		List<Reglement> ListReglement=new ArrayList();
		ListReglement.add(new Reglement(10,4,true));
		Mockito.when(reglementRepository.findAll()).thenReturn(ListReglement);	
	}
	
	@Test
	public void TestretrieveReglementById()
	{
		Reglement R=new Reglement(5,10,false);
		Mockito.when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(R));
		
		assertNotNull(reglementService.retrieveReglement(1L));
	}
	
	@Test
	public void TestaddReglement(){
		Reglement R=new Reglement(5,10,false);
		Mockito.when(reglementRepository.save(R)).thenReturn(R);
		
	}
}
