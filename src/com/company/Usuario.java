package com.company;
//Gustavo Villela Rubia, RA :17.01736-0
//Lucas Coelho, RA :15.03863-7
public class Usuario {
    private String nome;
    private String email;
    private String cpf;
    private String nascimento;

    public Usuario(String nome, String email, String cpf, String nascimento){ //construtor para criação de uma conta no banco, todos estes atributos do usuario são necessários
        this.nome= nome;
        this.email=email;
        this.cpf=cpf;
        this.nascimento=nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    public String exibirInformacaoUsuario(){ //mostra informacoes nao criticas do usuario
        return ("Nome: " + getNome() + " Email: " + getEmail() + " CPF: " + getCpf() + " Nascimento " + getNascimento());
    }
}
