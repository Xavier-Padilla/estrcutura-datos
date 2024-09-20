package examen;

import java.util.Random;

public class Principal {

	public static void main(String[] args) {

		ArrayStack stack = new ArrayStack(100);
		int suma = suma(stack);
		System.out.println("La suma es : " + suma);
		ArrayStack stackuno = new ArrayStack(10);
		ArrayStack stackdos = new ArrayStack(10);
		ArrayStack stacktres = new ArrayStack(20);
		random(stackuno);
		sumados(stackuno, stackdos);
		int resultado = operacion(stackdos);
		System.out.println("resultado: " + resultado);

		String[][] tabla = { { "write", "String", "int" }, { "read", "String" }, { "copy", "String", "String" },
				{ "remove", "String" }, { "substring", "int" }, { "substring", "int", "int" } };
		for (String[] empujar : tabla) {
			stacktres.push(empujar[0]);
			for (int i = 1; i < empujar.length; i++) {
				stacktres.push(empujar[i]);
			}
		}
		System.out.println("resultado: " + stacktres.toString());
	}

	public static int suma(ArrayStack stack) {
		Random random = new Random();
		int suma = 0;
		while (true) {
			int numero = random.nextInt(100) + 1;
			;
			stack.push(numero);
			if (numero == 50) {
				while (!stack.isEmpty()) {
					int valor = (int) stack.pop();
					System.out.println("valor: " + valor);
					suma += valor;
				}
				break;
			}
		}
		return suma;
	}

	public static void random(ArrayStack stack) {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int numero = random.nextInt(100) + 1;
			System.out.println("numero random: " + numero);
			stack.push(numero);
		}
	}

	public static void sumados(ArrayStack stack, ArrayStack stackdos) {
		while (stack.size() >= 2) {
			int num1 = (int) stack.pop();
			int num2 = (int) stack.pop();
			int suma = num1 + num2;
			System.out.println("suma: " + num1 + " + " + num2 + " = " + suma);
			stackdos.push(suma);
		}
	}

	public static int operacion(ArrayStack stack) {
		int primero = (int) stack.pop();
		int segundo = (int) stack.pop();
		int resultado = primero - segundo;
		int ultimo = (int) stack.pop();
		resultado *= ultimo;
		ultimo = (int) stack.pop();
		resultado += ultimo;
		ultimo = (int) stack.pop();
		resultado -= ultimo;
		return resultado;
	}

}