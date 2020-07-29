package com.escola.escola.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_turma")
public class Turma {
	//Criando os Atributos
	
	@Id //Chave primaria da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment do id
	private long id;
	
	@NotNull // atributo não pode ser nulo
	private String turma;
	
	private boolean ativo;
	
	//Gerando os Getters e Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	

}
