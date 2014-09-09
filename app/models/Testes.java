package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Testes {
	
	//private Sistema s;
	private Usuario u;
	
	@Before
	public void setUp() {
		//s = new Sistema();
		u = new Usuario("fabiano", "f@gmail.com", "0");
	}
	
	@Test
	public void deveCriarUmaNovaViagemAberta() {
		//Assert.assertEquals(s.listaDeViagens.size(), 0);
		//Viagem v = new Viagem("aaa", "01/04/2015", "passeio");
		//s.criaViagem(v);
		//Assert.assertEquals(s.listaDeViagens.size(), 1);
	}
	
	@Test
	public void deveAdicionarPessoaNaViagem() {
		Viagem v = new Viagem("aaa", "01/04/2015", "passeio");
		
		Assert.assertEquals(v.getNumeroDePessoasNaViagem(), 0);
		
		v.addPessoaNaViagem(u);
		
		Assert.assertEquals(v.getNumeroDePessoasNaViagem(), 1);
		
	}

}
