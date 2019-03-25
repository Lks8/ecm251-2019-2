package com.company;

public class Main {

    public static void main(String[] args) {
	    Cliente cliente = new Cliente("Scalco");
	    Produto produto = new Produto(0,4.5,"Coxinha");
	    Compra c1 = new Compra(1,cliente,produto);
        System.out.println(c1.pegarDetalhes());
    }
}
