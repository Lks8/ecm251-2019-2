package com.company;

public class Gerente {
    private String nome;
    private static int totalDeId = 1000000000;
    private int id;
    private double pocentagemDeComissao;
    private double salarioBase;

    public Gerente(String nome, double salarioBase){
        this.nome = nome;
        this.id = Gerente.totalDeId;
        Gerente.totalDeId++;
        this.pocentagemDeComissao = 0.05;
        this.salarioBase = salarioBase;
    }

    public String pegaDados(){
        return "Nome: " + this.nome + " ID: " + this.id + " Comissao: " + this.pocentagemDeComissao + " Salario Base: " + this.salarioBase;// + " Salario do Mes: " + this.salarioMes;
    }

    public static int getId(){
        return Gerente.totalDeId;
    }

    public double getSalarioMes(int totalDeVendas){
        return this.getComissao(totalDeVendas)*this.salarioBase;
    }

    public double getSalarioBase(){
        return this.salarioBase;
    }

    public double getComissao(double totalDeVendas){
        return this.pocentagemDeComissao * totalDeVendas + 0.5*this.salarioBase;
    }

    public boolean aumentarSalarioBaseVendedor(Vendedor vendedor){

    }

}
