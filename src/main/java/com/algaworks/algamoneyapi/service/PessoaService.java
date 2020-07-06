package com.algaworks.algamoneyapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoneyapi.model.Pessoa;
import com.algaworks.algamoneyapi.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	Pessoa pessoaSalva;
	
	public Pessoa atualizar(Long codigo, Pessoa pessoa) {

		pessoaSalva = buscarPessoaPeloCodigo(codigo);
		
		//copia pessoa para pessoa salva ignorando o atributo código
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		
		return pessoaRepository.save(pessoaSalva);
		
	}


	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		pessoaSalva = buscarPessoaPeloCodigo(codigo);
		pessoaSalva.setAtivo(ativo);
		pessoaRepository.save(pessoaSalva);
		
	}

	private Pessoa buscarPessoaPeloCodigo(Long codigo) {
		
		Pessoa pessoaSalva = pessoaRepository.findOne(codigo);
		
		if(pessoaSalva ==  null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return pessoaSalva;
		
	}
}
