package com.company;

import com.company.DAO.SingletonProdutoDAO;
import com.company.DAO.SingletonUsuarioDAO;
import com.company.DAO.SingletonVendaDAO;
import com.company.model.Produto;
import com.company.model.Usuario;
import com.company.model.Venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    private List<Produto> produtos;
    private List<Usuario> usuarios;
    private List<Venda> vendas;
    private Usuario logged;

    Scanner scanner;
    public Aplicacao(){
        produtos = new ArrayList<>();
        usuarios = new ArrayList<>();
        vendas = new ArrayList<>();
    }
    public void Login(){
        scanner = new Scanner(System.in);
        System.out.println("Login: ");
        String nome = scanner.next();
        System.out.println("Senha: ");
        String senha = scanner.next();
        logged = SingletonUsuarioDAO.getInstance().Login(nome,senha);
        if(logged != null){
            run();
        }
        else{
            System.out.println("Usuário ou senha inválidos");
            Login();
        }
    }
    private void run(){
        scanner = new Scanner(System.in);
        do {
            menu();
            int op = scanner.nextInt();
            int id;
            Produto resultProduto;
            switch (op){
                //Inserção de produtos
                case 1:
                    String nome, categoria, fabricante;
                    int quantidade;
                    double preco;
                    System.out.println("Digite nome:");
                    nome = scanner.next();
                    System.out.println("Digite fabricante:");
                    fabricante = scanner.next();
                    System.out.println("Digite categoria:");
                    categoria = scanner.next();
                    System.out.println("Digite quantidade:");
                    quantidade = scanner.nextInt();
                    System.out.println("Digite preço:");
                    preco = scanner.nextDouble();

                    Produto prod = new Produto(nome,quantidade,fabricante,categoria,preco);
                    SingletonProdutoDAO.getInstance().insertProduto(prod);
                    break;
                //Exibição de todos os produtos
                case 2:
                    produtos = SingletonProdutoDAO.getInstance().getAllProduto();
                    for(Produto p: produtos){
                        System.out.println("ID: " + p.id);
                        System.out.println(" Nome: " + p.nome);
                        System.out.println(" Quantidade: " + p.quantidade);
                        System.out.println(" Fabricante: " + p.fabricante);
                        System.out.println(" Categoria: " + p.categoria);
                        System.out.println(" Preco: " + p.preco);
                    }
                    break;
                //Exibição de produtos por categoria
                case 3:
                    System.out.println("Informe a categoria: ");
                    categoria = scanner.next();
                    produtos = SingletonProdutoDAO.getInstance().getProdutosPorCategoria(categoria);
                    if(produtos == null)
                        System.out.println("Não existe produto desta categoria");
                    else{
                        for(Produto p: produtos){
                            System.out.println("ID: " + p.id);
                            System.out.println(" Nome: " + p.nome);
                            System.out.println(" Quantidade: " + p.quantidade);
                            System.out.println(" Fabricante: " + p.fabricante);
                            System.out.println(" Categoria: " + p.categoria);
                            System.out.println(" Preco: " + p.preco);
                        }
                    }
                    break;
                //Venda
                case 4:
                    System.out.println("Informe o ID: ");
                    id = scanner.nextInt();
                    resultProduto = SingletonProdutoDAO.getInstance().getProduto(id);
                    if(resultProduto == null)
                        System.out.println("Produto não cadastrado");
                    else{
                        System.out.println("ID: "+ resultProduto.id);
                        System.out.println(" Nome: "+ resultProduto.nome);
                        System.out.println(" Quantidade: "+ resultProduto.quantidade);
                        System.out.println(" Fabricante: "+ resultProduto.fabricante);
                        System.out.println(" Categoria: "+ resultProduto.categoria);
                        System.out.println(" Preço "+ resultProduto.preco);
                        System.out.println("Informe a quantidade de venda: ");
                        int temp = scanner.nextInt();
                        //Teste se a quantidade no estoque supera a de venda
                        if(resultProduto.quantidade - temp>= 0) {
                            resultProduto.quantidade = resultProduto.quantidade - temp;
                            SingletonProdutoDAO.getInstance().vendaDeProduto(resultProduto);
                            System.out.println(" Nova Quantidade no Estoque: "+ resultProduto.quantidade);
                            //Inserção na tabela Vendas
                            Venda venda = new Venda(resultProduto.id,temp,logged.id);
                            SingletonVendaDAO.getInstance().insertVenda(venda);
                        }
                        else
                            System.out.println("Não há quantidade suficiente ");
                    }
                    break;
                //Cadastro de usuários
                case 5:
                    if(logged.nome.equals("admin")) {
                        String temp, senha;
                        System.out.println("Digite nome:");
                        temp = scanner.next();
                        System.out.println("Digite senha:");
                        senha = scanner.next();
                        Usuario user = new Usuario(temp, senha);
                        SingletonUsuarioDAO.getInstance().insertUsuario(user);
                    }
                    else{
                        System.out.println("Você não possui permissão! ");
                    }
                    break;
                //Exibição de usuarios
                case 6:
                    if(logged.nome.equals("admin")) {
                        usuarios = SingletonUsuarioDAO.getInstance().getAllUsuario();
                        for (Usuario u : usuarios) {
                            System.out.println("ID: " + u.id);
                            System.out.println(" Nome: " + u.nome);
                        }
                    }
                    break;
                //Exibição das vendas
                case 7:
                    vendas = SingletonVendaDAO.getInstance().getAllVenda();
                    for(Venda v: vendas){
                        System.out.println(" Produto: " + v.produto);
                        System.out.println(" Quantidade: " + v.quantidade);
                        System.out.println(" Usuario: " + v.usuario);
                    }
                    break;
            }
            if(op == 0) break;
        }while(true);
    }
    //Exibição do Menu
    public void menu(){
        System.out.println("1 - Inserir Produto");
        System.out.println("2 - Mostrar todos os Produtos");
        System.out.println("3 - Buscar Produto por Categoria");
        System.out.println("4 - Vender Produto");
        if(logged.nome.equals("admin")) {
            System.out.println("5 - Inserir Usuário");
            System.out.println("6 - Buscar Usuário");
        }
        System.out.println("7 - Ver tabela de Vendas");
        System.out.println("0 - Sair");
    }


}
