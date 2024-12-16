/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenfinal;

/**
 *
 * @author Joker
 */
public class pregunta4 {
    
    public static void main(String[] args) {
        ArbolesBinarios arbol = new ArbolesBinarios();

        
        int[] valores = {67, 43, 80, 11, 55, 70, 92, 5, 13, 50, 56, 68, 74, 90, 95};

        for (int valor : valores) {
            arbol.add(valor);
        }

       
        System.out.println("Recorrido Preorden:");
        arbol.preorden();

        System.out.println("\n\nRecorrido Inorden:");
        arbol.inorden();

        System.out.println("\n\nRecorrido Postorden:");
        arbol.postorden();
    }
}

