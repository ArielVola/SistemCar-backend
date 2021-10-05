package com.ariel.sistemcar.repository;

import com.ariel.sistemcar.domain.Presupuestos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PresupuestosRepository extends JpaRepository<Presupuestos, Long> {
    @Query(
            value="SELECT presupuestos.* FROM presupuestos WHERE lower(presupuestos.patente) LIKE lower(:search) OR lower(presupuestos.titular) LIKE lower(:search)",
            nativeQuery = true)
    List<Presupuestos> findPresupuestosByFiltro(@Param(value="search") String search);


}
