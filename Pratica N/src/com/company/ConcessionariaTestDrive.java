package com.company;

public class ConcessionariaTestDrive {


    public static void main(String[] args) {
//        Funcionarios f1 = new Funcionarios("José",1000);
//        System.out.println("Funcionario: " + f1.pegaDados());
        Gerente g1 = new Gerente("Mario",6500);
        Vendedor v1 = new Vendedor("Carlos",1000,g1);

        double totalVendasMes = 10000;
        System.out.println("Vendedor: " + v1.pegaDados());
        System.out.println("Comissao: " + v1.getComissao(totalVendasMes));
        System.out.println("Gerente: " + g1.pegaDados());
        System.out.println("Comissao: " + g1.getComissao(totalVendasMes));
    }
}