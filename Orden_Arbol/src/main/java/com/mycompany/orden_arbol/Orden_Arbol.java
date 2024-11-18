package com.mycompany.orden_arbol;
class Nodo {
    int valor;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(int valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }
}

public class Orden_Arbol {
    private Nodo raiz; 
    public Orden_Arbol() {
        this.raiz = null;
    }

    public void agregar(int valor) {
        raiz = agregarRecursivo(raiz, valor);
    }

    private Nodo agregarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor); 
        }

        if (valor < nodo.valor) {
            nodo.izquierda = agregarRecursivo(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = agregarRecursivo(nodo.derecha, valor);
        }
        return nodo;
    }

    public void recorridoInOrden() {
        System.out.print("Recorrido InOrden: ");
        recorridoInOrdenRecursivo(raiz);
        System.out.println();
    }

    private void recorridoInOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            recorridoInOrdenRecursivo(nodo.izquierda); 
            System.out.print(nodo.valor + " ");      
            recorridoInOrdenRecursivo(nodo.derecha);   
        }
    }

    public void recorridoPosOrden() {
        System.out.print("Recorrido PosOrden: ");
        recorridoPosOrdenRecursivo(raiz);
        System.out.println();
    }

    private void recorridoPosOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            recorridoPosOrdenRecursivo(nodo.izquierda);
            recorridoPosOrdenRecursivo(nodo.derecha);   
            System.out.print(nodo.valor + " ");         
        }
    }

    public static void main(String[] args) {
        Orden_Arbol arbol = new Orden_Arbol();
        int[] valores = {40, 20, 60, 10, 30, 50, 70}; 

       
        for (int valor : valores) {
            arbol.agregar(valor);
        }

        arbol.recorridoInOrden();
        arbol.recorridoPosOrden();
    }
}
