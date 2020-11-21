package com.ariel.sistemcar.controller;

import java.util.List;
import java.util.Optional;

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

import com.ariel.sistemcar.domain.Proveedores;
import com.ariel.sistemcar.repository.ProveedoresRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/proveedores")
public class ProveedoresController {
	
	@Autowired
	ProveedoresRepository proveedoresRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getProveedores() {
		try {
			return new ResponseEntity<List<Proveedores>>(proveedoresRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(Boolean.FALSE, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{idProveedor}")
    public Optional<Proveedores> getProveedorById(@PathVariable Long idProveedor) {
		
			Optional<Proveedores> proveedor = proveedoresRepository.findById(idProveedor);
			return proveedor;
    }
	
	@DeleteMapping("/{idProveedor}")
	public Boolean deleteProveedorById(@PathVariable Long idProveedor) {
		try {
			proveedoresRepository.deleteById(idProveedor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@PostMapping("/new")
	public Boolean createProveedor(@RequestBody Proveedores proveedor) {
		try {
			if(!proveedor.getNombre().isEmpty()) {
				proveedoresRepository.save(proveedor);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	@PutMapping("/update")
	public Boolean updateProveedor(@RequestBody Proveedores proveedor) {
		try {
			if(!proveedor.getNombre().isEmpty()) {
				proveedoresRepository.save(proveedor);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
