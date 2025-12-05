package ArbolBinario;

public class Nodo {
    private int valor;
    private Nodo nodoIzq;
    private Nodo nodoDer;

    public Nodo (int valor){
        this.valor = valor;
        this.nodoIzq = null;
        this.nodoDer = null;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public Nodo getNodoIzq() {
        return nodoIzq;
    }
    public void setNodoIzq(Nodo nodoIzq) {
        this.nodoIzq = nodoIzq;
    }
    public Nodo getNodoDer() {
        return nodoDer;
    }
    public void setNodoDer(Nodo nodoDer) {
        this.nodoDer = nodoDer;
    }
}
