package queue;

import java.util.Scanner;

public class MaquinaDispensadora {

	public static void main(String[] args) {
		CircularQueue Agua = Productos(10);
		CircularQueue Refresco = Productos(10);
		CircularQueue Chicles = Productos(10);
		CircularQueue Papas = Productos(10);
		CircularQueue Galletas = Productos(10);
		CircularQueue Pan = Productos(10);
		CircularQueue Gomitas = Productos(10);
		CircularQueue Jugo = Productos(10);
		CircularQueue Leche = Productos(10);
		CircularQueue Cacahuates = Productos(10);
		CircularQueue Moneda10 = Monedas(15);
		CircularQueue Moneda5 = Monedas(15);
		CircularQueue Moneda2 = Monedas(15);
		CircularQueue Moneda1 = Monedas(15);
		CircularQueue Moneda50 = Monedas(15);
		int precioAgua = 10;
		int precioRefresco = 15;
		int precioChicles = 10;
		int precioPapas = 20;
		int precioGalletas = 18;
		int precioPan = 14;
		int precioGomitas = 10;
		int precioJugo = 15;
		int precioLeche = 10;
		int precioCacahuates = 10;
		String AGUA = "Botella de Agua de 1000ml";
		String REFRESCO = "Refresco sabor limon de 500ml";
		String CHICLES = "Paquete de 10 chicles de sabor menta";
		String PAPAS = "Papas sabor BBQ";
		String GALLETAS = "Paquete de galletas sabor chocolate";
		String PAN = "Concha pan dulce";
		String GOMITAS = "Gomitas de Osito";
		String JUGO = "Jugo sabor mango de 500ml";
		String LECHE = "Leche Deslactosada de 250ml";
		String CACAHUATES = "Paquete de Cacahuates";
		Scanner sc = new Scanner(System.in);
		boolean continuar = true;
		while (continuar) {
			System.out.println("\n--- Menú de Máquina Dispensadora ---");
			System.out.println("1. Agregar productos");
			System.out.println("2. Agregar monedas para cambio");
			System.out.println("3. Hacer una venta");
			System.out.println("4. Consultar productos y monedas");
			System.out.println("5. Salir");
			System.out.print("Seleccione una opción: ");
			int opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				agregarProductos(sc, Agua, Refresco, Chicles, Papas, Galletas, Pan, Gomitas, Jugo, Leche, Cacahuates);
				break;
			case 2:
				agregarMonedas(sc, Moneda10, Moneda5, Moneda2, Moneda1, Moneda50);
				break;
			case 3:
				hacerVenta(sc, Agua, Refresco, Chicles, Papas, Galletas, Pan, Gomitas, Jugo, Leche, Cacahuates,
						precioAgua, precioRefresco, precioChicles, precioPapas, precioGalletas, precioPan,
						precioGomitas, precioJugo, precioLeche, precioCacahuates, AGUA, REFRESCO, CHICLES, PAPAS,
						GALLETAS, PAN, GOMITAS, JUGO, LECHE, CACAHUATES, Moneda10, Moneda5, Moneda2, Moneda1, Moneda50);
				break;
			case 4:
				mostrarEstadoProductos(Agua, Refresco, Chicles, Papas, Galletas, Pan, Gomitas, Jugo, Leche, Cacahuates);
				mostrarEstadoMonedas(Moneda10, Moneda5, Moneda2, Moneda1, Moneda50);
				break;
			case 5:
				continuar = false;
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción no válida.");
			}
		}

