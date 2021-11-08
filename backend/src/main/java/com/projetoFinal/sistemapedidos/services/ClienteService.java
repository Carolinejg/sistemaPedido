package com.projetoFinal.sistemapedidos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetoFinal.sistemapedidos.dto.ClienteDTO;
import com.projetoFinal.sistemapedidos.entities.Cliente;
import com.projetoFinal.sistemapedidos.repositories.ClienteRepository;

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

}
