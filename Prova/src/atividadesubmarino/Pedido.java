package atividadesubmarino;

public class Pedido extends Carrinho implements Método {
    public static int totalId=0;

    public Cliente cli;
    public Carrinho carrinho;
    private int id;


    public Pedido(Cliente cli, Carrinho carrinho) {
        this.cli=cli;
        this.carrinho=carrinho;
        this.id=Pedido.totalId;
        Pedido.totalId++;
    }
    public String resumoPedido(){
        String temp="";
        temp += cli.getCep() + cli.getCpf()+cli.getEmail()+cli.getNome()+cli.getEndereco()+carrinho.retornarResumo();
        return temp;
    }
}
