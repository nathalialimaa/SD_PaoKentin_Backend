package com.davidesdras.paokentin.model.repository;

import java.sql.SQLException;
import java.util.List;

import com.davidesdras.paokentin.model.entity.Fornada;
import com.davidesdras.paokentin.model.entity.Pao;

public class FornadaRepository implements GenericRepository<Fornada, Integer> {

  @Override
  public void create(Fornada t) throws SQLException {
    var sql = "INSERT INTO fornada (pao_id, data_inicio, data_fim) VALUES (?, ?, ?)";
    var stmt = ConnectionManager.getNewConnection().prepareStatement(sql);
    stmt.setInt(1, t.getPaoId());
    stmt.setObject(2, t.getDataHoraInicio());
    stmt.setObject(3, t.getDataHoraFim());
    stmt.execute();
  }

  @Override
  public void update(Fornada t) {
    try {
      var sql = "UPDATE fornada SET pao_id = ?, data_inicio = ? WHERE id = ?";
      var stmt = ConnectionManager.getNewConnection().prepareStatement(sql);
      stmt.setInt(1, t.getPaoId());
      stmt.setObject(2, t.getDataHoraInicio());
      stmt.setInt(3, t.getId());
      stmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Fornada read(Integer key) {
    Fornada fornada = null;
    try {
      var sql = "SELECT * FROM fornada WHERE id = ?";
      var stmt = ConnectionManager.getNewConnection().prepareStatement(sql);
      stmt.setInt(1, key);
      var rs = stmt.executeQuery();
      if (rs.next()) {
        Integer paoId = rs.getInt("pao_id");
        com.davidesdras.paokentin.model.entity.Pao pao = null;
        try {
          pao = new com.davidesdras.paokentin.model.repository.PaoRepository().read(paoId);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        fornada = new Fornada(
            rs.getInt("id"),
            paoId,
            rs.getTimestamp("data_inicio").toLocalDateTime(),
            rs.getTimestamp("data_fim").toLocalDateTime(),
            pao);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return fornada;
  }

  @Override
  public void delete(Integer key) {
    try {
      var sql = "DELETE FROM fornada WHERE id = ?";
      var stmt = ConnectionManager.getNewConnection().prepareStatement(sql);
      stmt.setInt(1, key);
      stmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Fornada> readAll() {
    List<Fornada> lista = new java.util.ArrayList<>();
    try {
      var conn = ConnectionManager.getNewConnection();
      var sql = "SELECT * FROM fornada";
      try (var stmt = conn.prepareStatement(sql)) {
        var rs = stmt.executeQuery();
        while (rs.next()) {
          Integer paoId = rs.getInt("pao_id");
          Pao pao = null;
          try {
            pao = new PaoRepository().read(paoId);
          } catch (Exception ex) {
            ex.printStackTrace();
          }
          lista.add(new Fornada(
              rs.getInt("id"),
              paoId,
              rs.getTimestamp("data_inicio").toLocalDateTime(),
              rs.getTimestamp("data_fim").toLocalDateTime(),
              pao));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return lista;
  }

}
