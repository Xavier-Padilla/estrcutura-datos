package examenfinal;

import java.util.Scanner;

public class pregunta2 {

    public static void main(String[] args) {
        ArrayStack acciones = new ArrayStack(50); 
        ArrayStack accionesDeshechas = new ArrayStack(50); 
        StringBuilder documento = new StringBuilder(); 
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nDocumento actual: \"" + documento.toString() + "\"\n");
            System.out.println("Opciones:");
            System.out.println("1. Agregar palabra");
            System.out.println("2. Deshacer última acción");
            System.out.println("3. Rehacer última acción");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese una palabra para agregar al documento: ");
                    String palabra = scanner.nextLine();
                    acciones.push(palabra); 
                    accionesDeshechas = new ArrayStack(50); 
                    documento.append(palabra).append(" ");
                    break;

                case 2:
                    if (!acciones.isEmpty()) {
                        String ultimaAccion = (String) acciones.pop();
                        accionesDeshechas.push(ultimaAccion); 
                        documento.setLength(Math.max(0, documento.length() - (ultimaAccion.length() + 1))); 
                    } else {
                        System.out.println("No hay acciones para deshacer.");
                    }
                    break;

                case 3:
                    if (!accionesDeshechas.isEmpty()) {
                        String accionDeshecha = (String) accionesDeshechas.pop();
                        acciones.push(accionDeshecha); 
                        documento.append(accionDeshecha).append(" ");
                    } else {
                        System.out.println("No hay acciones para rehacer.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
