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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Viagem")
public class Viagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
//	@Column
	private String local;
	
//	@Column
	private String data;
	
//	@Column
	private String descricao;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn  
	private List<Usuario> pessoasNaViagem;
	
	
//	private CadastroNaViagem cadastro;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private Usuario organizador;
	
//	@Column
	private String senha;
	
	public Viagem(){
		this.local = null;
		this.descricao = null;
		this.data = null;
		this.organizador = null;
	}
	
	public Viagem(String local, String data, String descricao, Usuario organizador) {
		this.setLocal(local);
		this.setData(data);
		this.setDescricao(descricao);
		pessoasNaViagem = new ArrayList<Usuario>();
//		cadastro = new CadastroAberto();
		senha = "";
		this.organizador = organizador;
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
		if (pessoasNaViagem.isEmpty()) {
			pessoasNaViagem.add(u);
//			cadastro.addParticipanteNaViagem(this, u, senha);
		}else {
			if(!pessoasNaViagem.contains(u)){
				pessoasNaViagem.add(u);
			}
		}
//		pessoasNaViagem.add(u);		
	}
	
	public List<Usuario> getParticipantes(){
		return pessoasNaViagem;
	}
	
//	public void setCadastro(CadastroNaViagem cadastro,String senha){
//		this.cadastro = cadastro;
//		this.senha = senha;
//	}
	
	public String getSenha(){
		return this.senha;
	}

	public Usuario getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Usuario organizador) {
		this.organizador = organizador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void removeParticipante(Usuario usuario) {
		this.pessoasNaViagem.remove(usuario);
	}

}
