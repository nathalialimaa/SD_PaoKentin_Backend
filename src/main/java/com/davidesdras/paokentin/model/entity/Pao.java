
package com.davidesdras.paokentin.model.entity;

public class Pao {
  private Integer id;
  private String nome;
  private String descricao;
  private Integer tempoPreparo; // segundos
  private String cor;

  public Pao() {}

  public Pao(Integer id, String nome, String descricao, Integer tempoPreparo, String cor) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.tempoPreparo = tempoPreparo;
    this.cor = cor;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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

  public Integer getTempoPreparo() {
    return tempoPreparo;
  }

  public void setTempoPreparo(Integer tempoPreparo) {
    this.tempoPreparo = tempoPreparo;
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }
}
