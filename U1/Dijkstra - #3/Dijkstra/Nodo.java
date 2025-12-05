package Dijkstra;
import java.util.*;

public class Nodo {
    private String id;
    private Integer distancia = Integer.MAX_VALUE;
    private List<Nodo> caminoCorto = new LinkedList<>();
    private Map<Nodo, Integer> nodosAdyacentes = new HashMap<>();

    public Nodo(String id){
        this.id = id;
    }

    public String getId() { return id; }
    public Integer getDistancia() { return distancia; }
    public void setDistancia(Integer distancia) { this.distancia = distancia; }
    public List<Nodo> getCaminoCorto() { return caminoCorto; }
    public void setCaminoCorto(List<Nodo> caminoCorto) { this.caminoCorto = caminoCorto; }
    public Map<Nodo, Integer> getNodosAdyacentes() { return nodosAdyacentes; }

    public void addNodosAdyacentes(Nodo nodo, int costo){
        nodosAdyacentes.put(nodo, costo);
    }

    public String toString(){
        return id;
    }
}
