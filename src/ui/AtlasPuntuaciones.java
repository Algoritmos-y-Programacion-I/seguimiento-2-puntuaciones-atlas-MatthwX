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

			System.out.println(" Jugador: " + (i + 1));
			System.out.println("Puntajes: ");
		}
	}
	
	//Descripción: El método calcularSumaTotal permite calcular los puntos de los jugadores en cada ronda
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

	/**
	 * Descripción: El método encontrarMayor permite ...
	 * @param double[] numeros
	 * @return 
	 */
    /*public double encontrarMayor(double[] numeros) {
        // Completar
    }*/

	

	
}