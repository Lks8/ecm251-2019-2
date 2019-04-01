package com.company;

public class Funcionarios {
    private String nome;
    private static int totalDeIdFuncionario = 100;
    private int id;
    private double pocentagemDeComissao;
    private double salarioBase;

    public Funcionarios(String nome, double salarioBase){
        this.nome = nome;
        this.id = Funcionarios.totalDeIdFuncionario;
        Funcionarios.totalDeIdFuncionario++;
        this.pocentagemDeComissao = 0.05;
        this.salarioBase = salarioBase;
    }

    public String pegaDados(){
        return "Nome: " + this.nome + " ID: " + this.id + " Comissao: " + this.pocentagemDeComissao + " Salario Base: " + this.salarioBase;
    }

    public double getSalarioMes(int totalDeVendas){
        return this.pocentagemDeComissao*totalDeVendas + this.salarioBase;
    }

    public static int getId(){
        return Funcionarios.totalDeIdFuncionario;
    }

    public double getSalarioBase(){
        return this.salarioBase;
    }

    public double getComissao(double totalDeVendas){
        return this.pocentagemDeComissao * totalDeVendas;
    }
}

//salarioMes = salarioBase + comissao
//comissao = 0.05*vendas