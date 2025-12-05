package ArbolBinario;
public class Arbol {
    Nodo raiz;
    public Arbol(){
        this.raiz = null;
    }
    public boolean vacio(){
        return this.raiz == null;
    }
    public Nodo buscar(Nodo actual, int valor){
        if (actual == null) {
            System.out.println("No encontrado");
            return null;
        }
        if (valor == actual.getValor()) {
            System.out.println("Encontrado");
            return actual;
        } else if (valor < actual.getValor()) {
            return buscar(actual.getNodoIzq(), valor);
        } else {
            return buscar (actual.getNodoDer(), valor);
        }
    }
    public void insertar(Nodo actual, int valor){
        if (this.raiz == null) {
            this.raiz = new Nodo(valor);
        } else {
            if (valor < actual.getValor()) {
                if (actual.getNodoIzq() == null) {
                    actual.setNodoIzq(new Nodo(valor));
                } else {
                    insertar(actual.getNodoIzq(), valor);
                }
            } else {
                if (actual.getNodoDer() == null) {
                    actual.setNodoDer(new Nodo(valor));
                } else {
                    insertar(actual.getNodoDer(), valor);
                }
            }
        }
    }
    //Inorden (Izquierda-Raiz-Derecha)
    public void imprimir(Nodo nodo){
        if (nodo != null) {
            imprimir(nodo.getNodoIzq());
            System.out.print(nodo.getValor() +"   ");
            imprimir(nodo.getNodoDer());
        }
    }
      public static void main(String[] args) {
        Arbol arbol = new Arbol();

        arbol.insertar(arbol.raiz, 50);
        arbol.insertar(arbol.raiz, 30);
        arbol.insertar(arbol.raiz, 70);
        arbol.insertar(arbol.raiz, 20);
        arbol.insertar(arbol.raiz, 40);
        arbol.insertar(arbol.raiz, 60);
        arbol.insertar(arbol.raiz, 80);

        System.out.println("Recorrido Inorden del árbol:");
        arbol.imprimir(arbol.raiz);

        System.out.println("\n\nPruebas de búsqueda:");
        arbol.buscar(arbol.raiz, 40); 
        arbol.buscar(arbol.raiz, 90); 
    }
}
