package com.company;

public class FuncionariosTestDrive {
    public static void main(String[] args) {
        Funcionarios f1 = new Funcionarios("José",1000);
        System.out.println("Funcionario: " + f1.pegaDados());
        Vendedor v1 = new Vendedor("Carlos",10000);
        System.out.println("Vendedor: " + v1.pegaDados());
        Gerente g1 = new Gerente("Mario",50000);
        System.out.println("Gerente: " + g1.pegaDados());
    }
}
