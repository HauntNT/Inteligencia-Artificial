package Dijkstra;
import java.util.*;

public class Grafo {
    private List<Nodo> nodos = new ArrayList<>();

    public void addNodo(Nodo nodo){
        nodos.add(nodo);
    }

    public List<Nodo> getNodos(){
        return nodos;
    }
}
