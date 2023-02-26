package com.stefanini.service;

import com.stefanini.dto.JogadorDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.handlers.BadRequestHandler;
import com.stefanini.repository.JogadorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@ApplicationScoped
public class JogadorService {

	@Inject
    JogadorRepository jogadorRepository;

	public JogadorDTO salvar(JogadorDTO jogador) throws BadRequestHandler{
		Jogador jogadorRecebido = new Jogador(jogador);
		verificaAtributosDoUsuario(jogadorRecebido);
		 encriptaSenha(jogadorRecebido);
        return jogadorRepository.criaUsuario(jogadorRecebido);
    }
	
	public JogadorDTO login(Map<String, ?> nick) throws BadRequestHandler {
		try {
			Map<String, ?> loginBody = nick;
			System.out.println(loginBody.get("nickname"));
			String passBody = loginBody.get("password").toString();
			String password = new String(Base64.getEncoder().encode(passBody.getBytes()));
			JogadorDTO jogadorOn = jogadorRepository.listaUsuarioLogin(loginBody.get("nickname").toString(), password);
			
			return jogadorOn;
		} catch (Exception e){
			throw new BadRequestHandler("Credenciais incorretas, verifique e tente novamente");
		}
		
	}

    public Jogador pegarPorId(Long id) {
        var jogador = jogadorRepository.findById(id);
        if(Objects.isNull(jogador)) {
            throw new RegraDeNegocioException("Ocorreu um erro ao buscar o Jogador de id " + id, Response.Status.NOT_FOUND);
        }
        return jogador;
    }

    public void alterar(Jogador jogador) {
        jogadorRepository.update(jogador);
    }

    public void deletar(Long id) {
        jogadorRepository.delete(id);
    }

    public List<Jogador> listarTodos() {
        return jogadorRepository.listAll();
    }
    
    private static void descriptaSenha(JogadorDTO user) {
        String password = new String(Base64.getDecoder().decode(user.getPassword().getBytes()));
        user.setPassword(password);
    }
    
    private static void encriptaSenha(Jogador user) {
        String password = new String(Base64.getEncoder().encode(user.getPassword().getBytes()));
        user.setPassword(password);
        System.out.println(user.getPassword());
    }
    
    private static void verificaSenha(Jogador jogador) throws BadRequestHandler {
        if (jogador.getPassword().length() < 4 || jogador.getPassword().length() > 10) {
            throw new BadRequestHandler("Senha deve ter mais de 4 e menos de 10 caracteres");
        } else if (jogador.getPassword().isEmpty()){
        	throw new BadRequestHandler("Senha do Jogador não pode ser vazia");
        }
    }
    
    private static void verificarNome(Jogador jogador) throws BadRequestHandler{
    	if(jogador.getNickname().isEmpty()) {
    		throw new BadRequestHandler("Nome do Jogador não pode ser vazio");
    	}
    }
    
    private void verificarSeNickNameExiste(Jogador jogador) throws BadRequestHandler {
    	JogadorDTO jogadorExists = jogadorRepository.buscaUsuarioRetornaDTO(jogador.getNickname());
    	if(jogadorExists != null) {
    		throw new BadRequestHandler("Nickname já em utilizacao");
    	}
    }    
    private void verificaAtributosDoUsuario(Jogador usuario) throws BadRequestHandler {
        verificarNome(usuario);
        //verificarSeNickNameExiste(usuario);
        verificaSenha(usuario);
    }

}
