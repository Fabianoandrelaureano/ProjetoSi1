package models;

import org.junit.*;


public class Testes {
	
	private Usuario u1, u2, u3;
	
	@Before
	public void setUp() {
		u1 = new Usuario("fabiano", "f@gmail.com", "0");
		u2 = new Usuario("fab", "fab@gmail.com", "1");
		u3 = new Usuario("fabiano", "f@gmail.com", "0");
	}
	
	@Test
	public void deveAdicionarPessoaNaViagem() {
		//Viagem aberta
		Viagem v1 = new Viagem("local", "data", "descricao", u1);
		
		Assert.assertEquals(v1.getNumeroDePessoasNaViagem(), 0);
		
		v1.addPessoaNaViagem(u2, "");
		
		Assert.assertEquals(v1.getNumeroDePessoasNaViagem(), 1);
		
		//Viagem limitada
		Viagem v2 = new Viagem("local", "data", "descricao", u2);
		
		Assert.assertEquals(v2.getNumeroDePessoasNaViagem(), 0);
		
		v2.addPessoaNaViagem(u1, "1");
		
		Assert.assertEquals(v2.getNumeroDePessoasNaViagem(), 1);		
		
	}
	
	@Test
	public void naoDeveAdicionarUsuariosIguaisNaViagem() {
		Viagem v1 = new Viagem("local", "data", "descricao", u1);
		
		Assert.assertEquals(v1.getNumeroDePessoasNaViagem(), 0);
		
		v1.addPessoaNaViagem(u1, "");
		
		Assert.assertEquals(v1.getNumeroDePessoasNaViagem(), 1);
		
		v1.addPessoaNaViagem(u3, "");
		
		Assert.assertEquals(v1.getNumeroDePessoasNaViagem(), 1);

	}
	
	@Test
	public void deveEstaNaViagem() {
		Viagem v1 = new Viagem("local", "data", "descricao", u1);
		
		v1.addPessoaNaViagem(u2, "");
		
		Assert.assertEquals(v1.getParticipantes().contains(u2), true);		
		
	}
	
	@Test
	public void deveRemoverParticipanteDaViagem() {
		Viagem v1 = new Viagem("local", "data", "descricao", u1);
		
		v1.addPessoaNaViagem(u2, "");
		
		Assert.assertEquals(v1.getParticipantes().contains(u2), true);
		
		v1.removeParticipante(u2);
		
		Assert.assertEquals(v1.getParticipantes().contains(u2), false);
		
	}
	
	@Test
	public void testeDoEquals() {
		Assert.assertEquals(u1.equals(u3), true);
		Assert.assertEquals(u1.equals(u2), false);
	}

}
