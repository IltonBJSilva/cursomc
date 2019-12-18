/*
Nome do autor: Ilton Batista da Silva Júnior
Data de criação do arquivo: 14/06/2019
Objetivo sucinto do programa: Cria um servlet para testar aplicação
Referência ao enunciado/origem do exercício: https://www.udemy.com/spring-boot-ionic
*/

package com.ilton.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ilton.cursomc.domain.Categoria;
import com.ilton.cursomc.dto.CategoriaDTO;
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
	public ResponseEntity<Categoria> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//@RequestBody faz o json ser convertido para java automaticamente
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){
		
		obj = service.insert(obj);
		//Ele pega essa URL localhost:8080/categorias e adiciona mais coisas na frente o ID
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		//Ja gera o 201 que informa que foi criado passando como paramentro o uri
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) throws ObjectNotFoundException{
		//Metodos para atualizar
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException{
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> list = service.findAll();
		//
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> findPage(
			/*
			  Essa anotação impede de inves de /categorias/page/0/20/ e assim por diante
			  e inves disso, o melhor e assim:			  
			  /categorias/page?page0&linesPerPage=20
			   *
			   * localhost:8080//categorias/page?linesPerPage=3&page=1&direction=DESC
			*/
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			//O defaultValue = 24 e melhor para vai encaixar direito 
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage, 
			//O defaultValue e para ordernar pelo oque, por exemplo eu quero odernar por nome
			@RequestParam(value="orderBy", defaultValue = "nome") String orderBy, 
			//O defaultValue dessa ja e para saber em qual direção se e ASC(crescente) ou DESC(decresente)
			@RequestParam(value="direction", defaultValue = "ASC") String direction){
		Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);
		//
		Page<CategoriaDTO> listDto  = list.map(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(listDto );
	}
}
