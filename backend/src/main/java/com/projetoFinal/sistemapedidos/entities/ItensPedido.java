package com.projetoFinal.sistemapedidos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itens_pedido")
public class ItensPedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne //itens pode ter muitos pedidos
	@JoinColumn(nullable = false,name="id_pedido")//campo obrigatorio
    private Pedido pedido;
	@ManyToOne //produto pode ter muitos pedidos
	@JoinColumn(nullable = false,name="id_produto")//campo obrigatorio
    private Produto produto;
	@JoinColumn(nullable = false)
	private int quantidade;
	@JoinColumn(nullable = false)
	private double valorTotal;
	
	public ItensPedido(int id, Pedido pedido, Produto produto, int quantidade, double valorTotal) {
		this.id = id;
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
	}

	public ItensPedido() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	

}
