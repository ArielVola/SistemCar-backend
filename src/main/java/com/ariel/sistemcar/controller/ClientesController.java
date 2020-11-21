package com.ariel.sistemcar.controller;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ariel.sistemcar.domain.Clientes;
import com.ariel.sistemcar.repository.ClientesRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/clientes")
public class ClientesController {

	@Autowired
	ClientesRepository clientesRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getClientes() {
		try {
			return new ResponseEntity<List<Clientes>>(clientesRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(Boolean.FALSE, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{idCliente}")
    public Optional<Clientes> getClienteById(@PathVariable Long idCliente) {
		
			Optional<Clientes> cliente = clientesRepository.findById(idCliente);
			return cliente;
    }
	
	@DeleteMapping("/{idCliente}")
	public Boolean deleteClienteById(@PathVariable Long idCliente) {
		try {
			clientesRepository.deleteById(idCliente);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@PostMapping("/new")
	public Boolean createCliente(@RequestBody Clientes cliente) {
		try {
			if(!cliente.getNombre().isEmpty()) {
				clientesRepository.save(cliente);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	@PutMapping("/update")
	public Boolean updateCliente(@RequestBody Clientes cliente) {
		try {
			if(!cliente.getNombre().isEmpty()) {
				clientesRepository.save(cliente);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
}
