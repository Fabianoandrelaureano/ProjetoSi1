package controllers;

import java.util.ArrayList;

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
    	Viagem v = new Viagem("local","data","descricao");

        return ok(index.render("Your new application is ready.", controlador));
    }
    
    public static Result criaViagem(){
    	return ok(cadastroViagens.render("Your new application is ready."));
    }

    public static Result novaViagem(){
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
    	String local = requestData.get("local");
    	String data = requestData.get("data");
    	String descricao = requestData.get("descricao");
    	
    	Viagem v = new Viagem(local,data,descricao);
    	
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
