package com.company;

abstract class Animal {
    public abstract void comer();
}

class Lobo extends Animal{
    @Override
    public void comer(){
        System.out.println("Eu me alimento como um lobo!");
    }
}

class Peixe extends Animal{

    @Override
    public void comer(){
        System.out.println("Eu me alimento como um peixe!");
    }
}

public class main{
    public static void main(String[] args) {
        Animal a = new Lobo();
        Animal b = new Peixe();

        a.comer();
        b.comer();
    }
}


