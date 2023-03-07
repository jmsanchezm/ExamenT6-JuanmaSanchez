package examen;

public class Main {

	public static void main(String[] args) {
		
		String palabra=" ";//Se guardará la palabra
		String letra; //Se guardará la letra
		int opcion; //Se guardará la opcion que elija
		int intentos=Ahorcado.NUMINTENTOS; //Se guardará el número de intentos disponibles
		
		//Generamos la palabra llamando a la siguiente función
		Ahorcado.generaPalabra();
		
		//Se le mostrará la pista
		for (int i =0; i< Ahorcado.palabraSecreta.length();i++) {
			Ahorcado.palabraPista+= "_ ";
		}
		
		System.out.println(Ahorcado.palabraPista);
		
		//Mientras que la palabra sea distinta de palabraSecreta y los intentos sean mayores o igual a 0
		while(!palabra.equals(Ahorcado.palabraSecreta)|| intentos>=0) {
			//Abrimos el switch 
			switch (Ahorcado.menu()) {
			//En el primer caso
			case 1:
				//Pedimos una letra
				System.out.println("Introduzca una letra: ");
				//Leemos la letra
				letra=Ahorcado.read.next();
				//Llamamos a la funcion que compruebe la letra
				Ahorcado.compruebaLetra(letra);
				//Salimos del switch
				break;
				
			//En el segundo caso
			case 2:
				//Solictamos una palabra
				System.out.println("Introduzca una palabra: ");
				//Leemos la palabra
				palabra=Ahorcado.read.next();
				//Comprobamos si la palabra es igual llamando a la funcion
				Ahorcado.compruebaPalabra(palabra);
				//Salimos del switch
				break;
			//En el caso de que introduzca un valor distinto, se le mostrará de nuevo el menú
			default:
				Ahorcado.menu();
			}
			//Una vez haya salido del switch, se mostrará la pista
			Ahorcado.pintaPista();
			//Y el número de intentos disponibles.
			System.out.println("Te quedan "+ --intentos + " intentos");
		}
	
		//Si una vez que sale del bucle la palabra es igual, se le mostrará que ha ganado
		if(palabra.equals(Ahorcado.palabraSecreta)) {
			System.out.println("“¡¡ENHORABUENA!! HAS ACERTADO”");
		}
		//Si los intentos han llegado a 0, se le mostrará que ha perdido
		if (intentos<=0) {
			System.out.println("GAME OVER");
		}
	}

}
