package com.brunodaniel.financas.controller;

import com.brunodaniel.financas.entity.Gasto;
import com.brunodaniel.financas.service.GastoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gasto")
public class GastoController {
    private final GastoService service;

    public GastoController(GastoService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void insereGasto(@RequestBody Gasto gasto) {
        if (gasto.getCategoria() == null || gasto.getCartao() == null
        || gasto.getDescricao() == null || gasto.getData() == null
        || gasto.getUsuario() == null)
            return;

        service.insereGasto(gasto);
    }

    @GetMapping(path = "/{id}")
    public Gasto buscaGasto(@PathVariable Long id) {
        Optional<Gasto> gasto = service.buscaGasto(id);

        if (gasto.isEmpty())
            return null;

        return gasto.get();
    }

    @GetMapping()
    public List<Gasto> buscaGastos() {
        return service.buscaGastos();
    }

    @PutMapping(path = "/{id}")
    public void atualizaGasto(@PathVariable Long id, @RequestBody Gasto gasto) {
        if (buscaGasto(id) == null)
            return;

        service.atualizaGasto(gasto);
    }

    @DeleteMapping(path = "/{id}")
    public void removeGasto(@PathVariable Long id) {
        if (buscaGasto(id) == null)
            return;

        service.removeGasto(id);
    }
}
