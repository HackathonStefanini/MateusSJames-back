package com.stefanini.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.stefanini.dto.JogadorDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    
    @NotEmpty(message = "E necessario informar o nome do jogador")
    @Column(unique = true)
    private String nickname;
    
    @NotEmpty(message = "E necessario informar a senha do jogador")
    @Column
    private String password;
    
    @Column(columnDefinition = "DECIMAL(10,2) DEFAULT '0.00'")
    private BigDecimal saldo;


    @ManyToMany
    @JoinTable(name = "Jogador_Stefamon",
            joinColumns = {@JoinColumn(name = "IdJogador")},
            inverseJoinColumns = {@JoinColumn(name = "IdStefamon")})
    private List<Stefamon> stefamons = new ArrayList<>();

    public Jogador() {
    }

	public Jogador(JogadorDTO jogador) {
		this.id = jogador.getId();
		this.nickname = jogador.getNickname();
		this.password = jogador.getPassword();
		this.saldo = jogador.getSaldo();
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

	public List<Stefamon> getStefamons() {
		return stefamons;
	}

	public void setStefamons(List<Stefamon> stefamons) {
		this.stefamons = stefamons;
	}
    
    
}
