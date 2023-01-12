package com.brunodaniel.financas.entity;

import jakarta.persistence.*;

@Entity(name = "cartoes")
public class Cartao {
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, name = "dia_vencimento")
    private int diaVencimento;

    @ManyToOne()
    private Usuario usuario;

    public Cartao () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(int diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
