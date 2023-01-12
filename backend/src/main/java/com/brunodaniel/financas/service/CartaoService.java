package com.brunodaniel.financas.service;

import com.brunodaniel.financas.entity.Cartao;
import com.brunodaniel.financas.repository.CartaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaoService {
    private CartaoRepository repository;

    public void insereCartao(Cartao cartao) {
        repository.save(cartao);
    }

    public Optional<Cartao> buscaCartao(Long id) {
        return repository.findById(id);
    }

    public List<Cartao> buscaCartoes() {
        return repository.findAll();
    }

    public void atualizaCartao(Cartao cartao) {
        repository.save(cartao);
    }

    public void removeCartao(Long id) {
        repository.deleteById(id);
    }
}
