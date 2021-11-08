package com.projetoFinal.sistemapedidos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetoFinal.sistemapedidos.dto.ProdutoDTO;
import com.projetoFinal.sistemapedidos.entities.Produto;
import com.projetoFinal.sistemapedidos.repositories.ProdutoRepository;
import com.projetoFinal.sistemapedidos.services.exceptions.DatabaseException;
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
	
	@Transactional
	public ProdutoDTO update(int id, ProdutoDTO dto) {
		try {
			Produto entity = repository.getOne(id);
			entity.setDescricao(dto.getDescricao());
			entity.setStatus(dto.getStatus());
			entity.setUnidadeMedida(dto.getUnidadeMedida());
			entity.setValorUnitario(dto.getValorUnitario());
			entity = repository.save(entity);
			
			
			return new ProdutoDTO(entity);
			
		}catch(EntityNotFoundException e) {
			throw new  ResourceNotFoundException("Id não encontrado "+id);
		}
	}


	public void delete(int id) {
		try {
			repository.deleteById(id);
			
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado "+id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade do banco");
		}
		
	}

}
