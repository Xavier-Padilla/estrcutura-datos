
package ordenamientos;

import java.util.Random;
import java.util.Scanner;

public class DoubleLinkedList {
    private int tamaño;
    private DoubleNodo inicio;

    public DoubleLinkedList() {
        tamaño = 0;
        inicio = null;
    }

    public boolean esVacia() {
        return tamaño == 0;
    }

    public int tamaño() {
        return tamaño;
    }

    public void agregar(int valor) {
        DoubleNodo nuevo = new DoubleNodo();
        nuevo.setValor(valor);

        if (esVacia()) {
            inicio = nuevo;
        } else {
            DoubleNodo actual = inicio;
            while (actual.getDerecho() != null) {
                actual = actual.getDerecho();
            }
            actual.setDerecho(nuevo);
            nuevo.setIzquierda(actual);
        }
        tamaño++;
    }

    public DoubleNodo obtener(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de límites: " + indice);
        }

        DoubleNodo actual = inicio;
        for (int i = 0; i < indice; i++) {
            actual = actual.getDerecho();
        }
        return actual;
    }

    public void intercambiar(int i, int j) {
        int temp = (int) obtener(i).getValor();
        obtener(i).setValor(obtener(j).getValor());
        obtener(j).setValor(temp);
    }

    public void ordenarQuick(int izquierda, int derecha) {
        if (izquierda < derecha) {
            int pivote = (int) obtener(derecha).getValor();
            int i = izquierda - 1;

            for (int j = izquierda; j < derecha; j++) {
                if ((int) obtener(j).getValor() <= pivote) {
                    i++;
                    intercambiar(i, j);
                }
            }
            intercambiar(i + 1, derecha);
            ordenarQuick(izquierda, i);
            ordenarQuick(i + 2, derecha);
        }
    }

    public void ordenarShell() {
        for (int intervalo = tamaño / 2; intervalo > 0; intervalo /= 2) {
            for (int i = intervalo; i < tamaño; i++) {
                for (int j = i; j >= intervalo && (int) obtener(j - intervalo).getValor() > (int) obtener(j).getValor(); j -= intervalo) {
                    intercambiar(j, j - intervalo);
                }
            }
        }
    }

    public int buscarBinario(int objetivo) {
        int izquierda = 0;
        int derecha = tamaño - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            int valorMedio = (int) obtener(medio).getValor();

            if (valorMedio == objetivo) {
                return medio;
            } else if (valorMedio < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return -1;
    }

    public void mostrarLista() {
        DoubleNodo actual = inicio;
        while (actual != null) {
            System.out.print(actual.getValor() + " ");
            actual = actual.getDerecho();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleLinkedList lista = new DoubleLinkedList();
        Random aleatorio = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 20; i++) {
            lista.agregar(aleatorio.nextInt(100) + 1);
        }

        System.out.println("Lista original:");
        lista.mostrarLista();

        System.out.print("Elige el método de ordenación (1 para Quick Sort, 2 para Shell Sort): ");
        int eleccion = scanner.nextInt();

        if (eleccion == 1) {
            lista.ordenarQuick(0, lista.tamaño() - 1);
            System.out.println("Lista ordenada con Quick Sort:");
        } else {
            lista.ordenarShell();
            System.out.println("Lista ordenada con Shell Sort:");
        }

        lista.mostrarLista();

        System.out.print("Ingresa un número a buscar: ");
        int objetivo = scanner.nextInt();

        int indice = lista.buscarBinario(objetivo);

        if (indice != -1) {
            System.out.println("Número encontrado en la posición: " + indice);
        } else {
            System.out.println("Número no encontrado.");
        }

        scanner.close();
    }
}