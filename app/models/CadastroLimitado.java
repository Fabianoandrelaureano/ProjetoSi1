package models;

public class CadastroLimitado implements CadastroNaViagem {

	@Override
	public void addParticipanteNaViagem(Viagem viagem, Usuario usuario,String senha) {
		if(viagem.getSenha().equals(senha)){
			viagem.getParticipantes().add(usuario);
		}
		
	}

}
