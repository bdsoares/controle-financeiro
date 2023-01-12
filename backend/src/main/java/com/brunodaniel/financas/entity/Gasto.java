package com.brunodaniel.financas.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "gastos")
public class Gasto {
    @Id
    private Long id;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private double valor;

    @ManyToOne
    private Categoria categoria;

    @OneToOne()
    private Cartao cartao;

    @ManyToOne()
    private Usuario usuario;

    public Gasto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
