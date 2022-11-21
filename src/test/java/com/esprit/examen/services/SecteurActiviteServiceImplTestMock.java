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

import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;

@SpringBootTest
public class SecteurActiviteServiceImplTestMock {

	@InjectMocks
	SecteurActiviteServiceImpl secteurActiviteService;
	@Mock
	SecteurActiviteRepository secteurActiviteRepository;
	
	public void TestretrieveAllSecteur()
	{
		List<SecteurActivite> ListSecteur=new ArrayList();
		ListSecteur.add(new SecteurActivite("1111","sect1"));
		ListSecteur.add(new SecteurActivite("2222","sect2"));
		Mockito.when(secteurActiviteRepository.findAll()).thenReturn(ListSecteur);	
	}
	
	@Test
	public void TestretrieveSecteurById()
	{
		SecteurActivite sect=new SecteurActivite("3333","sect3");
		Mockito.when(secteurActiviteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(sect));
		
		assertNotNull(secteurActiviteService.retrieveSecteurActivite(1L));
	}
	
	@Test
	public void TestupdateFournisseur()
	{
		SecteurActivite sect=new SecteurActivite();
		Mockito.when(secteurActiviteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(sect));
		sect.setCodeSecteurActivite("5555");
		Mockito.when(secteurActiviteRepository.save(sect)).thenReturn(sect);
		//Mockito.when(fournisseurRepository.save(f)).thenReturn(f);
	}
	
	@Test
	public void TestaddSecteur(){
		SecteurActivite sect=new SecteurActivite("8888","sect8");
		Mockito.when(secteurActiviteRepository.save(sect)).thenReturn(sect);
		
	}
	
@Test	
public void	TestdeleteSecteur(){
	SecteurActivite sect=new SecteurActivite();
	Mockito.when(secteurActiviteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(sect));
	secteurActiviteService.deleteSecteurActivite(sect.getIdSecteurActivite());
	}
	
}
