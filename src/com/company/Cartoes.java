package com.company;
//Gustavo Villela Rubia, RA :17.01736-0
//Lucas Coelho, RA :15.03863-7
public class Cartoes {
    private double taxaConversaoDolar;
    private static double idCartao=0;
    private String label;
    private String tipo;
    private String dataEmissao;
    private String validade;
    private int ccv;
    private int senha;
    private double numeroCartao;
    private int numeroConta;
    private double saldo;

    public Cartoes(String label, String tipo, String dataEmissao, String validade, int ccv, int senha, double numeroCartao, int numeroConta) { //construtor dos cartoes
        this.idCartao=Cartoes.idCartao; //id unico do cartao
        Cartoes.idCartao++;
        this.label=label;
        this.tipo=tipo;
        this.dataEmissao=dataEmissao;
        this.validade=validade;
        this.ccv=ccv;
        this.senha=senha;
        this.numeroCartao=numeroCartao;
        this.numeroConta=numeroConta;
        this.saldo=0;
    }

    public void pagamento(int senha, int valor){ //pagamento com verificacao de senha e saldo disponivel
        if(getSenha()==senha){
            if(saldo<valor) {
                System.out.println("Voce nao possui saldo suficiente para esta operacao");
            }else {
                saldo -= valor;
                System.out.println( "Pagamento realizado com sucesso!");
            }
        }else{
            System.out.println("Senha incorreta");
        }
    }

    public void depositar(double valor){ //deposita um valor pra conta
        if (valor>0)
            saldo += valor;
    }

    public double getTaxaConversaoDolar() {
        return taxaConversaoDolar;
    }

    public double getIdCartao() {
        return idCartao;
    }

    public String getLabel() {
        return label;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public String getValidade() {
        return validade;
    }

    public int getCcv() {
        return ccv;
    }

    public int getSenha() {
        return senha;
    }

    public double getNumeroCartao() {
        return numeroCartao;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo(){
        return saldo;
    }

    public String verCartao(){ //mostra dados nao criticos do cartao
        return("ID: " + getIdCartao() + " Label: " + getLabel() + " Tipo: " + getTipo() + " Validade: " + getValidade());
    }
}
