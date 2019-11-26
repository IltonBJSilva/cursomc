package com.ilton.cursomc.domain.enums;

//Implementanção sofisticada de um tipo enumerado para ter o controle total
//Do codigo atribuido a cada valor da enumação.
public enum EstadoPagamento {
	PENDENTE(1,"Pendente"),
	QUITADO(2,"Quitado"),
	CANCELADO(3,"Cancelado");
	
	private int cod;
	private String descricao;
	
	//Construtor para armazenar os valores dos enums
	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;

	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	//Converte para um enum
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		//Todo objeto X nos valores possiveis do tipo cliente
		//Um for que percorre todos os valores possiveis ou seja pessoa fisica e juridica
		for(EstadoPagamento x : EstadoPagamento.values()) {
			//Se o Integer cod que tou passando for igual o X que estou procurando
			//Retorna o X ele vai fazer essa busca. 
			if(cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("ID Inválido"+cod);
	}
}
