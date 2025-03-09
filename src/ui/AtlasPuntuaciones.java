// Análisis: 
// Descripción del programa:
// Entradas:
// Salidas:
// Ejemplo:


package ui; 

import java.util.Scanner; 

public class AtlasPuntuaciones {

	public static void main(String[] args) {
		AtlasPuntuaciones mainApp = new AtlasPuntuaciones();
		mainApp.run();
	}

	private Scanner escaner;

	// Declaración de nuestras constantes a utilizar
	int numJugadores;
	int numRondas;
	int puntajes;
	int registrarPuntajes;
	int calcularYmostrarResultados;

	private AtlasPuntuaciones() {
		escaner = new Scanner(System.in);
	}
	
	public void run()
	{
		System.out.println("Ingrese el numero de jugadores: ");
		numJugadores = escaner.nextInt();

		System.out.println("Ingrese el numero de rondas: ");
		numRondas = escaner.nextInt();

		int [][] puntajes = registrarPuntajes(numJugadores, numRondas);
		calcularYmostrarResultados(puntajes);

	}

	public int[][] registrarPuntajes(int numJugadores, int numRondas) {
		int[][] puntajes = new int [numJugadores][numRondas];
	 	for (int i = 0; i < numJugadores; i++) {
			System.out.println("Jugador " + ( i + 1));
			for (int j = 0; j < numRondas; j++) {
				System.out.println("Puntaje en la ronda " + ( j + 1) + ": ");
				puntajes[i][j] = escaner.nextInt();
			}
		}
		return puntajes;
	} 
	
	public void calcularYmostrarResultados(int [][] puntajes){
		int numJugadores = puntajes.length;
		int numRondas = puntajes[0].length;

		int[] puntuacionesTotal = new int[numJugadores];
		double[] promedios = new double[numJugadores];
		int jugadorGanador = 0;
		int puntuacionMax = 0;

		System.out.println("Resultados del torneo:");

		for (int i = 0; i < numJugadores; i++) {
			puntuacionesTotal[i] = calcularSumaTotal(puntajes[i]);
			promedios[i] = calcularPromedio(puntajes[i]);

			System.out.println("Jugador " + (i + 1) + " - Puntaje Total: " + puntuacionesTotal[i] + ", Promedio: " + promedios[i]);
			
			if (puntuacionesTotal[i] > puntuacionMax) {
				puntuacionMax =  puntuacionesTotal[i];
				jugadorGanador = i;
			}
		}

		System.out.println("El jugador con la puntuación más alta es: Jugador " + (jugadorGanador + 1));
		
	}	
	
	//Descripción: El método calcularSumaTotal permite calcular los puntos de los jugadores en cada ronda jugada.
	// @param int[] numeros
    public int calcularSumaTotal(int[] numeros) {
        int suma = 0;
		for (int numero : numeros) {
		suma += numero;
		}
		return suma;
    }

	//Descripción: El método calcularPromedio permite calcular el promedio de puntaje de cada jugador.
	//@param int[] numeros
	public double calcularPromedio(int [] numeros) {
		return (double) calcularSumaTotal(numeros) / numeros.length; 
	}

	//Descripción: El método encontrarMayor permite hallar el jugador con mayor puntaje acumulado.
	//@param double[] numeros
    public double encontrarMayor(double[] numeros) {
		if (numeros == null || numeros.length == 0) {
			return 0.0;
		}

		double mayor = numeros[0];
		for (double numero : numeros) {
			if (numero > mayor) {
				mayor = numero;
			}
		}
		return mayor;
    }
	
}