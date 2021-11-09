package com.projetoFinal.sistemapedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoFinal.sistemapedidos.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
