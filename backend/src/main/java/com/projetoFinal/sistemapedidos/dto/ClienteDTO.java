package com.projetoFinal.sistemapedidos.dto;

import java.io.Serializable;

import com.projetoFinal.sistemapedidos.entities.Cliente;
import com.projetoFinal.sistemapedidos.entities.ClienteTipo;

public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private ClienteTipo tipo;
	private String documento;
	private String nome;
	
	public ClienteDTO() {


	}

	public ClienteDTO(int id, ClienteTipo tipo, String documento, String nome) {
		this.id = id;
		this.tipo = tipo;
		this.documento = documento;
		this.nome = nome;
	}

	public ClienteDTO(Cliente entity) {
		this.id=entity.getId();
		this.tipo=entity.getTipo();
		this.documento=entity.getDocumento();
		this.nome=entity.getNome();
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
