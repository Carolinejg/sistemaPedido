package com.projetoFinal.sistemapedidos.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetoFinal.sistemapedidos.dto.ClienteDTO;
import com.projetoFinal.sistemapedidos.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	@Autowired //injetando
	private ClienteService service;
	
	@PostMapping
	public ResponseEntity<ClienteDTO> insert(@RequestBody ClienteDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri(); //inserindo e repondendo no cabeçalho de resposta
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>>findAll(){
		List<ClienteDTO>list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
}
