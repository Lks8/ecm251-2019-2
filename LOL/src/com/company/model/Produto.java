package com.company.model;

import com.company.utilities.Constants;

public class Produto {
    public int id, quantidade;
    public String nome, fabricante, categoria;
    public double preco;

    public Produto(String nome, int quantidade, String fabricante, String categoria, double preco){
        this.nome = nome;
        this.quantidade = quantidade;
        this.fabricante = fabricante;
        this.categoria = categoria;
        this.preco = preco;
        this.id = Constants.ID_NULO;
    }
}
