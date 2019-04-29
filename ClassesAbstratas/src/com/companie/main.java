package com.companie;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ListaDeCompras listaDeCompras = new ListaDeCompras();
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<3;i++){
            String nome = scanner.next();
            if(listaDeCompras.AdicionarProdutos(new Produto (nome))){
                System.out.println("Produto add!");
            } else {
                System.out.println("Deu ruim");
            }
        }
        listaDeCompras.AdicionarProdutos(new Produto("A"));
        listaDeCompras.AdicionarProdutos(new Produto("B"));
        if(listaDeCompras.Remover("A")){
            System.out.println("Removido com sucesso!");
        }
        if(listaDeCompras.Remover("c")){
            System.out.println("Removido com sucesso!");
        } else {
            System.out.println("Erro ao remover");
        }
    }
}
