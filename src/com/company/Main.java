package com.company;
//Gustavo Villela Rubia, RA :17.01736-0
//Lucas Coelho, RA :15.03863-7
public class Main {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Scalco","QueroCafe@gmail.com","123.456.789-91","11/09/1930"); //cadastro do usuario 1
        System.out.println("Usuario: " + u1.exibirInformacaoUsuario()); // exibe dados do usuario 1

        Usuario u2 = new Usuario("Murilo","sousafada@gmail.com","690.691.420-69","24/09/2017");//cadastro do usuario 2
        System.out.println("Usuario: " + u2.exibirInformacaoUsuario());// exibe dados do usuario 2

        Cartoes g1 = new Cartoes("Visa","Debito","08/04/2019","08/04/2022",321,321654,1261653456,321654987);// cadastro do cartao 1
        System.out.println("Cartao: " + g1.verCartao());// exibe dados do cartao 1

        Cartoes g2 = new Cartoes("ELO","Debito","09/10/1969","06/05/2022",552,123456,852469432,55872269);// cadastro do cartao 2
        System.out.println("Cartao: " + g2.verCartao()); // exibe dados do cartao 2

        Cartoes g3 = new Cartoes("Mastercard","Credito","09/10/1969","06/05/2022",881,789456,41821947,3197259); // cadastro do cartao 3
        System.out.println("Cartao: " + g3.verCartao()); // exibe dados do cartao 3

        Carteiras c1 = new Carteiras("Faculdade","123456",g1,null,u1); // cadastro da carteira 1
        System.out.println("Carteiras: " + c1.abrirCarteira()); // exibe dados da carteira 1

        Carteiras c2 = new Carteiras("Cafezinho","654321",g3,g2,u2); // cadastro da carteira 2
        System.out.println("Carteiras: " + c2.abrirCarteira()); // exibe dados da carteira 2

        g1.depositar(2000); //deposito no cartao 1
        g1.pagamento(321654,100); // pagamento efetuado pelo cartao 1

        g2.depositar(9000); //deposito no cartao 2
        g2.pagamento(123456,1000); // pagamento efetuado pelo cartao 2

        g3.depositar(8000); //deposito no cartao 3
        g3.pagamento(789456,500); // pagamento efetuado pelo cartao 3

    }
}
