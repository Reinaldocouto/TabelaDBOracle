package br.com.fiap.model;

import java.time.LocalDate;

public class Mensagem {

  private long id;
  private String assunto;
  private String destinatario;
  private String remetente;
  private LocalDate data;
  private String conteudo;
  private int prioridade;

  public Mensagem() {
    this.id = 0;
    this.assunto = "";
    this.destinatario = "";
    this.remetente = "";
    this.data = LocalDate.now();
    this.conteudo = "";
    this.prioridade = 1;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAssunto() {
    return this.assunto;
  }

  public void setAssunto(String assunto) {
    this.assunto = assunto;
  }

  public String getDestinatario() {
    return this.destinatario;
  }

  public void setDestinatario(String destinatario) {
    this.destinatario = destinatario;
  }

  public String getRemetente() {
    return this.remetente;
  }

  public void setRemetente(String remetente) {
    this.remetente = remetente;
  }

  public LocalDate getData() {
    return this.data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public String getConteudo() {
    return this.conteudo;
  }

  public void setConteudo(String conteudo) {
    this.conteudo = conteudo;
  }

  public int getPrioridade() {
    return this.prioridade;
  }

  public void setPrioridade(int prioridade) {
    this.prioridade = prioridade;
  }

}

/*
 * Criação da tabela no banco de dados Oracle
 * 
 * CREATE TABLE tbl_mensagem (
  id NUMBER(10) NOT NULL,
  assunto VARCHAR2(255) NOT NULL,
  destinatario VARCHAR2(255) NOT NULL,
  remetente VARCHAR2(255) NOT NULL,
  data DATE NOT NULL,
  conteudo VARCHAR2(255) NOT NULL,
  prioridade NUMBER(1) NOT NULL,
  CONSTRAINT pk_mensagem PRIMARY KEY (id)
);

 * */
