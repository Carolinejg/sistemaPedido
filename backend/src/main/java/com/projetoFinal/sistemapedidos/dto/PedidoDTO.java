package com.projetoFinal.sistemapedidos.dto;

import java.io.Serializable;
import java.time.Instant;

import com.projetoFinal.sistemapedidos.entities.Cliente;
import com.projetoFinal.sistemapedidos.entities.Pedido;

public class PedidoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public int id;
	public Cliente cliente;
	private Instant data;  
	private String rua;
	private String bairro;
	private String cidade;
	private String cep;
	
	
	public PedidoDTO() {
		
	}


	public PedidoDTO(int id, Instant data, String rua, String bairro, String cidade, String cep) {
		this.id = id;
		this.data = data;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
	}


	public PedidoDTO(Pedido entity) {
		this.id = entity.getId();
		this.cliente = entity.getCliente();
		this.data = entity.getData();
		this.rua = entity.getRua();
		this.bairro = entity.getBairro();
		this.cidade = entity.getCidade();
		this.cep = entity.getCep();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Instant getData() {
		return data;
	}


	public void setData(Instant data) {
		this.data = data;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

}
