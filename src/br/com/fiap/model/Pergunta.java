package br.com.fiap.model;

import java.util.ArrayList;
import java.util.List;

public class Pergunta {
	
	private long id;
	private String questao;
	private int ordem;
	private int tipo;
	
	private List<ItemEscolha> itens;
	
	public Pergunta() {
		this.itens = new ArrayList<>();
	}
	
	public Pergunta(String questao, int ordem, int tipo) {
		this();
		this.questao = questao;
		this.ordem = ordem;
		this.tipo = tipo;
		
	}

	public void addItemEscolha(ItemEscolha ie) {
		this.itens.add(ie);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestao() {
		return questao;
	}

	public void setQuestao(String questao) {
		this.questao = questao;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public List<ItemEscolha> getItens() {
		return itens;
	}

	public void setItens(List<ItemEscolha> itens) {
	this.itens = itens;}

	public String aplicacao() {
		String s = ordem + ") " + questao + "\n";
		if (tipo == 1 || tipo == 2) {
			for(int i = 0; i < itens.size(); i++) {
				ItemEscolha ie = itens.get(i);
				s = s + ie.getOrdem() + " - " + ie.getDescricao() + "\n";
			}
		}
		return s;
	}

	
}
