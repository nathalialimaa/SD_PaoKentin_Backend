package com.davidesdras.paokentin.model.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.davidesdras.paokentin.model.entity.Pao;
import com.davidesdras.paokentin.model.entity.Fornada;

@Repository
public class RepositoryFacade {
	private GenericRepository<Pao, Integer> paoRepository = null;
	private GenericRepository<Fornada, Integer> fornadaRepository = null;

	public RepositoryFacade() {
		this.paoRepository = new PaoRepository();
		this.fornadaRepository = new FornadaRepository();
	}

	// Métodos para Pao
	public void create(Pao pao) throws SQLException {
		this.paoRepository.create(pao);
	}

	public void update(Pao pao) {
		this.paoRepository.update(pao);
	}

	public Pao readPao(int codigo) {
		return this.paoRepository.read(codigo);
	}

	public void deletePao(int codigo) {
		this.paoRepository.delete(codigo);
	}

	public List<Pao> readAllPao() {
		return this.paoRepository.readAll();
	}

	// Métodos para Fornada
	public void create(Fornada fornada) throws SQLException {
		this.fornadaRepository.create(fornada);
	}

	public void update(Fornada fornada) {
		this.fornadaRepository.update(fornada);
	}

	public Fornada readFornada(int codigo) {
		return this.fornadaRepository.read(codigo);
	}

	public void deleteFornada(int codigo) {
		this.fornadaRepository.delete(codigo);
	}

	public List<Fornada> readAllFornada() {
		return this.fornadaRepository.readAll();
	}
}
