package models;

public class Usuario {
	
private String nome, email, senha;
	
	public Usuario(String nome, String email, String senha) {
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

}
