/*
Nome do autor: Ilton Batista da Silva Júnior
Data de criação do arquivo: 14/06/2019
Objetivo sucinto do programa: Cria uma aplicação spring
Referência ao enunciado/origem do exercício: https://www.udemy.com/spring-boot-ionic
*/

package com.ilton.cursomc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ilton.cursomc.domain.Categoria;
import com.ilton.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	//Para fazer manipulação no banco de dados
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Colocar aqui a instanciação dos objetos
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		Categoria cat3 = new Categoria(null,"Industria");
		Categoria cat4 = new Categoria(null,"Hospital");
		
		/*
		Chamar uma operação para salvar no banco de dados
		Savar uma lista no banco de dados
		*/
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4));		
	}

}
