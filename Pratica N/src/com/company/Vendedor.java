package com.company;

public class Vendedor{
    private String nome;
    private static int totalDeId = 1000000;
    private int id;
    private double pocentagemDeComissao;
    private double salarioBase;

    public Vendedor(String nome, double salarioBase, Gerente gerente){
        this.nome = nome;
        this.id = Vendedor.totalDeId;
        Vendedor.totalDeId++;
        this.pocentagemDeComissao = 0.05;
        this.salarioBase = salarioBase;
        this.gerente = gerente;
    }

    public String pegaDados(){
        return "Nome: " + this.nome + " ID: " + this.id + " Comissao: " + this.pocentagemDeComissao + " Salario Base: " + this.salarioBase;
    }

    public static int getId(){
        return Vendedor.totalDeId;
    }

    public double getSalarioMes(int totalDeVendas){
        return this.pocentagemDeComissao*totalDeVendas + this.salarioBase;
    }

    public double getSalarioBase(){
        return this.salarioBase;
    }

    public double getComissao(double totalDeVendas){
        return this.pocentagemDeComissao * totalDeVendas;
    }

    public Gerente getGerente(){
        return gerente;
    }

}
