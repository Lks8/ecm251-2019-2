package atividadesubmarino;

import java.util.LinkedList;
import java.util.List;

public class Carrinho extends Lista {
    private List<Produto>carrinho;

    public Carrinho(){
        carrinho = new LinkedList<Produto>();
    }

    public boolean adicionarALista(Produto produto){
        if(carrinho.size()<=11){
            carrinho.add(produto);
            return true;
        } else {
            return false;
        }
    }

    public int getRestantes(){
        return carrinho.size();
    }

    public List<Produto> retornarResumo(){
        for(Produto produto: carrinho){
            produto.exibirResumo();
        }
        return carrinho;
    }

    public boolean removerUltimoDaLista(){
        if(carrinho.size()==0){
            return false;
        } else {
            carrinho.remove(carrinho.size()-1);
            return true;
        }
    }

    public void limparLista(){
        carrinho.removeAll(carrinho);
    }
}
