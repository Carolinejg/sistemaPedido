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

import com.projetoFinal.sistemapedidos.dto.PedidoDTO;
import com.projetoFinal.sistemapedidos.entities.Pedido;
import com.projetoFinal.sistemapedidos.repositories.PedidoRepository;
import com.projetoFinal.sistemapedidos.services.exceptions.DatabaseException;
import com.projetoFinal.sistemapedidos.services.exceptions.ResourceNotFoundException;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;

	@Transactional
	public PedidoDTO insert(PedidoDTO dto) {
		Pedido entity = new Pedido();
		entity.setCliente(dto.getCliente());
		entity.setData(dto.getData());
		entity.setRua(dto.getRua());
		entity.setBairro(dto.getBairro());
		entity.setCidade(dto.getCidade());
		entity.setCep(dto.getCep());
		entity = repository.save(entity);
		
		return new PedidoDTO(entity);
	}
	
	public List<PedidoDTO> findAll() {
		List<Pedido> list= repository.findAll();
		List<PedidoDTO>listDto = new ArrayList<>();
		
		for(Pedido cob : list) {
			listDto.add(new PedidoDTO(cob));
		}
		
		return listDto;
	}
	
	public PedidoDTO findById(int id) {
		Optional<Pedido>obj = repository.findById(id);// optional evita trabalhar com valor nulo
		Pedido entity = obj.orElseThrow(()->new ResourceNotFoundException("Entidade não encontrada"));
		 
		return new PedidoDTO(entity);
	}
	
	@Transactional
	public PedidoDTO update(int id, PedidoDTO dto) {
		try {
			Pedido entity = repository.getOne(id);
			entity.setCliente(dto.getCliente());
			entity.setData(dto.getData());
			entity.setRua(dto.getRua());
			entity.setBairro(dto.getBairro());
			entity.setCidade(dto.getCidade());
			entity.setCep(dto.getCep());
			entity = repository.save(entity);
			return new PedidoDTO(entity);
			
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
