package com.brunodaniel.financas.service;

import com.brunodaniel.financas.entity.Categoria;
import com.brunodaniel.financas.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private CategoriaRepository repository;

    public void insereCategoria(Categoria categoria) {
        repository.save(categoria);
    }

    public Optional<Categoria> buscaCategoria(Long id) {
        return repository.findById(id);
    }

    public List<Categoria> buscaCategorias() {
        return repository.findAll();
    }

    public void atualizaCategoria(Categoria categoria) {
        repository.save(categoria);
    }

    public void removeCategoria(Long id) {
        repository.deleteById(id);
    }
}
