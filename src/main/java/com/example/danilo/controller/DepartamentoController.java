package com.example.danilo.controller;

import com.example.danilo.entity.Departamento;
import com.example.danilo.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<Departamento> save(@RequestBody Departamento novoDepartamento){
        Departamento departamento = departamentoService.save(novoDepartamento);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> findAll(){
        List<Departamento> departamentoList = departamentoService.findAll();
        return departamentoList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(departamentoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> findById(@PathVariable Long id){
        Optional<Departamento> departamentoAchado = departamentoService.findById(id);
        return departamentoAchado.isPresent()
                ? ResponseEntity.ok().body(departamentoAchado.get())
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> update(@PathVariable Long id, @RequestBody Departamento departamentoAtualizado){
        Departamento departamento = departamentoService.update(id, departamentoAtualizado);
        return ResponseEntity.ok(departamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        departamentoService.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
