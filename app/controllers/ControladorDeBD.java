package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Usuario;
import models.Viagem;
//import play.db.jpa.*;

public class ControladorDeBD {
	
	//private static GenericDAO dao = new GenericDAOImpl();
	
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
					v.addPessoaNaViagem(u,null);
				}
			}
		}
	}
	
//	public static GenericDAO getDao() {
//		return dao;
//	}
//
//	public static void setDao(GenericDAO dao) {
//		ControladorDeBD.dao = dao;
//	}

}
