
//XAVIER ALEXANDRO PADILLA ARELLANO

package examen_parcial2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        
        NumericPriorityQueue cola = new NumericPriorityQueue();
        ArrayList listaUnica = new ArrayList();
        ArrayList todosNumeros = new ArrayList();
        Random aleatorio = new Random();

       
        for (int i = 0; i < 50; i++) {
            int numero = aleatorio.nextInt(50) + 1; 
            cola.enqueue(numero, numero); 
            todosNumeros.add(numero);
            System.out.println("Número encolado: " + numero);
        }

      
        for (int i = 0; i < todosNumeros.size(); i++) {
            int numeroActual = (int) todosNumeros.get(i);
            int contador = 0;

            
            for (int j = 0; j < todosNumeros.size(); j++) {
                if ((int) todosNumeros.get(j) == numeroActual) {
                    contador++;
                }
            }

            
            if (contador == 1) {
                listaUnica.add(numeroActual);
            }
        }

       
        System.out.println("\nNúmeros únicos en la lista:");
        listaUnica.printList();
    }
}
