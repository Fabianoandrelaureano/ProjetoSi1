import play.*;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.db.jpa.JPA;
import models.*;

public class Global extends GlobalSettings{
	
	private static GenericDAO dao = new GenericDAOImpl();

	@Override
	public void onStart(Application app) {
		Logger.info("Aplicação inicializada...");
		
		JPA.withTransaction(new play.libs.F.Callback0() {
			
			@Override
			public void invoke() throws Throwable {
	    		
				Usuario[] users = {new Usuario("Ítalo", "italo.lins@ccc.ufcg.edu.br", "123"), new Usuario("Fabiano", "fabiano.laureano@ccc.ufcg.edu.br", "123"), new Usuario("Wellington", "wellington.araujo.silva@ccc.ufcg.edu.br", "123"), new Usuario("Nazareno", "nazareno@gmail.com", "123"), new Usuario("Gustavo", "gustavo@gmail.com", "123"), 
						new Usuario("Jose", "jose@gmail.com", "123"), new Usuario("Carlos", "carlos@gmail.com", "123"), new Usuario("Antonio", "antonio@gmail.com", "123"), new Usuario("Vitor", "vitor@gmail.com", "123"), new Usuario("Pedro", "pedro@gmail.com", "123"), 
						new Usuario("Joao", "joao@outlook.com", "123"), new Usuario("Maria", "maria@outlook.com", "123"), new Usuario("Marta", "marta@outlook.com", "123"), new Usuario("Carla", "carla@outlook.com", "123"), new Usuario("Enzo", "enzo@outlook.com", "123"), 
						new Usuario("Ricardo", "ricardo@gmail.com", "123"), new Usuario("Batista", "batista@gmail.com", "123"), new Usuario("Hugo", "hugo@gmail.com", "123"), new Usuario("Silvano", "silvano@gmail.com", "123"), new Usuario("Vilma", "vilma@gmail.com", "123"), 
						new Usuario("Fred", "fred@outlook.com", "123"), new Usuario("Barney", "barney@outlook.com", "123"), new Usuario("Sidney", "sidney@outlook.com", "123"), new Usuario("Kimberly", "kymberly@outlook.com", "123"), new Usuario("Seya", "seya@outlook.com", "123"), 
						new Usuario("Mario", "mario@gmail.com", "123"), new Usuario("Vegeta", "vegeta@gmail.com", "123"), new Usuario("Goku", "goku@gmail.com", "123"), new Usuario("Madinbu", "madinbu@gmail.com", "123"), new Usuario("Capile", "capile@gmail.com", "123"),  
						new Usuario("Dalton", "dalton@outlook.com", "123"), new Usuario("Wilkerson", "wilkerson@outlook.com", "123"), new Usuario("Leandro", "leandro@outlook.com", "123"), new Usuario("Leonardo", "leonardo@outlook.com", "123"), new Usuario("Chitaozinho", "chitaozinho@outlook.com", "123"), 
						new Usuario("Xororo", "xororo@gmail.com", "123"), new Usuario("Pele", "pele@gmail.com", "123"), new Usuario("Ronaldo", "ronaldo@gmail.com", "123"), new Usuario("Naoli", "naoli@gmail.com", "123"), new Usuario("Nemlerei", "nemlerei@gmail.com", "123")}; 		
				for (Usuario user:users){
//					addUsuario(user);
					dao.persist(user);
					dao.flush();
				}
				Viagem[] travels = {new Viagem("Coxixola","09/Outubro/2014", "Terra dos coxixos.", users[0], "123"), new Viagem("Caverna de Gelo", "11/Novembro/2014", "Se escondendo do frio.", users[0], "123"), new Viagem("Nova York", "20/Novembro/2014", "Ida ate a estatua da liberdade.", users[1], "123"), 
						new Viagem("Los Angeles", "23/Dezembro/2014", "Viagem com o grupo vindo de SP.", users[2], "123"), new Viagem("Alasca", "24/Dezembro/2014", "Pra todos que querem curtir o Inverno do Alasca.", users[2], "123"), new Viagem("Tangamandapia", "28/Dezembro/2014", "Visita especial a casa de Jaiminho, o Carteiro.", users[3], "123"), 
						new Viagem("Cidade do Mexico", "28/Dezembro/2014", "Comer uns tacos, conhecer outra cultura, quem quiser ir e so chegar junto.", users[4], "123"), new Viagem("Polo Norte", "28/Dezembro/2014", "Visita e homenagem a Papai Noel.", users[5], "123"), new Viagem("Antartida", "30/Dezembro/2014", "Viagem de estudo, o tema sao as auroras.", users[6], "123"), 
						new Viagem("Iraque", "04/Janeiro/2015", "Viagem com o grupo de Eng. de Petroleo vindo de Osasco.", users[7], "123"), new Viagem("Coreia do Norte", "07/Fevereiro/2015", "Visita aos pontos turisticos que marcaram a ditadura Norte Coreana.", users[12], "123"), new Viagem("Siberia", "10/Fevereiro/2015", "Viagem do grupo de estudos de Biologia.", users[14], "123"), 
						new Viagem("Madagascar", "27/Abril/2015", "Safari em Madagascar, pra comprar uma entrada, ligue para 9988-0552.", users[15], "123"), new Viagem("Ilhas Maldivas", "29/Abril/2015", "Festa na Ilha, com bandas locais.", users[16], "123"), new Viagem("Falklands", "15/Maio/2015", "Visita para analise do clima e principais pontos da guerra.", users[17], "123"), 
						new Viagem("Ilhas Canarias", "18/Setembro/2015", "Passeio nas praias da Ilha.", users[18]), new Viagem("Dubai", "20/Outubro/2015", "Hospedagem em Hotel e visita aos principais pontos da cidade.", users[18]), new Viagem("Islandia", "01/Novembro/2015", "Pesquisa sobre a presente atividade vulcanica no local.", users[18]), 
						new Viagem("Irlanda", "23/Janeiro/2016", "Visita simples, ao chegarmos decidiremos pra onde ir.", users[20]), new Viagem("Luxemburgo", "23/Janeiro/2016", "Conferencia sobre Seguranca da Informacao Org. Vanderlei.", users[20]), new Viagem("Cazaquistao", "25/Março/2016", "Viagem e discussao sobre a influencia da antiga URSS.", users[25]), 
						new Viagem("Turcomenistao", "10/Maio/2016", "Vamos para um vilarejo pouco conhecido, passaremos 1 semana.", users[29]), new Viagem("Cingapura", "11/Maio/2016", "Conferencia sobre construcoes, estudantes de Eng. Civil apenas.", users[30]), new Viagem("Kansas City", "02/Dezembro/2016", "Ida ao Road Party.", users[33]), 
						new Viagem("Nova Zelandia", "08/Fevereiro/2017", "Excursao a Nova Zelandia, informacoes: 5544-0134", users[34]), new Viagem("Monte Rushmore", "14/Maio/2017", "Visita ao famoso monte Rushmore.", users[34]), new Viagem("Yellowstone Park", "17/Julho/2017", "Viagem de estudos o tema sera: A atividade tectonica em Yellowstone.", users[35]), 
						new Viagem("Miami Beach", "07/Junho/2017", "Pra todos que quiserem curtir um Sol, e so chega junto.", users[37]), new Viagem("London Eye", "18/Julho/2017", "Passeio na famosa Roda Gigante londrina.", users[39]), new Viagem("Niagara Falls", "05/Setembro/2017", "Todos descendo de barril, vamos bater o recorde do Guiness", users[39])};
				for (Viagem travel:travels){
//					addViagem(travel);
					
					dao.persist(travel);
					dao.flush();
				}
				//Adicionando pessoas nas viagens
				for (int i=0; i<15; i++){
					for (int j=0; j<15; j++){
						travels[i].addPessoaNaViagem(users[j], "123");
					}
				}
				for (int i=15; i < travels.length; i++){
					for (int j=0; j<15; j++){
						travels[i].addPessoaNaViagem(users[j], "");
					}
				}	    			    		
			}
		});
	}
	
	@Override
	public void onStop(Application app) {
		Logger.info("Aplicação desligada...");
	}
}
