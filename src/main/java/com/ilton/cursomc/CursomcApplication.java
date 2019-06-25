/*
Nome do autor: Ilton Batista da Silva Júnior
Data de criação do arquivo: 14/06/2019
Objetivo sucinto do programa: Cria uma aplicação spring
Referência ao enunciado/origem do exercício: https://www.udemy.com/spring-boot-ionic
*/

package com.ilton.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ilton.cursomc.domain.Categoria;
import com.ilton.cursomc.domain.Produto;
import com.ilton.cursomc.repositories.CategoriaRepository;
import com.ilton.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	//Para fazer manipulação no banco de dados
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Colocar aqui a instanciação dos objetos
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");

		
		Produto p1 = new Produto(null,"Computador", 2000.00);
		Produto p2 = new Produto(null,"escrivaninha", 10000.00);		
		
		/*
		 Salvar os produtos em categorias
		 devidas para cada uma
		 */
		cat1.getProdutos().addAll(Arrays.asList(p1,p2));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		/*
		 * Salvar as categorias
		 * devidas para cada um produto 
		 */
		p1.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		
		/*
		Chamar uma operação para salvar no banco de dados
		Savar uma lista no banco de dados
		*/
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2));
	}

}
