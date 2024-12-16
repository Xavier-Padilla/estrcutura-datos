package examenfinal;

public class pregunta3 {
    public static void main(String[] args) {
        
        String[] palabras = {"Menos", "Nabucodonosor", "Bebida", "Angelópolis", "Corleone",
                             "Avión", "Planta", "Centro comercial", "Ana", "Cthulhu"};

        
        BooleanPriorityQueue colaPrioridad = new BooleanPriorityQueue();

        
        for (String palabra : palabras) {
            int numV = contarV(palabra);
            
            colaPrioridad.enqueue(palabra, numV >= 5); 
        }

       
        System.out.println("Elementos de la cola de prioridad:");
        while (!colaPrioridad.isEmpty()) {
            System.out.println(colaPrioridad.dequeue());
        }
    }

   
    private static int contarV(String palabra) {
        int contador = 0;
        String vocales = "aeiouáéíóúAEIOUÁÉÍÓÚ";
        for (char c : palabra.toCharArray()) {
            if (vocales.indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;
    }
}
