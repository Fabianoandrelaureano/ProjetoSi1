package controllers;

import static play.data.Form.form;

import java.util.List;

import models.Usuario;
import models.Usuario;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.registro;

public class Registro extends Controller {
	
	
	
	private static ControladorDeBD controlador = ControladorDeBD.getInstance();

    public static Result show() {
        return ok(registro.render());
    }
    
	public static Result registrar() throws Exception {
		DynamicForm requestData = Form.form().bindFromRequest();
    	
		String nome = requestData.get("nome");
		String email = requestData.get("email");
		String senha = requestData.get("pass");
		
		Usuario u;
		u = new Usuario(nome, email,senha);
		//registroForm.bindFromRequest().get();
    	
		if (!validate(u.getEmail())) {
			flash("fail", "Email já está em uso");
            return badRequest(registro.render());
        } else {
        	controlador.addUsuario(u);
            return redirect(
                routes.Application.index()
            );
        }
    }
	
	private static boolean validate(String email) {
		Usuario u = controlador.getUsuario(email);
		return u == null;
	}

}
