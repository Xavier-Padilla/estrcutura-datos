package examenfinal;

import java.util.*;

public class pregunta1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayStack pilaLibros = null;

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Generar claves de libros");
            System.out.println("2. Mostrar claves de libros generadas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1: 
                    System.out.print("Ingrese la cantidad de claves de libros a generar: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine(); 
                    pilaLibros = new ArrayStack(cantidad);
                    generar(pilaLibros, cantidad);
                    System.out.println("¡Claves de libros generadas con éxito!");
                    break;

                case 2: 
                    if (pilaLibros == null || pilaLibros.isEmpty()) {
                        System.out.println("Primero debe generar claves de libros.");
                    } else {
                        System.out.println("\nClaves de libros generadas:");
                        imprimir(pilaLibros);
                    }
                    break;

                case 3: 
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
        scanner.close();
    }

    private static void generar(ArrayStack pila, int cantidad) {
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            StringBuilder isbn = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                isbn.append(random.nextInt(4));
            }

            int anio = 1990 + random.nextInt(18);
            int numeroLibro = random.nextInt(10000);

            String clave = "isbn" + "-" + anio + "-" + numeroLibro;

            pila.push(clave);
        }
    }

    private static void imprimir(ArrayStack pila) {
        ArrayStack temp = new ArrayStack(pila.size());

        while (!pila.isEmpty()) {
            String clave = (String) pila.pop();
            System.out.println(clave);
            temp.push(clave);
        }

        while (!temp.isEmpty()) {
            pila.push(temp.pop());
        }
    }
}
