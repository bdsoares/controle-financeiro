package com.brunodaniel.financas.controller;

import com.brunodaniel.financas.entity.Categoria;
import com.brunodaniel.financas.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void insereCategoria(@RequestBody Categoria categoria) {
        if (categoria.getCategoria() == null)
            return;

        service.insereCategoria(categoria);
    }

    @GetMapping(path = "/{id}")
    public Categoria buscaCategoria(@PathVariable Long id) {
        Optional<Categoria> categoria = service.buscaCategoria(id);

        if (categoria.isEmpty())
            return null;

        return categoria.get();
    }

    @GetMapping
    public List<Categoria> buscaCategorias() {
        return service.buscaCategorias();
    }

    @PutMapping(path = "/{id}")
    public void atualizaCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        if (buscaCategoria(id) == null)
            return;

        service.atualizaCategoria(categoria);
    }

    @DeleteMapping(path = "/{id}")
    public void removeCategoria(@PathVariable Long id) {
        if (buscaCategoria(id) == null)
            return;

        service.removeCategoria(id);
    }
}
