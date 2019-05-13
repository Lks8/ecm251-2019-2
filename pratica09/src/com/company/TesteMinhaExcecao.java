package com.company;

public class TesteMinhaExcecao {
    public static void main(String[] args) {
        String frase = "All Might é melhor que Endevour";
        testaFrase(frase);
    }

    private static void testaFrase(String frase) throws SemLetraException{
        if (!frase.toUpperCase().contains("B")){
            throw new SemLetraException();
        }
    }
}
