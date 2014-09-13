package controllers;

import java.util.ArrayList;

import models.CadastroAberto;
import models.Usuario;
import models.Viagem;
//import models.dao.GenericDAO;
//import models.dao.GenericDAOImpl;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	//private static GenericDAO dao = new GenericDAOImpl();
	private static ControladorDeBD controlador = ControladorDeBD.getInstance();
	
	@Transactional
    public static Result index() {
    	if(session().get("user") == null){
    		return ok(login.render());
    	}    	
    	Usuario u = new Usuario("nome","email","senha");
    	Viagem v = new Viagem("local","data","descricao",u);
    	
    	v.addPessoaNaViagem(u, null);
        return ok(index.render("Your new application is ready.", controlador));
    }
    
	@Transactional
    public static Result participarViagem(){
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
    	String local = requestData.get("local");
    	String senha = requestData.get("senha");
    	
    	Usuario u = controlador.getUsuario(session().get("email"));
    	Viagem v = controlador.getViagem(local);
    	
    	controlador.participarViagem(u,v,senha);
    	return ok(index.render(" ", controlador));
    }
    
	@Transactional
    public static Result infoViagem(){
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
    	String local = requestData.get("local");
    	Viagem v = controlador.getViagem(local);
    	
    	return ok(maisInfo.render(v));
    }
    
	@Transactional
    public static Result criaViagem(){
    	return ok(cadastroViagens.render("Your new application is ready."));
    }
	
	@Transactional
    public static Result novaViagem(){
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
    	String local = requestData.get("local");
    	String data = requestData.get("data");
    	String descricao = requestData.get("descricao");
    	String dia = requestData.get("dia");
    	String mes = requestData.get("mes");
    	String ano = requestData.get("ano");
    	String senha = requestData.get("senha");
    	
    	Usuario user = controlador.getUsuario(session().get("email"));
    	
    	data = dia + "/" + mes + "/" + ano;
    	
    	Viagem v = new Viagem(local,data,descricao,user);
//    	v.setCadastro(new CadastroAberto(), senha);
    	controlador.addViagem(v);
    	
    	return ok(index.render("=p",controlador));
    }
    
	@Transactional
    public static Result editarViagem(){
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
    	String local = requestData.get("local");
    	String descricao = requestData.get("descricao");
    	
    	Viagem v = controlador.getViagem(local);
    	v.setDescricao(descricao);
    	
    	return ok(maisInfo.render(v));
    }
    
	@Transactional
    public static Result desistirViagem(){
    	DynamicForm request = Form.form().bindFromRequest();
    	
    	String local = request.get("local");
    	
    	Viagem v = controlador.getViagem(local);
    	
    	v.removeParticipante(controlador.getUsuario(session().get("email")));
    	
    	return ok(index.render("Your new application is ready.", controlador));
    
    }
    
//    public static GenericDAO getDao() {
//		return dao;
//	}
//
//	public static void setDao(GenericDAO dao) {
//		Application.dao = dao;
//	}
}
