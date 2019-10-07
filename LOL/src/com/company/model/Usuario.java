package com.company.model;

import com.company.utilities.Constants;

public class Usuario {
    public int id;
    public String nome, senha;

    public Usuario(){
    }

    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
        this.id = Constants.ID_NULO;
    }
}
