package com.company;

public class main {
    public static void main(String[] args) {
        System.out.println("inicio do main");
        metodo1();
        System.out.println("fim do main");
    }

    static void metodo1(){
        System.out.println("inicio do metodo 1");
        try {
            metodo2();
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Excecao pega no metodo 1");
            System.out.println(e);
        }
        finally {
            System.out.println("Depois do trycatch metodo 1");
        }
        System.out.println("fim do metodo 1");
    }

    static void metodo2() throws  IndexOutOfBoundsException{
        System.out.println("inicio do metodo 2");
        int[] array = new int[10];
        try {
            for (int i = 0; i <= 15; i++) {
                array[i] = i;
                System.out.println(i);
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Algo deu errado");
            System.out.println(e);
            throw(e);
        }
        finally {
            System.out.println("depois do trycatch metodo2");
        }
        System.out.println("fim do metodo 2");
    }
//        static void metodo2(){
//        System.out.println("inicio do metodo 2");
//        int[] array = new int[10];
//        for (int i = 0; i <= 15; i++) {
//            array[i] = i;
//            System.out.println(i);
//        }
//        System.out.println("fim do metodo 2");
//    }
}
