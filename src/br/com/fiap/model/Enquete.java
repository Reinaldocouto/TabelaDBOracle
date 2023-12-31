package br.com.fiap.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Enquete {
	
	private long id;	
	private String nome;	
	private String descricao;	
	private LocalDate dataCriacao;
	private String criador;
	
	//para resolver a agregação
	private List<Pergunta> perguntas;
	
	public Enquete() {
		this.perguntas = new ArrayList<>();
	}
	
	public Enquete(String nome, String criador) {
		this();
		this.nome = nome;
		this.criador = criador;
	}

	public void addPergunta(Pergunta p) {
		this.perguntas.add(p);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getCriador() {
		return criador;
	}

	public void setCriador(String criador) {
		this.criador = criador;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public int size() {
		return this.perguntas.size();
	}

	
}
