package com.ariel.sistemcar.controller;

import com.ariel.sistemcar.domain.Clientes;
import com.ariel.sistemcar.domain.Presupuestos;
import com.ariel.sistemcar.repository.PresupuestosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/presupuestos")
public class PresupuestosController {

    @Autowired
    private PresupuestosRepository presupuestosRepository;

    @PostMapping("/new")
    public Boolean createPresupuesto(@RequestBody Presupuestos presupuesto) {
        try {
            if(!presupuesto.getTitular().isEmpty()) {
                presupuestosRepository.save(presupuesto);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @GetMapping("/all")
    public List<Presupuestos> getPresupuestos() {
        return presupuestosRepository.findAll();
    }

    @GetMapping("/activos-filtro/{search}")
    public ResponseEntity<List<Presupuestos>> getAllPresupuestosByFiltro(@PathVariable String search) {

        if (search != null) {
            search = search.trim();
        }
        if ((search != null) && !search.equalsIgnoreCase("undefined") && search.length() > 0) {
            search = "%" + search.toLowerCase() + "%";
            List<Presupuestos> presupuestosActivos = presupuestosRepository.findPresupuestosByFiltro(search);
            return ResponseEntity.ok().body(presupuestosActivos);
        } else {
            List<Presupuestos> presupuestosActivos = presupuestosRepository.findAll();
            return ResponseEntity.ok().body(presupuestosActivos);
        }

    }

}
