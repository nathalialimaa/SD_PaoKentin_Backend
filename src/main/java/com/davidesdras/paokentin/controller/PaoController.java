package com.davidesdras.paokentin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidesdras.paokentin.model.entity.Fornada;
import com.davidesdras.paokentin.model.entity.Pao;
import com.davidesdras.paokentin.model.repository.RepositoryFacade;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/paes")
@CrossOrigin(value="http://127.0.0.1:5500",allowCredentials = "true")
public class PaoController {

	@Autowired
	private RepositoryFacade repositoryFacade;

	@GetMapping("")
	public ResponseEntity<List<Pao>> listarPaes() {
		return ResponseEntity.ok(repositoryFacade.readAllPao());
	}

	@PostMapping
	public ResponseEntity<Pao> cadastrarPao(@RequestBody Pao pao) throws java.sql.SQLException {
		repositoryFacade.create(pao);
		return ResponseEntity.ok(pao);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pao> detalhePao(@PathVariable Integer id) {
		Pao pao = repositoryFacade.readPao(id);
		if (pao == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pao);
	}

	@PostMapping("/fornadas/{paoId}")
	public ResponseEntity<Void> cadastrarFornada(@PathVariable Integer paoId) throws java.sql.SQLException {
		var fornada = new Fornada();
		fornada.setPaoId(paoId);
		Pao pao = this.repositoryFacade.readPao(paoId);
		int tempoPreparoSeg = pao.getTempoPreparo();
		LocalDateTime now = LocalDateTime.now();
		fornada.setDataHoraInicio(now);
		fornada.setDataHoraFim(now.plusSeconds(tempoPreparoSeg));
		repositoryFacade.create(fornada);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/fornadas")
	public ResponseEntity<List<Fornada>> listarFornadas() {
		return ResponseEntity.ok(repositoryFacade.readAllFornada());
	}
}
