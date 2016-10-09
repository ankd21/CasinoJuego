package casinoJuegos;

import java.util.ArrayList;
//import java.util.Random;




public class Main {
	public static ArrayList<Juego> juegosCasino = new ArrayList<Juego>();
	public static void main(String[] args) {
		
		//Random m = new Random();
                                //cantidad de jugadores , importe, nombredeljuego		
		Juego crap = new Craps(5,30.0,"craps");
		// cantidaDeJugadores, modo principia avanzad,  importeDeApuesta
		Juego ahoracad = new Ahorcado(3,"principiante",10.0);
		Juego elpunto = new Elpunto(12,34.0,"craps");
		Juego ahoracad1 = new Ahorcado(3,"principiante",10.0);
		Juego ahoracad2 = new Ahorcado(3,"principiante",10.0);
		Juego ahoracad3 = new Ahorcado(3,"principiante",10.0);
		Juego ahoracad4 = new Ahorcado(3,"principiante",10.0);
		juegosCasino.add(crap);
		juegosCasino.add(elpunto);;
		juegosCasino.add(ahoracad);
	
		juegosCasino.add(ahoracad1);
		juegosCasino.add(ahoracad2);
		juegosCasino.add(ahoracad3);
		juegosCasino.add(ahoracad4);
			

		for (Juego juegos: juegosCasino) {
			
			juegos.Jugar();//
		}
		
		
		
		
		
	}

}
