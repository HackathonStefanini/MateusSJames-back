package com.stefanini.dto;

import java.math.BigDecimal;

import com.stefanini.entity.Jogador;

public class JogadorDTO {
	private Long id;

    private String nickname;

    private String password;

    private BigDecimal saldo;

	public JogadorDTO(Jogador jogador) {
		this.id = jogador.getId();
		this.nickname = jogador.getNickname();
		this.password = jogador.getPassword();
		this.saldo = jogador.getSaldo();
	}

	public JogadorDTO(Long id, String nickname, String password, BigDecimal saldo) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.password = password;
		this.saldo = saldo;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
    
    
}
