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
import com.ilton.cursomc.domain.Cidade;
import com.ilton.cursomc.domain.Cliente;
import com.ilton.cursomc.domain.Endereco;
import com.ilton.cursomc.domain.Estado;
import com.ilton.cursomc.domain.Produto;
import com.ilton.cursomc.domain.enums.TipoCliente;
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
		
		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");
		Estado estado3 = new Estado(null, "Goias");

		
		Cidade cidade1 = new Cidade(null, "Uberlandia", estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
		Cidade cidade3 = new Cidade(null, "Sante Helena de Goais", estado3);
		Cidade cidade4 = new Cidade(null, "Goiania", estado3);
		
		Cliente cli1 = new Cliente(null,"Maria Silva","mari@gmail.com","3265409876", TipoCliente.PESSOAFISICA);
		//Adicion ando telefone para o cliente
		cli1.getTelefones().addAll(Arrays.asList("32324013","996708213"));
		
		/*Integer id, String logradouro, String numero, String complemento, 
		String bairro, String cep,
		Cliente cliente, Cidade cidade*/
		Endereco e1 = new Endereco(null,"Rua Jose alves Garcias","1612","Apto-02","Brasil","38400668", cli1,cidade1);
		Endereco e2 = new Endereco(null,"Rua Clarimundo carneiro","1356","Apto-07","Aparecida","38400668", cli1,cidade2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
	}

}
