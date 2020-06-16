package com.algaworks.algamoneyapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algamoneyapi.model.Categoria;
import com.algaworks.algamoneyapi.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	/**
	 * Tipo: GET
	 * Parâmetros: vazio 
	 * Endereço: http://localhost:8080/categorias
	 *  
	 */
	@GetMapping
	public List<Categoria> listar(){
		return categoriaRepository.findAll();
	}
	
	
	
}
