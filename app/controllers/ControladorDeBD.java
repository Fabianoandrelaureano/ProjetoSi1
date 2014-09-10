package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Usuario;
import models.Viagem;

public class ControladorDeBD {
	
	private static ControladorDeBD controlador;
	private Viagem v = new Viagem("local","data","descricao");
	private List<Viagem> viagem = new ArrayList<Viagem>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private ControladorDeBD(){
		viagem.add(v);
	}
	
	public static ControladorDeBD getInstance(){
		if(controlador == null){
			controlador = new ControladorDeBD();
		}
		return controlador;
	}
	
	public void addViagem(Viagem v){
		viagem.add(v);
	}
	
	public List<Viagem> getViagens(){
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

	public void addUsuario(Usuario u) {
		usuarios.add(u);
	}

}
