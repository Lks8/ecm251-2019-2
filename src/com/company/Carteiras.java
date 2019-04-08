package com.company;
//Gustavo Villela Rubia, RA :17.01736-0
//Lucas Coelho, RA :15.03863-7
public class Carteiras {
    private static double id=0;
    private String nomeCarteira;
    private String senhaAcesso;
    private Cartoes cartaoDebito;
    private Cartoes cartaoCredito;
    private Usuario usuario;

    public Carteiras (String nomeCarteira, String senhaAcesso, Cartoes cartaoDebito, Cartoes cartaoCredito, Usuario usuario){ //construtor das carteiras
        this.id= Carteiras.id;
        Carteiras.id++;
        this.nomeCarteira=nomeCarteira;
        this.senhaAcesso=senhaAcesso;
        this.cartaoDebito=cartaoDebito;
        this.cartaoCredito=cartaoCredito;
        this.usuario=usuario;
    }

    public double getId() {
        return id;
    }

    public String getNomeCarteira() {
        return nomeCarteira;
    }

    public void setNomeCarteira(String nomeCarteira) { //a pessoa pode definir o proposito da carteira, nomeando-a "empresa" ou "pessoal"
        this.nomeCarteira = nomeCarteira;
    }

    public void setSenhaAcesso(String senhaAcesso) {
        this.senhaAcesso = senhaAcesso;
    }

    public Cartoes isCartaoDebito() {
        return cartaoDebito;
    }

    public void setCartaoDebito(Cartoes cartaoDebito) {
        this.cartaoDebito = cartaoDebito;
    }

    public Cartoes isCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(Cartoes cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public String abrirCarteira(){ // colocamos apenas estas informacoes, pois as consideramos nao-criticas
        if(this.cartaoCredito==null){
            return("Nome da carteira: " + getNomeCarteira() + " ID: " + getId() + " Usuario: " + getUsuario().getNome() + " Possui um cartao de debito");
        } else if(this.cartaoDebito==null){
            return("Nome da carteira: " + getNomeCarteira() + " ID: " + getId() + " Usuario: " + getUsuario().getNome() + " Possui um cartao de credito");
        } else {
            return("Nome da carteira: " + getNomeCarteira() + " ID: " + getId() + " Usuario: " + getUsuario().getNome() + " Possui um cartão de credito e um de debito");
        } //os ifs retornam se a carteira possui cartoes de credito ou de debito
    }

    public Usuario getUsuario() {
        return usuario;
    }

}
