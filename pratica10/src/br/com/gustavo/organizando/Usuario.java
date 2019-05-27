package br.com.gustavo.organizando;

public class Usuario {
    protected String nome;
    protected String senha;

    public Cliente(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
