package examen;

import java.util.Scanner;

public class Ahorcado {
	/**
	 * Guardará el repertorio de palabras disponibles
	 */
	static String [] palabras= {"humanidad","persona", "hombre","mujer","individuo","cuerpo", "pierna","cabeza","brazo","familia"};
	/**
	 * Se guardará el número de intentos
	 */
	static final int NUMINTENTOS = 7;
	/**
	 * Se guardará la palabra secreta
	 */
	static String palabraSecreta;
	/**
	 * Almacenará la pista del juego
	 */
	static String palabraPista="";
	/**
	 * Almacenará las letras que no ha acertado el jugador
	 */
	static String noAcertadas=" ";
	/**
	 * Creamos el Scanner
	 */
	static Scanner read= new Scanner (System.in);
	
	/**
	 * Método que genera la palabra aleatoria del array palabras
	 */
	static void generaPalabra() {
		
		int posAleatoria; //Se guardará la posición aleatoria 
		
		//Generamos una posición aleatoria hasta el tamaño del array palabras
		posAleatoria= (int)(Math.random()*palabras.length);
		
		//Guardamos en palabraSecreta el contenido de la posición generada aleatoriamente
		palabraSecreta=palabras[posAleatoria];
	}
	
	/**
	 * Método que muestra por panatalla el menú, y obtiene la opcion 
	 * requerida por el usuario
	 * @return Devuelve la elección del usuario
	 */
	static int menu() {
		int opcion; //Se guardará la opción a elegir del usuario
		
		//Muestra por pantalla el menú y solicita dato
		System.out.println("Seleccione una de las siguientes opciones: ");
		System.out.println("1. Introducir letra");
		System.out.println("2. Introducir palabra");
		//Lee la opción a desear
		opcion=read.nextInt();
		
		//Devuelve la opción que el usuario ha elegido
		return opcion;
	}
	
	/**
	 * Método para comprobar que la letra introducida se encuentra en palabraSecreta
	 * En caso contrario, se almacenará en noAcertadas.
	 * @param letra Letra introducida por el usuario
	 */
	static void compruebaLetra (String letra) {
		int pos; //Se almacenará la posición en la que se encuentra en la palabra a adivinar
		//Pasamos la letra a minúsculas
		letra= letra.toLowerCase(); 
		//Buscamos la posición de la letra
		pos=palabraSecreta.indexOf(letra);
		
		//Si la posición de la letra es mayor o igual a cero
		if (pos>=0) {
			palabraSecreta.replace("_",letra);
			}
		//En caso contrario, guardará la letra en noAcertadas
		else {
			noAcertadas+=letra + " ";
		
		}
	}
	
	/**
	 * Método para comprobar si la palabra es igual
	 * @param palabra
	 */
	static void compruebaPalabra (String palabra) {
		//Si la palabrasSecreta, ignorando las mayusculas, es igual a palabra
		if (palabraSecreta.equalsIgnoreCase(palabra)) {
			//palabraPista es igual a palabra
			palabra=palabraPista;
			
		}
	}
	
	/**
	 * Método que mostrará las letras que ha usado y mostrará el contenido de palabraPista
	 */
	static void pintaPista () {
		//Se mostrará la cadena de palabra
		System.out.println(noAcertadas);
		//Muestra la pista 
		System.out.println(palabraPista);
	}
}
