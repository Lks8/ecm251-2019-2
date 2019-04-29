package com.company;

public class main{
    public static void main(String[] args) {
        Animal[] animais =new Animal[3];
        animais[0]= new Lobo();
        animais[0].comer();
        animais[1] = new Lobo();
        animais[2] = new Lobo();

//        Animal a = new Lobo();
//        Animal b = new Peixe();
//        a.comer();
//        b.comer();

//       for(int i=0; i<animais.length; i++){
//            animais[i].comer();
//       }

        for(Animal animal : animais){
            animal.comer();
        }
    }
}