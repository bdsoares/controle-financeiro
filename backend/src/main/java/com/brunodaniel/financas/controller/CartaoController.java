package com.brunodaniel.financas.controller;

import com.brunodaniel.financas.entity.Cartao;
import com.brunodaniel.financas.service.CartaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cartao")
public class CartaoController {
    private final CartaoService service;

    public CartaoController(CartaoService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void insereCartao(@RequestBody Cartao cartao) {
        if (cartao.getNome() == null)
            return;

        service.insereCartao(cartao);
    }

    @GetMapping(path = "/{id}")
    public Cartao buscaCartao(@PathVariable Long id) {
        Optional<Cartao> cartao = service.buscaCartao(id);

        if (cartao.isEmpty())
            return null;

        return cartao.get();
    }

    @GetMapping
    public List<Cartao> buscaCartoes() {
        return service.buscaCartoes();
    }

    @PutMapping(path = "/{id}")
    public void atualizaCartoes(@PathVariable Long id, @RequestBody Cartao cartao) {
        if (buscaCartao(id) == null)
            return;

        service.atualizaCartao(cartao);
    }

    @DeleteMapping(path = "/{id}")
    public void removeCartao(@PathVariable Long id) {
        if (buscaCartao(id) == null)
            return;

        service.removeCartao(id);
    }
}
