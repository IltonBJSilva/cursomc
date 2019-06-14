/*
Nome do autor: Ilton Batista da Silva Júnior
Data de criação do arquivo: 14/06/2019
Objetivo sucinto do programa: Cria um servlet para testar aplicação
Referência ao enunciado/origem do exercício: https://www.udemy.com/spring-boot-ionic
*/

package com.ilton.cursomc.resources;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ilton.cursomc.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria categoria1 = new Categoria(1,"Informatica");
		Categoria categoria2 = new Categoria(2,"Escritorio");

		List<Categoria> lista = new ArrayList<>();
		lista.add(categoria1);
		lista.add(categoria2);

		return lista;
	}
}
