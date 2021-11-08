package com.projetoFinal.sistemapedidos.dto;

import java.io.Serializable;
import com.projetoFinal.sistemapedidos.entities.Produto;
import com.projetoFinal.sistemapedidos.entities.ProdutoStatus;

public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String descricao;
	private String unidadeMedida;
	private String valorUnitario;
	private ProdutoStatus status;
	
	
	
	public ProdutoDTO() {
	}


	public ProdutoDTO(int id, String descricao, String unidadeMedida, String valorUnitario, ProdutoStatus status) {
		this.id = id;
		this.descricao = descricao;
		this.unidadeMedida = unidadeMedida;
		this.valorUnitario = valorUnitario;
		this.status = status;
	}
	
	
	public ProdutoDTO(Produto entity) {
		this.id=entity.getId();
		this.descricao=entity.getDescricao();
		this.unidadeMedida=entity.getUnidadeMedida();
		this.valorUnitario=entity.getValorUnitario();
		this.status=entity.getStatus();
		
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
