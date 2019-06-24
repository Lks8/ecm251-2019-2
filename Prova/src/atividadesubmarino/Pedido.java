package atividadesubmarino;

public class Pedido extends Carrinho implements Método {
    public static int id=0;



    public Pedido(int id){

        this.id=id;
        id++;
    }
}
