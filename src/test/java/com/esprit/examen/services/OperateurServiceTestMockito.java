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

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.OperateurRepository;
import com.esprit.examen.repositories.ProduitRepository;

@SpringBootTest
public class OperateurServiceTestMockito {

	@Mock
    OperateurRepository opRep;
	@InjectMocks
	OperateurServiceImpl opService;
	
	
	@Test
	public void testRetrieveOperateurkById()
	{
		Operateur op=new Operateur("nomop","prnomop","passop");
		
		Mockito.when(opRep.findById(Mockito.anyLong())).thenReturn(Optional.of(op));
		assertNotNull(opService.retrieveOperateur(1L));
	}

	@Test
	public void testRetrieveAllStocks()
	{
		Operateur op1=new Operateur("nomop1","prnomop1","passop1");
		Operateur op2=new Operateur("nomop2","prnomop2","passop2");
		Operateur op3=new Operateur("nomop3","prnomop3","passop3");
		List<Operateur> ops= new ArrayList<Operateur>();
		ops.add(op1);
		ops.add(op2);
		ops.add(op3);
		Mockito.when(opRep.findAll()).thenReturn(ops);
		assertNotNull(opService.retrieveAllOperateurs());
	}
	

	@Test
	public void testUpdateStock()
	{
		Operateur op=new Operateur("nomop","prnomop","passop");
		
		
		Mockito.when(opRep.findById(Mockito.anyLong())).thenReturn(Optional.of(op));
		op.setNom("nom operateur");
		op.setPrenom("new prenom");
		op.setPassword("password");
		Mockito.when(opRep.save(op)).thenReturn(op);
		
	
	}
	

	@Test
	public void testCreateStock()
	{
		Operateur op=new Operateur("nomop","prnomop","passop");
		opService.addOperateur(op);
		
		Mockito.when(opRep.save(op)).thenReturn(op);
		assertNotNull(opService.addOperateur(op));
	}
	
	@Test
	public void deleteUserTest() {
		Operateur op=new Operateur("nomop","prnomop","passop");
		Mockito.when(opRep.findById(Mockito.anyLong())).thenReturn(Optional.of(op));
		opService.deleteOperateur(op.getIdOperateur());;
	
		
	}
	
}
