package com.stefanini.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.stefanini.dao.GenericDAO;
import com.stefanini.dto.JogadorDTO;
import com.stefanini.entity.Jogador;

@ApplicationScoped
public class JogadorRepository extends GenericDAO<Jogador, Long> {
	
	@Transactional
    public JogadorDTO criaUsuario(Jogador jogador) {
        this.save(jogador);
        return new JogadorDTO(jogador);
    }
	
	public JogadorDTO listaUsuarioLogin(String nick, String senha) {
		
    	Jogador jogadorLogado = this.findByLogin(nick, senha);
    			
    	return jogadorLogado != null ? new JogadorDTO(jogadorLogado) : null;
    }
	
	public JogadorDTO buscaUsuarioRetornaDTO(String name) {
        Jogador usuario = findByName(name);
        return usuario != null ? new JogadorDTO(usuario) : null;
    }
}
