package com.brunodaniel.financas.service;

import com.brunodaniel.financas.entity.Usuario;
import com.brunodaniel.financas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void insereUsuario(Usuario usuario) {
        repository.save(usuario);
    }

    public Optional<Usuario> buscaUsuario(Long id) {
        return repository.findById(id);
    }

    public List<Usuario> buscaUsuarios() {
        return repository.findAll();
    }

    public void atualizaUsuario(Usuario usuario) {
        repository.save(usuario);
    }

    public void removeUsuario(Long id) {
        repository.deleteById(id);
    }
}
