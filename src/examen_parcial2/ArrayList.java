/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_parcial2;

/**
 *
 * @author XAVIER ALEXANDRO PADILLA ARELLANO
 */
import java.util.Random;

public class ArrayList {
    private int size;
    private Object[] list;
    private int increment;

    public ArrayList() {
        this.size = 0;
        this.list = new Object[10];
        this.increment = 10;
    }

    public ArrayList(int intSize) {
        this.size = 0;
        this.list = new Object[intSize];
        this.increment = 10;
    }

    public ArrayList(int intSize, int increment) {
        this.size = 0;
        this.list = new Object[intSize];
        this.increment = increment;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Object value) {
        list[size] = value;
        size++;
        if (size == list.length) {
            increment();
        }
    }

    private void increment() {
        Object[] tempList = new Object[list.length + increment];
        for (int i = 0; i < list.length; i++) {
            tempList[i] = list[i];
        }
        list = tempList;
    }

    private void add(int index, Object value) {
        if (size == index) {
            add(value);
        } else {
            for (int i = size; i > index; i--) {
                list[i] = list[i - 1];
            }
            list[index] = value;
            size++;
            if (size == list.length) {
                increment();
            }
        }
    }

    public Object remove(int index) {
        Object value = null;
        if (index < size) {
            value = list[index];
            for (int i = index + 1; i < size; i++) {
                list[i - 1] = list[i];
            }
            list[size - 1] = null;
            size--;
        }
        return value;
    }

    public Object get(int index) {
        if (index < size) {
            return list[index];
        }
        return null;
    }

  
    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    public double calcularPromedio() {
        int suma = 0;
        for (int i = 0; i < size; i++) {
            suma += (int) list[i];
        }
        return (double) suma / size;
    }

    public int calcularModa() {
        int moda = (int) list[0];
        int maxRepeticiones = 1;

        for (int i = 0; i < size; i++) {
            int repeticiones = 1;
            for (int j = i + 1; j < size; j++) {
                if ((int) list[i] == (int) list[j]) {
                    repeticiones++;
                }
            }
            if (repeticiones > maxRepeticiones) {
                maxRepeticiones = repeticiones;
                moda = (int) list[i];
            }
        }

        return moda;
    }

    public double calcularMediana() {
        ordenarLista();
        if (size % 2 == 0) {
            return ((int) list[size / 2 - 1] + (int) list[size / 2]) / 2.0;
        } else {
            return (int) list[size / 2];
        }
    }

    private void ordenarLista() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((int) list[i] > (int) list[j]) {
                    Object temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList lista = new ArrayList();
        Random aleatorio = new Random();
        for (int i = 0; i < 50; i++) {
            lista.add(aleatorio.nextInt(100) + 1);
        }

        System.out.println("Números en la lista:");
        lista.printList();
        System.out.println("Promedio: " + lista.calcularPromedio());
        System.out.println("Moda: " + lista.calcularModa());
        System.out.println("Mediana: " + lista.calcularMediana());
    }
}

	

