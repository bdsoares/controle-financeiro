package com.brunodaniel.financas.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<Cartao> cartoes;

    @OneToMany(mappedBy = "usuario")
    private List<Gasto> gastos;

    public Usuario() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
