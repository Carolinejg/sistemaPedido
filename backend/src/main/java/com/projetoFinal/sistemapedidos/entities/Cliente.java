package com.projetoFinal.sistemapedidos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JoinColumn(nullable = false)
	private ClienteTipo tipo;
	@JoinColumn(nullable = false)
	private String documento;
	@JoinColumn(nullable = false)
	private String nome;
	
	public Cliente(int id, ClienteTipo tipo, String documento, String nome) {
		this.id = id;
		this.tipo = tipo;
		this.documento = documento;
		this.nome = nome;
	}

	public Cliente() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClienteTipo getTipo() {
		return tipo;
	}

	public void setTipo(ClienteTipo tipo) {
		this.tipo = tipo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
