package com.brunodaniel.financas.service;

import com.brunodaniel.financas.entity.Gasto;
import com.brunodaniel.financas.repository.GastoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GastoService {
    private GastoRepository repository;

    public void insereGasto(Gasto gasto) {
        repository.save(gasto);
    }

    public Optional<Gasto> buscaGasto(Long id) {
        return repository.findById(id);
    }

    public List<Gasto> buscaGastos() {
        return repository.findAll();
    }

    public void atualizaGasto(Gasto gasto) {
        repository.save(gasto);
    }

    public void removeGasto(Long id) {
        repository.deleteById(id);
    }
}
