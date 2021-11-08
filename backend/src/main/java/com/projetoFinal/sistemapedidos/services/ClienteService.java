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

import com.projetoFinal.sistemapedidos.dto.ClienteDTO;
import com.projetoFinal.sistemapedidos.entities.Cliente;
import com.projetoFinal.sistemapedidos.repositories.ClienteRepository;
import com.projetoFinal.sistemapedidos.services.exceptions.DatabaseException;
import com.projetoFinal.sistemapedidos.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;

	@Transactional
	public ClienteDTO insert(ClienteDTO dto) {
		Cliente entity = new Cliente();
		entity.setDocumento(dto.getDocumento());
		entity.setNome(dto.getNome());
		entity.setTipo(dto.getTipo());
		entity = repository.save(entity);
		
		return new ClienteDTO(entity);
	}
	
	public List<ClienteDTO> findAll() {
		List<Cliente> list= repository.findAll();
		List<ClienteDTO>listDto = new ArrayList<>();
		
		for(Cliente cob : list) {
			listDto.add(new ClienteDTO(cob));
		}
		
		return listDto;
	}
	
	public ClienteDTO findById(int id) {
		Optional<Cliente>obj = repository.findById(id);// optional evita trabalhar com valor nulo
		Cliente entity = obj.orElseThrow(()->new ResourceNotFoundException("Entidade não encontrada"));
		 
		return new ClienteDTO(entity);
	}
	
	@Transactional
	public ClienteDTO update(int id, ClienteDTO dto) {
		try {
			Cliente entity = repository.getOne(id);
			entity.setDocumento(dto.getDocumento());
			entity.setNome(dto.getNome());
			entity.setTipo(dto.getTipo());
			entity = repository.save(entity);
			return new ClienteDTO(entity);
			
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
