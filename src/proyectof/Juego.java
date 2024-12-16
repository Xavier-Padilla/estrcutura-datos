package proyectof;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Juego {

    public static void main(String[] args) {
        
        ArrayStack letrasUsadas = new ArrayStack(26);
        Scanner scanner = new Scanner(System.in);

        
        String rutaArchivo = "C:\\Users\\Joker\\Desktop\\netbeans\\netbeans-23-bin\\netbeans\\bin\\palabras.txt";

        
        String[] palabras = leerPalabrasDeArchivo(rutaArchivo);
        if (palabras == null || palabras.length == 0) {
            System.out.println("El archivo de palabras está vacío o no existe.");
            return;
        }

        
        String palabraSecreta = palabras[new Random().nextInt(palabras.length)].toUpperCase();
        char[] palabraOculta = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraOculta.length; i++) {
            palabraOculta[i] = '_';
        }

        int errores = 0;
        boolean juegoTerminado = false;

        System.out.println("¡Bienvenido al juego del ahorcado!");
        while (!juegoTerminado) {
            mostrarEstado(errores, palabraOculta);
            System.out.println("\nLetras usadas: " + letrasUsadas.toString());
            System.out.print("Ingresa una letra: ");
            char letra = scanner.nextLine().toUpperCase().charAt(0);

            if (letrasUsadas.toString().contains(String.valueOf(letra))) {
                System.out.println("\nYa usaste esta letra. Intenta con otra.");
            } else {
                letrasUsadas.push(letra);

                if (palabraSecreta.indexOf(letra) >= 0) {
                    
                    for (int i = 0; i < palabraSecreta.length(); i++) {
                        if (palabraSecreta.charAt(i) == letra) {
                            palabraOculta[i] = letra;
                        }
                    }
                    System.out.println("\n¡Correcto!");
                } else {
                    errores++;
                    System.out.println("\nLetra incorrecta.");
                }
            }

            
            if (errores == 6) {
                juegoTerminado = true;
                mostrarEstado(errores, palabraOculta);
                System.out.println("\n¡Has perdido! La palabra era: " + palabraSecreta);
            } else if (String.valueOf(palabraOculta).equals(palabraSecreta)) {
                juegoTerminado = true;
                System.out.println("\n¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
            }
        }

        scanner.close();
    }

    private static String[] leerPalabrasDeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            return br.lines().toArray(String[]::new);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    private static void mostrarEstado(int errores, char[] palabraOculta) {
        
        String[] figura = {
                "\n  +---+",
                "  |   |",
                "      |",
                "      |",
                "      |",
                "      |",
                "========="
        };

        if (errores > 0) figura[2] = "  O   |";
        if (errores > 1) figura[3] = "  |   |";
        if (errores > 2) figura[3] = " /|   |";
        if (errores > 3) figura[3] = " /|\\  |";
        if (errores > 4) figura[4] = " /    |";
        if (errores > 5) figura[4] = " / \\  |";

        for (String linea : figura) {
            System.out.println(linea);
        }

        
        System.out.println("\nPalabra: " + String.valueOf(palabraOculta));
    }
}
