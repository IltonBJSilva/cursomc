/*
Nome do autor: Ilton Batista da Silva Júnior
Data de criação do arquivo: 14/06/2019
Objetivo sucinto do programa: Cria um servlet para testar aplicação
Referência ao enunciado/origem do exercício: https://www.udemy.com/spring-boot-ionic
*/

package com.ilton.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ilton.cursomc.domain.Categoria;
import com.ilton.cursomc.services.CategoriaService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	// Acessando o serviço
	@Autowired
	private CategoriaService service;

	// Vai buscar por categoria/id no caso vai por id mostrando apenas as
	// informações de tal produto
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
