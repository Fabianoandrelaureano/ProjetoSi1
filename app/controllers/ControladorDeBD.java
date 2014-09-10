package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Viagem;

public class ControladorDeBD {
	
	private static ControladorDeBD controlador;
	
	private List<Viagem> viagem = new ArrayList<Viagem>();
	
	private ControladorDeBD(){
		
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

}
