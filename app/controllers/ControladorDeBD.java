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
	
	private ControladorDeBD(){
	
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
		
		persist(v);

	}
	
	@Transactional
	public List<Viagem> getViagens(){
		
		return getDao().findAllByClassName("Viagem");
		
	}

	@Transactional
	public Usuario getUsuario(String email) {
		List<Usuario> usuarios = getDao().findAllByClassName("Usuario");
		for(Usuario u: usuarios){
			if(u.getEmail().equals(email)){
				return u;
			}
		}
		return null;
	}

	@Transactional
	public void addUsuario(Usuario u) {
		persist(u);
	}

	@Transactional
	public Viagem getViagem(String local) {
		List<Viagem> viagem = getDao().findAllByClassName("Viagem");
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
			List<Viagem> viagem = getDao().findAllByClassName("Viagem");
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
	
	@Transactional
	private static <T> Object persist(Object object) {
		List<T> result = dao.findAllByClassName(object.getClass().getSimpleName());
		if (!result.contains(object)) {
			dao.persist(object);
			dao.flush();
		}
		return getObjectBD(object);
	}

	@Transactional
	private static <T> Object getObjectBD(Object object) {
		List<T> result = dao.findAllByClassName(object.getClass().getSimpleName());
		for (Object o : result) {
			if(o.equals(object)){
				return o;
			}
		}
		return null;
	}

}
