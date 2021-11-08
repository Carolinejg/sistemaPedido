package com.projetoFinal.sistemapedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoFinal.sistemapedidos.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
