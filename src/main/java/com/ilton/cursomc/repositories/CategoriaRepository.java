/* 
 * Nome do autor: Ilton Batista da Silva Junior 
 * Data de criação do arquivo: 18/06/2019 
 * Objetivo sucinto do programa: Classe capaz de acessar o banco de dados e fazer as consultas acessar os dados da tabela categoria
 * Referencia ao enunciado/origem do exerc�cio: https://www.udemy.com/spring-boot-ionic/learn/lecture/8090536#overview
 
EXPLICAÇÃO
* Realiza operações de acesso a dados
* Pode buscar salvar alterar deletar
* Referente ao objeto Categoria
* Que por sua vez ta mapeado com a tabela categoria
*/

package com.ilton.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ilton.cursomc.domain.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Integer>{	
}