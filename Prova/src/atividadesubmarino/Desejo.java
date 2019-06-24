package atividadesubmarino;

import java.util.LinkedList;
import java.util.List;

public class Desejo extends Lista {
    private List<Produto> desejos;

    public Desejo(){
        desejos = new LinkedList<Produto>();
    }

    public boolean adicionarALista(Produto produto){
        if(desejos.size()<=4){
            desejos.add(produto);
            return true;
        } else {
            return false;
        }
    }

    public int getRestantes(){
        return desejos.size();
    }

    public List<Produto> retornarResumo(){
        for(Produto produto: desejos){
            produto.exibirResumo();
        }
        return desejos;
    }

    public boolean removerUltimoDaLista(){
        if(desejos.size()==0){
            return false;
        } else {
            desejos.remove(desejos.size()-1);
            return true;
        }
    }
}
