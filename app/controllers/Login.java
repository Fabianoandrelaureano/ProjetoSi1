package controllers;

import static play.data.Form.form;

import java.util.List;

import models.Usuario;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.DynamicForm;
import play.data.Form;
import views.html.login;

public class Login extends Controller {
	
	private static ControladorDeBD controlador = ControladorDeBD.getInstance();
	private static Form<Usuario> loginForm = form(Usuario.class).bindFromRequest();

	
    public static Result show() {
//		if (session().get("user") != null) {
//			return redirect(routes.Application.index());
//		}
        return ok(login.render());
    }
	
	
	public static Result logout() {
		session().clear();
		return ok(login.render());
	}
    

	public static Result authenticate() {
		
		DynamicForm requestData = Form.form().bindFromRequest();
		
		//Usuario u = loginForm.bindFromRequest().get();
		
		String email = requestData.get("email");
		String senha = requestData.get("pass");

        if (!validate(email, senha)) {
        	flash("fail", "Email ou Senha Inválidos");
        	return badRequest(login.render());
        } else {
        	Usuario user = controlador.getUsuario(email);
            session().clear();
            session("user", user.getNome());
            session("email",user.getEmail());
            return redirect(
                routes.Application.index()
            );
        }
    }
	
	private static boolean validate(String email, String senha) {
		Usuario u = controlador.getUsuario(email);
		return u.getSenha().equals(senha);
	}
}