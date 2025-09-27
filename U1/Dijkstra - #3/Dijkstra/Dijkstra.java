package Dijkstra;
import java.util.*;

public class Dijkstra {

    public static Grafo calcularRutaCorta(Grafo grafo, Nodo origen){
        origen.setDistancia(0);

        List<Nodo> procesados = new ArrayList<>();
        List<Nodo> noProcesados = new ArrayList<>();

        noProcesados.add(origen);

        while(!noProcesados.isEmpty()){
            Nodo actual = getNodoMenorDistancia(noProcesados);
            noProcesados.remove(actual);

            for(Map.Entry<Nodo, Integer> parAdyacente : actual.getNodosAdyacentes().entrySet()){
                Nodo adyacente = parAdyacente.getKey();
                Integer peso = parAdyacente.getValue();

                if (!procesados.contains(adyacente)) {
                    actualizarDistanciaMinima(adyacente, peso, actual);
                    if (!noProcesados.contains(adyacente)) {
                        noProcesados.add(adyacente);
                    }
                }
            }
            procesados.add(actual);
        }
        return grafo;
    }

    private static Nodo getNodoMenorDistancia(List<Nodo> nodos){
        Nodo menor = null;
        int menorDistancia = Integer.MAX_VALUE;

        for (Nodo nodo : nodos) {
            int distancia = nodo.getDistancia();
            if (distancia < menorDistancia) {
                menorDistancia = distancia;
                menor = nodo;
            }
        }
        return menor;
    }

    private static void actualizarDistanciaMinima(Nodo nodo, Integer costo, Nodo actual){
        int distancia = actual.getDistancia() + costo;
        if (distancia < nodo.getDistancia()) {
            nodo.setDistancia(distancia);
            List<Nodo> camino = new ArrayList<>(actual.getCaminoCorto());
            camino.add(actual);
            nodo.setCaminoCorto(camino);
        }
    }

    public static void main(String[] args) {
        Nodo nodoA = new Nodo("A");
        Nodo nodoB = new Nodo("B");
        Nodo nodoC = new Nodo("C");
        Nodo nodoD = new Nodo("D");
        Nodo nodoE = new Nodo("E");

        nodoA.addNodosAdyacentes(nodoB, 10);
        nodoA.addNodosAdyacentes(nodoC, 3);
        nodoB.addNodosAdyacentes(nodoD, 2);
        nodoC.addNodosAdyacentes(nodoB, 1);
        nodoC.addNodosAdyacentes(nodoD, 8);
        nodoD.addNodosAdyacentes(nodoE, 1);
        nodoE.addNodosAdyacentes(nodoC, 5);

        Grafo grafo = new Grafo();
        grafo.addNodo(nodoA);
        grafo.addNodo(nodoB);
        grafo.addNodo(nodoC);
        grafo.addNodo(nodoD);
        grafo.addNodo(nodoE);

        calcularRutaCorta(grafo, nodoA);
        System.out.println("Nodo origen A:");
        for (Nodo nodo : grafo.getNodos()) {
            System.out.print("Nodo "+nodo+ ", Distancia: "+nodo.getDistancia()+", Camino: ");
            for (Nodo camino : nodo.getCaminoCorto()) {
                System.out.print(camino + " ");
            }
            System.out.println();
        }
    }
}
