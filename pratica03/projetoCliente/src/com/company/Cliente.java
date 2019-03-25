package com.company;

public class Cliente {
    private String nome;
    private String ra;
    private boolean funcionario;
    private boolean visitante;

    public Cliente(String nome, boolean funcionario) {
        this.nome = nome;
        if(funcionario)
            this.funcionario = funcionario;
        else
            visitante=true;
    }

    public Cliente(String nome){
        this.nome = nome;
        this.visitante = true;
    }

    public Cliente(String nome, String ra){
        this.nome = nome;
        this.ra = ra;
    }

    public void comprar(double valor, String produto){

    }

    public void acompanhar(){

    }

    public Cliente(double preco, String nome, int id){

    }
    public Cliente(int id, String cliente, String produto){

    }

    public String getNome() {
        return nome;
    }

    public String getRa() {
        return ra;
    }

    public boolean isFuncionario() {
        return funcionario;
    }

    public boolean isVisitante() {
        return visitante;
    }
}
