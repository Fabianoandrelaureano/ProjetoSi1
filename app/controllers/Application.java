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
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	//private static GenericDAO dao = new GenericDAOImpl();
	private static ControladorDeBD controlador = ControladorDeBD.getInstance();
	
    public static Result index() {
    	if(session().get("user") == null){
    		return ok(login.render());
    	}    	

    	Viagem v = new Viagem("local","data","descricao");
        return ok(index.render("Your new application is ready.", controlador));
    }
    
    public static Result participarViagem(){
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
    	String local = requestData.get("local");
    	String senha = requestData.get("senha");
    	
    	Usuario u = controlador.getUsuario(session().get("email"));
    	Viagem v = controlador.getViagem(local);
    	
    	controlador.participarViagem(u,v,senha);
    	return ok(index.render(" ", controlador));
    }
    
    public static Result criaViagem(){
    	return ok(cadastroViagens.render("Your new application is ready."));
    }

    public static Result novaViagem(){
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
    	String local = requestData.get("local");
    	String data = requestData.get("data");
    	String descricao = requestData.get("descricao");
    	String dia = requestData.get("dia");
    	String mes = requestData.get("mes");
    	String ano = requestData.get("ano");
    	String senha = requestData.get("senha");
    	
    	data = dia + "/" + mes + "/" + ano;
    	
    	Viagem v = new Viagem(local,data,descricao);
    	v.setCadastro(new CadastroAberto(), senha);
    	controlador.addViagem(v);
    	
    	return ok(index.render("=p",controlador));
    }
    
//    public static GenericDAO getDao() {
//		return dao;
//	}
//
//	public static void setDao(GenericDAO dao) {
//		Application.dao = dao;
//	}
}
