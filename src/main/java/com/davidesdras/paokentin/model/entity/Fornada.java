package com.davidesdras.paokentin.model.entity;

import java.time.LocalDateTime;

public class Fornada {
  private Integer id;
  private Integer paoId;
  private LocalDateTime dataHoraInicio;
  private LocalDateTime dataHoraFim;
  private Pao pao;

  public Pao getPao() {
    return pao;
  }

  public void setPao(Pao pao) {
    this.pao = pao;
  }

  public LocalDateTime getDataHoraFim() {
    return dataHoraFim;
  }

  public void setDataHoraFim(LocalDateTime dataHoraFim) {
    this.dataHoraFim = dataHoraFim;
  }

  public Fornada(Integer id, Integer paoId, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, Pao pao) {
    this.id = id;
    this.paoId = paoId;
    this.dataHoraInicio = dataHoraInicio;
    this.dataHoraFim = dataHoraFim;
    this.pao = pao;
  }

  public Fornada() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getPaoId() {
    return paoId;
  }

  public void setPaoId(Integer paoId) {
    this.paoId = paoId;
  }

  public LocalDateTime getDataHoraInicio() {
    return dataHoraInicio;
  }

  public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
    this.dataHoraInicio = dataHoraInicio;
  }
}
