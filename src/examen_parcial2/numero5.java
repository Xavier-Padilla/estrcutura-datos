
//XAVIER ALEXANDRO PADILLA ARELLANO


package examen_parcial2;
import java.util.Random;

public class numero5 {
    public static void main(String[] args) {
        NumericPriorityQueue cola = new NumericPriorityQueue();
        Random aleatorio = new Random();
        int veces25 = 0;
        int elementosQuitados = 0;

        for (int i = 0; i < 50; i++) {
            int numero = aleatorio.nextInt(50) + 1;
            cola.enqueue(numero, numero);
            System.out.println("Número encolado: " + numero);

            if (numero == 25) {
                veces25++;
                System.out.println("¡Se encontró el número 25! Quitando 3 elementos...");
                for (int j = 0; j < 3; j++) {
                    Object quitado = cola.dequeue();
                    if (quitado != null) {
                        System.out.println("Elemento quitado: " + quitado);
                        elementosQuitados++;
                    } else {
                        System.out.println("La cola está vacía, no se pueden quitar más elementos.");
                        break;
                    }
                }
            }
        }

        System.out.println("\nTotal de veces que se encontró el 25: " + veces25);
        System.out.println("Total de elementos quitados: " + elementosQuitados);
        System.out.println("Estado final de la cola: " + cola.toString());
    }
}
