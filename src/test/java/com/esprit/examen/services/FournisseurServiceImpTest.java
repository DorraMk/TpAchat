package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;

@SpringBootTest
public class FournisseurServiceImpTest {

	@Autowired
	IFournisseurService fournisseurService;
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	DetailFournisseurRepository detailFournisseurRepository;
	
	@Test
	public void TestretrieveAllFournisseurs()
	{
		List<Fournisseur> ListFournisseurs=new ArrayList();
		ListFournisseurs.add(new Fournisseur("1111","fourni1"));
		ListFournisseurs.add(new Fournisseur("2222","fourni2"));
		fournisseurService.retrieveAllFournisseurs();	
	}
	
	@Test
	public void TestretrieveFournisseurById()
	{
		Fournisseur fourni=new Fournisseur("3333","fourni2");
		fournisseurService.retrieveFournisseur(1L);
	}
	
	@Test
	public void TestupdateFournisseur()
	{
		DetailFournisseur f = new DetailFournisseur();
		fournisseurService.retrieveFournisseur(1L);
		f.setEmail("f@gmail.com");
		detailFournisseurRepository.save(f);
	}
	
	@Test
	public void addFournisseur(){
		Fournisseur fourni=new Fournisseur("4444","fourni3");
		fournisseurRepository.save(fourni);
		
	}
	
@Test	
public void	deleteFournisseur(){
	DetailFournisseur f = new DetailFournisseur();
	Fournisseur fourni=new Fournisseur("4444","fourni3");
	Fournisseur savedFact= fournisseurService.addFournisseur(fourni);
	//detailFournisseurRepository.findById(1L);
	fournisseurService.deleteFournisseur(fourni.getIdFournisseur());
	}
}
