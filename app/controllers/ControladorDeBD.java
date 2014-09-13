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
			addUsuario(user);
		}
		Viagem[] travels = {new Viagem("Coxixola","09/10/2014", "Terra dos coxixos.", users[0]), new Viagem("Caverna de Gelo", "11/11/2014", "Se escondendo do frio.", users[0]), new Viagem("Nova York", "20/11/2014", "Ida ate a estatua da liberdade.", users[1]), 
				new Viagem("Los Angeles", "23/12/2014", "Viagem com o grupo vindo de SP.", users[2]), new Viagem("Alasca", "24/12/2014", "Pra todos que querem curtir o Inverno do Alasca.", users[2]), new Viagem("Tangamandapia", "28/12/2014", "Visita especial a casa de Jaiminho, o Carteiro.", users[3]), 
				new Viagem("Cidade do Mexico", "28/12/2014", "Comer uns tacos, conhecer outra cultura, quem quiser ir e so chegar junto.", users[4]), new Viagem("Polo Norte", "28/12/2014", "Visita e homenagem a Papai Noel.", users[5]), new Viagem("Antartida", "30/12/2014", "Viagem de estudo, o tema sao as auroras.", users[6]), 
				new Viagem("Iraque", "04/01/2015", "Viagem com o grupo de Eng. de Petroleo vindo de Osasco.", users[7]), new Viagem("Coreia do Norte", "07/02/2015", "Visita aos pontos turisticos que marcaram a ditadura Norte Coreana.", users[12]), new Viagem("Siberia", "10/02/2015", "Viagem do grupo de estudos de Biologia.", users[14]), 
				new Viagem("Madagascar", "27/04/2015", "Safari em Madagascar, pra comprar uma entrada ligue para 9988-0552.", users[15]), new Viagem("Ilhas Maldivas", "29/04/2015", "Festa na Ilha, com bandas locais.", users[16]), new Viagem("Falklands", "15/05/2015", "Visita para analise do clima e principais pontos da guerra.", users[17]), 
				new Viagem("Ilhas Canarias", "18/09/2015", "Passeio nas praias da Ilha.", users[18]), new Viagem("Dubai", "20/10/2015", "Hospedagem em Hotel e visita aos principais pontos da cidade.", users[18]), new Viagem("Islandia", "01/11/2015", "Pesquisa sobre a presente atividade vulcanica no local.", users[18]), 
				new Viagem("Irlanda", "23/01/2016", "Visita simples, ao chegarmos decidiremos pra onde ir.", users[20]), new Viagem("Luxemburgo", "23/01/2016", "Conferencia sobre Seguranca da Informacao Org. Vanderlei.", users[20]), new Viagem("Cazaquistao", "25/03/2016", "Viagem e discussao sobre a influencia da antiga URSS.", users[25]), 
				new Viagem("Turcomenistao", "10/05/2016", "Vamos para um vilarejo pouco conhecido, passaremos 1 semana.", users[29]), new Viagem("Cingapura", "11/05/2016", "Conferencia sobre construcoes, estudantes de Eng. Civil apenas.", users[30]), new Viagem("Kansas City", "02/12/2016", "Ida ao Road Party.", users[33]), 
				new Viagem("Nova Zelandia", "08/02/2017", "Excursao a Nova Zelandia, informacoes: 5544-0134", users[34]), new Viagem("Monte Rushmore", "14/05/2017", "Visita ao famoso monte Rushmore.", users[34]), new Viagem("Yellowstone Park", "17/07/2017", "Viagem de estudos o tema sera: A atividade tectonica em Yellowstone.", users[35]), 
				new Viagem("Miami Beach", "07/06/2017", "Pra todos que quiserem curtir um Sol, e so chega junto.", users[37]), new Viagem("London Eye", "18/07/2017", "Passeio na famosa Roda Gigante londrina.", users[39]), new Viagem("Niagara Falls", "05/09/2017", "Todos descendo de barril, vamos bater o recorde do Guiness", users[39])};
		for (Viagem travel:travels){
			addViagem(travel);
		}	
	}
	
	@Transactional
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

	@Transactional
	public Usuario getUsuario(String email) {
//		List<Usuario> usuarios = getDao().findAllByClassName("Usuario");
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

	@Transactional
	public Viagem getViagem(String local) {
//		List<Viagem> viagem = getDao().findAllByClassName("Viagem");
		for(Viagem v: viagem){
			if(v.getLocal().equals(local)){
				return v;
			}
		}
		return null;
	}

	@Transactional
	public void participarViagem(Usuario u, Viagem v2,String senha) {
		if(v2 != null){
//			List<Viagem> viagem = getDao().findAllByClassName("Viagem");
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