		sc.close();
	}

	public static void agregarProductos(Scanner sc, CircularQueue Agua, CircularQueue Refresco, CircularQueue Chicles,
			CircularQueue Papas, CircularQueue Galletas, CircularQueue Pan, CircularQueue Gomitas, CircularQueue Jugo,
			CircularQueue Leche, CircularQueue Cacahuates) {

		System.out.println(" Agregar Productos ");
		System.out.println("A1 - Agua");
		System.out.println("R1 - Refresco");
		System.out.println("C1 - Chicles");
		System.out.println("P1 - Papas");
		System.out.println("G1 - Galletas");
		System.out.println("P2 - Pan");
		System.out.println("G2 - Gomitas");
		System.out.println("J1 - Jugo");
		System.out.println("L1 - Leche");
		System.out.println("C2 - Cacahuates");

		System.out.print("Ingrese el código del producto que desea agregar: ");
		String codigoProducto = sc.next().toUpperCase();
		CircularQueue colaProducto = obtenerColaProducto(codigoProducto, Agua, Refresco, Chicles, Papas, Galletas, Pan,
				Gomitas, Jugo, Leche, Cacahuates);

		if (colaProducto == null) {
			System.out.println("Código de producto no válido.");
			return;
		}

		System.out.print("¿Cuántos productos desea agregar? ");
		int cantidad = sc.nextInt();

		for (int i = 0; i < cantidad; i++) {
			if (!colaProducto.isFull()) {
				colaProducto.enqueue(new Object());
			} else {
				System.out.println("La cola de " + codigoProducto + " está llena.");
				break;
			}
		}

		System.out.println("Productos agregados exitosamente.");
	}

	
	public static void agregarMonedas(Scanner sc, CircularQueue Moneda10, CircularQueue Moneda5, CircularQueue Moneda2,
			CircularQueue Moneda1, CircularQueue Moneda50) {

		System.out.println("  Agregar Monedas para Cambio  ");
		System.out.println("Ingrese la denominación de la moneda (10, 5, 2, 1, 0.5): ");
		double denominacion = sc.nextDouble();
		CircularQueue colaMoneda = obtenerColaMoneda(denominacion, Moneda10, Moneda5, Moneda2, Moneda1, Moneda50);

		if (colaMoneda == null) {
			System.out.println("Denominación de moneda no válida.");
			return;
		}

		System.out.print("¿Cuántas monedas desea agregar? ");
		int cantidad = sc.nextInt();

		for (int i = 0; i < cantidad; i++) {
			if (!colaMoneda.isFull()) {
				colaMoneda.enqueue(denominacion);
			} else {
				System.out.println("La cola de monedas de " + denominacion + " está llena.");
				break;
			}
		}

		System.out.println("Monedas agregadas exitosamente.");
	}

	
	public static CircularQueue obtenerColaProducto(String codigoProducto, CircularQueue Agua, CircularQueue Refresco,
			CircularQueue Chicles, CircularQueue Papas, CircularQueue Galletas, CircularQueue Pan,
			CircularQueue Gomitas, CircularQueue Jugo, CircularQueue Leche, CircularQueue Cacahuates) {
		switch (codigoProducto) {
		case "A1":
			return Agua;
		case "R1":
			return Refresco;
		case "C1":
			return Chicles;
		case "P1":
			return Papas;
		case "G1":
			return Galletas;
		case "P2":
			return Pan;
		case "G2":
			return Gomitas;
		case "J1":
			return Jugo;
		case "L1":
			return Leche;
		case "C2":
			return Cacahuates;
		default:
			return null;
		}
	}

	public static CircularQueue obtenerColaMoneda(double denominacion, CircularQueue Moneda10, CircularQueue Moneda5,
			CircularQueue Moneda2, CircularQueue Moneda1, CircularQueue Moneda50) {
		if (denominacion == 10) {
			return Moneda10;
		} else if (denominacion == 5) {
			return Moneda5;
		} else if (denominacion == 2) {
			return Moneda2;
		} else if (denominacion == 1) {
			return Moneda1;
		} else if (denominacion == 0.5) {
			return Moneda50;
		} else {
			return null;
		}
	}

	public static void hacerVenta(Scanner sc, CircularQueue Agua, CircularQueue Refresco, CircularQueue Chicles,
			CircularQueue Papas, CircularQueue Galletas, CircularQueue Pan, CircularQueue Gomitas, CircularQueue Jugo,
			CircularQueue Leche, CircularQueue Cacahuates, int precioAgua, int precioRefresco, int precioChicles,
			int precioPapas, int precioGalletas, int precioPan, int precioGomitas, int precioJugo, int precioLeche,
			int precioCacahuates, String AGUA, String REFRESCO, String CHICLES, String PAPAS, String GALLETAS,
			String PAN, String GOMITAS, String JUGO, String LECHE, String CACAHUATES, CircularQueue Moneda10,
			CircularQueue Moneda5, CircularQueue Moneda2, CircularQueue Moneda1, CircularQueue Moneda50) {

		System.out.println("    Hacer Venta   ");
		System.out.println("A1 - Agua ($" + precioAgua + ")");
		System.out.println("R1 - Refresco ($" + precioRefresco + ")");
		System.out.println("C1 - Chicles ($" + precioChicles + ")");
		System.out.println("P1 - Papas ($" + precioPapas + ")");
		System.out.println("G1 - Galletas ($" + precioGalletas + ")");
		System.out.println("P2 - Pan ($" + precioPan + ")");
		System.out.println("G2 - Gomitas ($" + precioGomitas + ")");
		System.out.println("J1 - Jugo ($" + precioJugo + ")");
		System.out.println("L1 - Leche ($" + precioLeche + ")");
		System.out.println("C2 - Cacahuates ($" + precioCacahuates + ")");
		System.out.print("Ingrese el código del producto que desea comprar: ");
		String codigoProducto = sc.next().toUpperCase();
		int precio = obtenerPrecioProducto(codigoProducto, precioAgua, precioRefresco, precioChicles, precioPapas,
				precioGalletas, precioPan, precioGomitas, precioJugo, precioLeche, precioCacahuates);
		CircularQueue colaProducto = obtenerColaProducto(codigoProducto, Agua, Refresco, Chicles, Papas, Galletas, Pan,
				Gomitas, Jugo, Leche, Cacahuates);

		if (colaProducto == null || precio == -1) {
			System.out.println("Código de producto no válido.");
			return;
		}

		System.out.println("El precio del producto es $" + precio + ". Ingrese monedas hasta alcanzar el monto.");
		double totalMonedasIngresadas = 0;
		double falta = precio; 

		while (totalMonedasIngresadas < precio) {
			System.out.print("Ingrese moneda: ");
			double moneda = sc.nextDouble();
			totalMonedasIngresadas += moneda;
			falta = precio - totalMonedasIngresadas; 

			if (falta > 0) {
				System.out.println("Faltan $" + falta + " para completar el monto.");
			} else {
				break; 
			}
		}

		double cambio = totalMonedasIngresadas - precio;
		System.out.println("Venta realizada. El cambio es: $" + cambio);
	}

	
	public static int obtenerPrecioProducto(String codigoProducto, int precioAgua, int precioRefresco,
			int precioChicles, int precioPapas, int precioGalletas, int precioPan, int precioGomitas, int precioJugo,
			int precioLeche, int precioCacahuates) {
		switch (codigoProducto) {
		case "A1":
			return precioAgua;
		case "R1":
			return precioRefresco;
		case "C1":
			return precioChicles;
		case "P1":
			return precioPapas;
		case "G1":
			return precioGalletas;
		case "P2":
			return precioPan;
		case "G2":
			return precioGomitas;
		case "J1":
			return precioJugo;
		case "L1":
			return precioLeche;
		case "C2":
			return precioCacahuates;
		default:
			return -1; 
		}
	}

	
	public static void mostrarEstadoProductos(CircularQueue Agua, CircularQueue Refresco, CircularQueue Chicles,
	        CircularQueue Papas, CircularQueue Galletas, CircularQueue Pan, CircularQueue Gomitas, CircularQueue Jugo,
	        CircularQueue Leche, CircularQueue Cacahuates) {
	    
	    System.out.println("\n--- Estado de Productos ---");
	    System.out.println("Agua: " + Agua.size() + " unidades");
	    System.out.println("Refresco: " + Refresco.size() + " unidades");
	    System.out.println("Chicles: " + Chicles.size() + " unidades");
	    System.out.println("Papas: " + Papas.size() + " unidades");
	    System.out.println("Galletas: " + Galletas.size() + " unidades");
	    System.out.println("Pan: " + Pan.size() + " unidades");
	    System.out.println("Gomitas: " + Gomitas.size() + " unidades");
	    System.out.println("Jugo: " + Jugo.size() + " unidades");
	    System.out.println("Leche: " + Leche.size() + " unidades");
	    System.out.println("Cacahuates: " + Cacahuates.size() + " unidades");
	}
	public static void mostrarEstadoMonedas(CircularQueue Moneda10, CircularQueue Moneda5, CircularQueue Moneda2,
	        CircularQueue Moneda1, CircularQueue Moneda50) {

	    System.out.println("\n--- Estado de Monedas ---");
	    System.out.println("Monedas de $10: " + Moneda10.size() + " unidades");
	    System.out.println("Monedas de $5: " + Moneda5.size() + " unidades");
	    System.out.println("Monedas de $2: " + Moneda2.size() + " unidades");
	    System.out.println("Monedas de $1: " + Moneda1.size() + " unidades");
	    System.out.println("Monedas de $0.50: " + Moneda50.size() + " unidades");
	}
	
	public static CircularQueue Productos(int capacidad) {
		return new CircularQueue(capacidad);
	}

	
	public static CircularQueue Monedas(int capacidad) {
		return new CircularQueue(capacidad);
	}
}

