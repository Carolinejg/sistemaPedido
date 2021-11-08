package com.projetoFinal.sistemapedidos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetoFinal.sistemapedidos.dto.ProdutoDTO;
import com.projetoFinal.sistemapedidos.entities.Produto;
import com.projetoFinal.sistemapedidos.repositories.ProdutoRepository;


@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;
	
	
	@Transactional
	public ProdutoDTO insert(ProdutoDTO dto) {
		Produto entity = new Produto();
		entity.setDescricao(dto.getDescricao());
		entity.setUnidadeMedida(dto.getUnidadeMedida());
		entity.setValorUnitario(dto.getValorUnitario());
		entity.setStatus(dto.getStatus());
		entity = repository.save(entity);
		
		return new ProdutoDTO(entity);
		
	}

}
