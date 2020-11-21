package com.ariel.sistemcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ariel.sistemcar.domain.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long>  {

	@Query(
	        value="SELECT clientes.* FROM clientes WHERE lower(clientes.patente) LIKE lower(:search)",
	        nativeQuery = true)
	    List<Clientes> findClientesByFiltro(@Param(value="search") String search);
	
}
