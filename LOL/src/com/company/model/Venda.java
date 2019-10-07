package com.company.model;

import com.company.utilities.Constants;

public class Venda {
    public int id, produto, quantidade, usuario;

    public Venda(int produto, int quantidade, int usuario){
        this.produto = produto;
        this.quantidade = quantidade;
        this.usuario = usuario;
        this.id = Constants.ID_NULO;
    }
}
