package com.projetoFinal.sistemapedidos.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//para ser auto incremento
	public int id;
	@ManyToOne //cliente pode ter muitos pedidos
	@JoinColumn(nullable = false,name="id_cliente")//campo obrigatorio
    public Cliente cliente;
	@JoinColumn(nullable = false)
	private Instant data;  
	@JoinColumn(nullable = false)
	private String rua;
	@JoinColumn(nullable = false)
	private String bairro;
	@JoinColumn(nullable = false)
	private String cidade;
	@JoinColumn(nullable = false)
	private String cep;
	
	public Pedido(int id, Cliente cliente, Instant data, String rua, String bairro, String cidade, String cep) {
		this.id = id;
		this.cliente = cliente;
		this.data = data;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
	}

	public Pedido() {
		
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
