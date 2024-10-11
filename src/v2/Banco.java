package v2;

import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        ClientePriorityQueue colaConCuenta = new ClientePriorityQueue();
        boolean[] cajaLibre = new boolean[4];

        for (int i = 0; i < cajaLibre.length; i++) {
            cajaLibre[i] = true;
        }

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Simulador de Banco");
            System.out.println("1. Agregar cliente con cuenta (042, 022, 011)");
            System.out.println("2. Atender cliente en caja");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del cliente con cuenta: ");
                    String clienteConCuenta = scanner.next();
                    System.out.print("Código de prioridad (042, 022, 011): ");
                    String codigo = scanner.next();
                    int prioridad = 0;

                    switch (codigo) {
                        case "042":
                            prioridad = 1; 
                            break;
                        case "022":
                            prioridad = 2; 
                            break;
                        case "011":
                            prioridad = 3; 
                            break;
                        default:
                            System.out.println("Código de prioridad no válido.");
                            continue;
                    }
                    colaConCuenta.enqueue(clienteConCuenta, prioridad);
                    break;

                case 2:
                    System.out.print("Número de caja (1-4): ");
                    int cajaNum = scanner.nextInt();
                    if (cajaNum >= 1 && cajaNum <= 4) {
                        atenderCliente(colaConCuenta, cajaLibre, cajaNum - 1);
                    } else {
                        System.out.println("Caja no válida. Introduce un número entre 1 y 4.");
                    }
                    break;

                case 3:
                    System.out.println("Hasta la vista, ¡adiós!");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 3);
    }

    public static void atenderCliente(ClientePriorityQueue colaConCuenta, boolean[] cajaLibre, int cajaNum) {
        if (cajaLibre[cajaNum]) {
            if (!colaConCuenta.isEmpty()) {
                System.out.println("Atendiendo cliente con cuenta: " + colaConCuenta.dequeue());
            } else {
                System.out.println("No hay clientes en cola.");
            }
            cajaLibre[cajaNum] = false; 
        } else {
            System.out.println("Esta caja está ocupada. Por favor, espera tu turno.");
        }
    }
}