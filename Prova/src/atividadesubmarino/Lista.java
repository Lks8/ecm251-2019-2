package atividadesubmarino;
import java.util.LinkedList;
import java.util.List;

public abstract class Lista {
    private List<Produto>lista;

    public abstract boolean adicionarALista(Produto produto);
    public abstract int getRestantes();
    public abstract List<Produto> retornarResumo();
    public abstract boolean removerUltimoDaLista();
}