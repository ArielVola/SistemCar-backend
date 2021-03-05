package com.ariel.sistemcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ariel.sistemcar.domain.Clientes;
import com.ariel.sistemcar.domain.Proveedores;

public interface ProveedoresRepository extends JpaRepository<Proveedores, Long> {

	
	@Query(
	        value="SELECT proveedores.* FROM proveedores WHERE lower(proveedores.nombre) LIKE lower(:search)",
	        nativeQuery = true)
	    List<Proveedores> findProveedoresByFiltro(@Param(value="search") String search);
	
}
