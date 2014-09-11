package models;

public class CadastroAberto implements CadastroNaViagem {

	@Override
	public void addParticipanteNaViagem(Viagem viagem, Usuario usuario,
			String senha) {
		viagem.getParticipantes().add(usuario);
		
	}

}
