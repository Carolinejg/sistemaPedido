package com.projetoFinal.sistemapedidos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetoFinal.sistemapedidos.dto.PedidoDTO;
import com.projetoFinal.sistemapedidos.entities.Pedido;
import com.projetoFinal.sistemapedidos.repositories.PedidoRepository;


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

}
