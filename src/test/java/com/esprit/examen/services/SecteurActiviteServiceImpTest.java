package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;

@SpringBootTest
public class SecteurActiviteServiceImpTest {

	@Autowired
	ISecteurActiviteService secteurService;
	@Autowired
	SecteurActiviteRepository secteurRepository;
	
	@Test
	public void TestretrieveAllSecteur()
	{
		List<SecteurActivite> ListSecteur=new ArrayList();
		ListSecteur.add(new SecteurActivite("1111","sect1"));
		ListSecteur.add(new SecteurActivite("2222","sect2"));
		secteurService.retrieveAllSecteurActivite();	
	}
	
	@Test
	public void TestretrieveSecteurById()
	{
		SecteurActivite sect=new SecteurActivite("3333","sect3");
		secteurService.retrieveSecteurActivite(1L);
		
	}
	
	@Test
	public void TestupdateFournisseur()
	{
		SecteurActivite sect=new SecteurActivite();
		secteurService.retrieveSecteurActivite(1L);
		sect.setCodeSecteurActivite("5555");
		secteurRepository.save(sect);
	}
	
	@Test
	public void TestaddSecteur(){
		SecteurActivite sect=new SecteurActivite("8888","sect8");
		secteurRepository.save(sect);
		
	}
	
@Test	
public void	TestdeleteSecteur(){
	SecteurActivite sect=new SecteurActivite("8888","sect8");
	secteurService.addSecteurActivite(sect);
	//secteurService.retrieveSecteurActivite(1L);
	secteurService.deleteSecteurActivite(sect.getIdSecteurActivite());
	}
	

	
}
