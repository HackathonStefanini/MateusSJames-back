package com.stefanini.dto;

public class StefamonDTO {

    private Long id;
    private String nome;
    private Integer vida;
    private Integer ataque;
    private Integer defesa;
    private Integer inteligencia;
    private Integer poder;
    private Integer velocidade;
    private String urlFoto;

    public StefamonDTO() {
    }
    public StefamonDTO(Long id, String nome, Integer vida, Integer ataque, Integer defesa, Integer inteligencia,
			Integer poder, Integer velocidade, String urlFoto) {
		super();
		this.id = id;
		this.nome = nome;
		this.vida = vida;
		this.ataque = ataque;
		this.defesa = defesa;
		this.inteligencia = inteligencia;
		this.poder = poder;
		this.velocidade = velocidade;
		this.urlFoto = urlFoto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	public Integer getAtaque() {
		return ataque;
	}

	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}

	public Integer getDefesa() {
		return defesa;
	}

	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}

	public Integer getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Integer inteligencia) {
		this.inteligencia = inteligencia;
	}

	public Integer getPoder() {
		return poder;
	}

	public void setPoder(Integer poder) {
		this.poder = poder;
	}

	public Integer getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Integer velocidade) {
		this.velocidade = velocidade;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
}
