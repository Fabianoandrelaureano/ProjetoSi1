package models;

import java.util.ArrayList;
import java.util.List;

public class Viagem {
	
	private String local, data, descricao;
	
	private List<Usuario> pessoasNaViagem;
	
	public Viagem(String local, String data, String descricao) {
		this.setLocal(local);
		this.setData(data);
		this.setDescricao(descricao);
		pessoasNaViagem = new ArrayList<Usuario>();
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getLocal() {
		return local;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getNumeroDePessoasNaViagem() {
		return pessoasNaViagem.size();
	}

	public void addPessoaNaViagem(Usuario u) {
		pessoasNaViagem.add(u);		
	}
	
	public List getParticipantes(){
		return pessoasNaViagem;
	}
	

}
