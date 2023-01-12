package com.brunodaniel.financas.controller;

import com.brunodaniel.financas.entity.Usuario;
import com.brunodaniel.financas.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public void insereUsuario(@RequestBody Usuario usuario) {
        if (usuario.getUsuario() == null || usuario.getSenha() == null)
            return;

        service.insereUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Usuario buscaUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = service.buscaUsuario(id);

        if (usuario.isEmpty())
            return null;

        return usuario.get();
    }

    @GetMapping
    public List<Usuario> buscaUsuarios() {
        return service.buscaUsuarios();
    }

    @PutMapping(path = "/{id}")
    public void atualizaUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (usuario.getId() == null)
            usuario.setId(id);

        if (buscaUsuario(id) == null)
            return;

        service.atualizaUsuario(usuario);
    }

    @DeleteMapping(path = "/{id}")
    public void removeUsuario(@PathVariable Long id) {
        if (buscaUsuario(id) == null)
            return;

        service.removeUsuario(id);
    }
}
