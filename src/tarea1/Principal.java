package tarea1;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Dame la ecuacion a evaluar");
		String a = read.nextLine();
		ArrayStack stack = new ArrayStack(a.length());

		for (int i = 0; i < a.length(); i++) {
			char currentChar = a.charAt(i);
			if (currentChar == '(') {
				stack.push("(");
			} else if (currentChar == ')') {
				if (stack.isEmpty()) {
					System.out.println("Error: Paréntesis de cierre sin paréntesis de apertura.");
					return;
				}
				stack.pop();
			}
		}
		if (stack.isEmpty()) {
			System.out.println("Paréntesis balanceados correctamente.");
		} else {
			System.out.println("Error: Hay paréntesis de apertura sin cerrar.");
		}

		for (int i = 0; i < a.length(); i++) {
			char caracter = a.charAt(i);
			stack.push(caracter);
		}
		while (!stack.isEmpty()) {
			char top = (char) stack.peak(); 

			if (top != '1' && top != '2' && top != '3' && top != '4' && top != '5' && top != '6' && top != '7'
					&& top != '8' && top != '9' && top != '+' && top != '-' && top != '*' && top != '/') {
				stack.pop();
			} else {
				break;
			}
		}

		int resultado = stack.sumarElementos();
		System.out.println("Suma de los elementos: " + resultado);

	}
}
