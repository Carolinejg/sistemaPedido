package com.projetoFinal.sistemapedidos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetoFinal.sistemapedidos.dto.ProdutoDTO;
import com.projetoFinal.sistemapedidos.entities.Produto;
import com.projetoFinal.sistemapedidos.repositories.ProdutoRepository;
import com.projetoFinal.sistemapedidos.services.exceptions.ResourceNotFoundException;


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


	public List<ProdutoDTO> findAll() {
		List<Produto> list= repository.findAll();
		List<ProdutoDTO>listDto = new ArrayList<>();
		
		for(Produto cob : list) {
			listDto.add(new ProdutoDTO(cob));
		}
		
		return listDto;
	}


	public ProdutoDTO findById(int id) {
		Optional<Produto>obj = repository.findById(id);// optional evita trabalhar com valor nulo
		Produto entity = obj.orElseThrow(()->new ResourceNotFoundException("Entidade não encontrada"));
		 
		return new ProdutoDTO(entity);
	}

}
