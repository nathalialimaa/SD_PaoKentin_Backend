package com.davidesdras.paokentin.model.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.davidesdras.paokentin.model.entity.Pao;

public final class PaoRepository implements GenericRepository<Pao, Integer> {
	public PaoRepository() {
	}

	@Override
	public void create(Pao t) {
		String sql = "INSERT INTO pao (nome, descricao, tempo_preparo, cor) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = ConnectionManager.getCurrentConnection().prepareStatement(sql);
			stmt.setString(1, t.getNome());
			stmt.setString(2, t.getDescricao());
			stmt.setInt(3, t.getTempoPreparo());
			stmt.setString(4, t.getCor());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Pao t) {
		try {
			String sql = "UPDATE pao SET nome = ?, descricao = ?, tempo_preparo = ?, cor = ? WHERE id = ?";
			var stmt = ConnectionManager.getCurrentConnection().prepareStatement(sql);
			stmt.setString(1, t.getNome());
			stmt.setString(2, t.getDescricao());
			stmt.setInt(3, t.getTempoPreparo());
			stmt.setString(4, t.getCor());
			stmt.setInt(5, t.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Pao read(Integer key) {
		try {
			String sql = "SELECT * FROM pao WHERE id = ?";
			var stmt = ConnectionManager.getCurrentConnection().prepareStatement(sql);
			stmt.setInt(1, key);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return mapResultSetToPao(rs);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public void delete(Integer key) {
		try {
			String sql = "DELETE FROM pao WHERE id = ?";
			var stmt = ConnectionManager.getCurrentConnection().prepareStatement(sql);
			stmt.setInt(1, key);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Pao> readAll() {
		String sql = "select * from pao";

		List<Pao> lPaes = new ArrayList<>();

		try {

			PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

			ResultSet result = pstm.executeQuery();

			Pao nPao = null;

			while (result.next()) {
				nPao = new Pao();
				nPao.setId(result.getInt("id"));
				nPao.setNome(result.getString("nome"));
				nPao.setDescricao(result.getString("descricao"));
				nPao.setTempoPreparo(result.getInt("tempo_preparo"));
				nPao.setCor(result.getString("cor"));

				lPaes.add(nPao);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lPaes;
	}

	private Pao mapResultSetToPao(ResultSet rs) throws SQLException {
		Pao pao = new Pao();
		pao.setId(rs.getInt("id"));
		pao.setNome(rs.getString("nome"));
		pao.setDescricao(rs.getString("descricao"));
		pao.setTempoPreparo(rs.getInt("tempo_preparo"));
		pao.setCor(rs.getString("cor"));
		return pao;
	}
}
