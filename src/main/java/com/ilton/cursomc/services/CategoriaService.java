/*
Nome do autor: Ilton Batista da Silva Júnior
Data de criação do arquivo: 18/06/2019
Objetivo sucinto do programa: Class de serviço
Referência ao enunciado/origem do exercício: https://www.udemy.com/spring-boot-ionic
*/
package com.ilton.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilton.cursomc.domain.Categoria;
import com.ilton.cursomc.repositories.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {

	// O serviço por sua vez vai acessar o objeto de acesso a dados
	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}