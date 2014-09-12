package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Usuario;
import models.Viagem;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.db.jpa.*;

public class ControladorDeBD {
	
	private static GenericDAO dao = new GenericDAOImpl();
	
	private static ControladorDeBD controlador;
	private Viagem v = new Viagem("Tanga","1/1/2015","descricao",new Usuario("Ítalo", "italo.lins@ccc.ufcg.edu.br", "123"));
	private List<Viagem> viagem = new ArrayList<Viagem>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private ControladorDeBD(){
		Usuario[] users = {new Usuario("Ítalo", "italo.lins@ccc.ufcg.edu.br", "123"), new Usuario("Fabiano", "fabiano.laureano@ccc.ufcg.edu.br", "123"), new Usuario("Wellington", "wellington.araujo.silva@ccc.ufcg.edu.br", "123"), new Usuario("Guilherme", "guilherme@gmail.com", "123"), new Usuario("Gustavo", "gustavo@gmail.com", "123"), 
				new Usuario("Jose", "jose@gmail.com", "123"), new Usuario("Carlos", "carlos@gmail.com", "123"), new Usuario("Antonio", "antonio@gmail.com", "123"), new Usuario("Vitor", "vitor@gmail.com", "123"), new Usuario("Pedro", "pedro@gmail.com", "123"), 
				new Usuario("Joao", "joao@outlook.com", "123"), new Usuario("Maria", "maria@outlook.com", "123"), new Usuario("Marta", "marta@outlook.com", "123"), new Usuario("Carla", "carla@outlook.com", "123"), new Usuario("Enzo", "enzo@outlook.com", "123"), 
				new Usuario("Ricardo", "ricardo@gmail.com", "123"), new Usuario("Batista", "batista@gmail.com", "123"), new Usuario("Hugo", "hugo@gmail.com", "123"), new Usuario("Silvano", "silvano@gmail.com", "123"), new Usuario("Vilma", "vilma@gmail.com", "123"), 
				new Usuario("Fred", "fred@outlook.com", "123"), new Usuario("Barney", "barney@outlook.com", "123"), new Usuario("Sidney", "sidney@outlook.com", "123"), new Usuario("Kimberly", "kymberly@outlook.com", "123"), new Usuario("Seya", "seya@outlook.com", "123"), 
				new Usuario("Mario", "mario@gmail.com", "123"), new Usuario("Vegeta", "vegeta@gmail.com", "123"), new Usuario("Goku", "goku@gmail.com", "123"), new Usuario("Madinbu", "madinbu@gmail.com", "123"), new Usuario("Capile", "capile@gmail.com", "123"),  
				new Usuario("Dalton", "dalton@outlook.com", "123"), new Usuario("Wilkerson", "wilkerson@outlook.com", "123"), new Usuario("Leandro", "leandro@outlook.com", "123"), new Usuario("Leonardo", "leonardo@outlook.com", "123"), new Usuario("Chitaozinho", "chitaozinho@outlook.com", "123"), 
				new Usuario("Xororo", "xororo@gmail.com", "123"), new Usuario("Pele", "pele@gmail.com", "123"), new Usuario("Ronaldo", "ronaldo@gmail.com", "123"), new Usuario("Naoli", "naoli@gmail.com", "123"), new Usuario("Nemlerei", "nemlerei@gmail.com", "123")}; 		
		for (Usuario user:users){
			usuarios.add(user);
		}
		
		v.addPessoaNaViagem(new Usuario("Ítalo", "italo.lins@ccc.ufcg.edu.br", "123"), "");
		viagem.add(v);
	}
	
	public static ControladorDeBD getInstance(){
		if(controlador == null){
			controlador = new ControladorDeBD();
		}
		return controlador;
	}
	
	@Transactional
	public void addViagem(Viagem v){
//		getDao().persist(v);
//		getDao().flush();
		
		//lembrar d tirar isso aqui
		viagem.add(v);
	}
	
	@Transactional
	public List<Viagem> getViagens(){
		
		//return getDao().findAllByClassName("Viagem");
		
		return viagem;
	}

	public Usuario getUsuario(String email) {
		for(Usuario u: usuarios){
			if(u.getEmail().equals(email)){
				return u;
			}
		}
		return null;
	}

	@Transactional
	public void addUsuario(Usuario u) {
//		getDao().persist(u);
//		getDao().flush();
		
		//lembrar d remover isso!
		usuarios.add(u);
	}

	public Viagem getViagem(String local) {
		for(Viagem v: viagem){
			if(v.getLocal().equals(local)){
				return v;
			}
		}
		return null;
	}

	public void participarViagem(Usuario u, Viagem v2,String senha) {
		if(v2 != null){
			for(Viagem v: viagem){
				if(v.getLocal().equals(v2.getLocal()) && v.getSenha().equals(senha)){
					v.addPessoaNaViagem(u,"");
				}
			}
		}
	}
	
	public static GenericDAO getDao() {
		return dao;
	}

	public static void setDao(GenericDAO dao) {
		ControladorDeBD.dao = dao;
	}

}
