package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


public class Viagem {
	
	
	private Long id;
	
	
	private String local;
	
	
	private String data;
	
	
	private String descricao;
	
	 
	private List<Usuario> pessoasNaViagem;
	
	private CadastroNaViagem cadastro;
	
	@Column
	private String senha;
	
	public Viagem(){
		
	}
	
	public Viagem(String local, String data, String descricao) {
		this.setLocal(local);
		this.setData(data);
		this.setDescricao(descricao);
		pessoasNaViagem = new ArrayList<Usuario>();
		cadastro = new CadastroAberto();
		senha = null;
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

	public void addPessoaNaViagem(Usuario u,String senha) {
		cadastro.addParticipanteNaViagem(this, u, senha);
		//pessoasNaViagem.add(u);		
	}
	
	public List getParticipantes(){
		return pessoasNaViagem;
	}
	
	public void setCadastro(CadastroNaViagem cadastro,String senha){
		this.cadastro = cadastro;
		this.senha = senha;
	}
	
	public String getSenha(){
		return this.senha;
	}

}
