package com.example.danilo.service;

import com.example.danilo.entity.Departamento;
import com.example.danilo.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<Departamento> findAll(){
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> findById(Long id){
        return departamentoRepository.findById(id);
    }

    public Departamento save(Departamento departamento){
        return departamentoRepository.save(departamento);
    }

    public void deleteById(Long id){
        departamentoRepository.deleteById(id);
    }

    public Departamento update(Long id, Departamento departamento){
        Departamento novoDepartamento = departamentoRepository.findById(id).get();

        novoDepartamento.setNome(departamento.getNome());
        novoDepartamento.setLocalizacao(departamento.getLocalizacao());

        return departamentoRepository.save(novoDepartamento);
    }
}
