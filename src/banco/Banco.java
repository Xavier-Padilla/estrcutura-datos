package banco;

import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        BooleanPriorityQueue colaConCuenta = new BooleanPriorityQueue();
        BooleanPriorityQueue colaSinCuenta = new BooleanPriorityQueue();
        boolean[] cajaLibre = new boolean[4];

        for (int i = 0; i < cajaLibre.length; i++) {
            cajaLibre[i] = true;  
        }

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Simulador de Banco");
            System.out.println("1. Agregar cliente con cuenta");
            System.out.println("2. Agregar cliente sin cuenta");
            System.out.println("3. Atender cliente en caja");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del cliente con cuenta: ");
                    String clienteConCuenta = scanner.next();
                    colaConCuenta.enqueue(clienteConCuenta, true);
                    break;
                case 2:
                    System.out.print("Nombre del cliente sin cuenta: ");
                    String clienteSinCuenta = scanner.next();
                    colaSinCuenta.enqueue(clienteSinCuenta, false);
                    break;
                case 3:
                    System.out.print("Número de caja (1-4): ");
                    int cajaNum = scanner.nextInt();
                    if (cajaNum >= 1 && cajaNum <= 4) {
                        atenderCliente(colaConCuenta, colaSinCuenta, cajaLibre, cajaNum - 1);
                    } else {
                        System.out.println("Caja no válida. Introduce un número entre 1 y 4.");
                    }
                    break;
                case 4:
                    System.out.println("Hasta la vista, ¡adiós!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);
    }

    public static void atenderCliente(BooleanPriorityQueue colaConCuenta, BooleanPriorityQueue colaSinCuenta, boolean[] cajaLibre, int cajaNum) {
        if (cajaLibre[cajaNum]) {
            if (!colaConCuenta.isEmpty()) {
                System.out.println("Atendiendo cliente con cuenta: " + colaConCuenta.dequeue());
            } else if (!colaSinCuenta.isEmpty()) {
                System.out.println("Atendiendo cliente sin cuenta: " + colaSinCuenta.dequeue());
            } else {
                System.out.println("No hay clientes en cola.");
            }
            cajaLibre[cajaNum] = false; 
        } else {
            System.out.println("Esta caja está ocupada. Por favor, espera tu turno.");
        }
    }
}
