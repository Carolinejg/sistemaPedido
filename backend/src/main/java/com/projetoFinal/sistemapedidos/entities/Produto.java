package com.projetoFinal.sistemapedidos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="produto")
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JoinColumn(nullable = false)//campo obrigatorio
	private String descricao;
	@JoinColumn(nullable = false)
	private String unidadeMedida;
	@JoinColumn(nullable = false)
	private String valorUnitario;
	@JoinColumn(nullable = false)
	private ProdutoStatus status;
	
	public Produto(int id, String descricao, String unidadeMedida, String valorUnitario, ProdutoStatus status) {
		this.id = id;
		this.descricao = descricao;
		this.unidadeMedida = unidadeMedida;
		this.valorUnitario = valorUnitario;
		this.status = status;
	}

	public Produto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public ProdutoStatus getStatus() {
		return status;
	}

	public void setStatus(ProdutoStatus status) {
		this.status = status;
	}
	
	
}
