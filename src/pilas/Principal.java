package pilas;

public class Principal {
	public static void main(String[] args) {

		// String a = "5 + 7 * 2";
		// String a = "(5+7) * (6*8)";
		String a = "10/5";

		ArrayStack stack = new ArrayStack(a.length());
		ArrayStack stack1 = new ArrayStack(a.length());
		StringBuilder numero = new StringBuilder();

		for (int i = 0; i < a.length(); i++) {
			char currentChar = a.charAt(i);

			if (Character.isDigit(currentChar)) {
				numero.append(currentChar);
			} else {
				if (numero.length() > 0) {
					stack.push(Integer.parseInt(numero.toString()));
					numero.setLength(0);
				}

				if (currentChar == ' ') {
					continue;
				}

				if (currentChar == '(') {
					stack1.push(currentChar);
				} else if (currentChar == ')') {
					while (!stack1.isEmpty() && (char) stack1.peak() != '(') {
						fraccion(stack, stack1);
					}
					stack1.pop(); 
				} else if (operacion(currentChar)) {
					while (!stack1.isEmpty() && jerarquia(currentChar) <= jerarquia((char) stack1.peak())) {
						fraccion(stack, stack1);
					}
					stack1.push(currentChar);
				}
			}
		}

		if (numero.length() > 0) {
			stack.push(Integer.parseInt(numero.toString()));
		}

		while (!stack1.isEmpty()) {
			fraccion(stack, stack1);
		}

		System.out.println("Resultado: " + stack.pop());
	}

	private static boolean operacion(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	private static int jerarquia(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 0;
		}
	}

	private static void fraccion(ArrayStack stack, ArrayStack stack1) {
		int b = (int) stack.pop();
		int a = (int) stack.pop();
		char operator = (char) stack1.pop();

		int result = 0;
		switch (operator) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		case '*':
			result = a * b;
			break;
		case '/':
			if (b != 0) {
				result = a / b;
			} else {
				System.out.println("División por cero");
			}
			break;
		}
		stack.push(result);
	}
}
