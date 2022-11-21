package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.VerboseMockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;

@SpringBootTest
public class FournisseurServiceImpTestMock {
	
	@InjectMocks
	FournisseurServiceImpl fournisseurService;
	@Mock
	FournisseurRepository fournisseurRepository;
	
	@Mock
	DetailFournisseurRepository detaiFournisseurRepository;
	
	
	@Test
	public void TestretrieveAllFournisseurs()
	{
		List<Fournisseur> ListFournisseurs=new ArrayList();
		ListFournisseurs.add(new Fournisseur("1111","fourni1"));
		ListFournisseurs.add(new Fournisseur("2222","fourni2"));
		Mockito.when(fournisseurRepository.findAll()).thenReturn(ListFournisseurs);	
	}
	
	@Test
	public void TestretrieveFournisseurById()
	{
		Fournisseur fourni=new Fournisseur("3333","fourni2");
		Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fourni));
		
		assertNotNull(fournisseurService.retrieveFournisseur(1L));
	}
	
	@Test
	public void TestupdateFournisseur()
	{
		DetailFournisseur f = new DetailFournisseur();
		Mockito.when(detaiFournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
		f.setEmail("f@gmail.com");
		Mockito.when(detaiFournisseurRepository.save(f)).thenReturn(f);
		//Mockito.when(fournisseurRepository.save(f)).thenReturn(f);
	}
	
	@Test
	public void addFournisseur(){
		Fournisseur fourni=new Fournisseur("4444","fourni3");
		Mockito.when(fournisseurRepository.save(fourni)).thenReturn(fourni);
		
	}
	
@Test	
public void	deleteFournisseur(){
	DetailFournisseur f = new DetailFournisseur();
	Mockito.when(detaiFournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
	fournisseurService.deleteFournisseur(f.getIdDetailFournisseur());
	}
	

}
