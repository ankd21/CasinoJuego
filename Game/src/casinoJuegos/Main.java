package casinoJuegos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
//import java.util.Random;




public class Main {
	public static ArrayList<Juego> juegosCasino = new ArrayList<Juego>();
	public static void main(String[] args) {
		
		
	  
	    
		
		         
		//Juego crap = new Craps(5,30.0,"craps");
		//Juego ahoracad = new Ahorcado(3,"principiante",10.0);				
		Juego elpunto = new Elpunto(cantjugadores(),  importeJuego(), "Craps");
	
		juegosCasino.add(elpunto);
		//juegosCasino.add(elpunto);;
		/*juegosCasino.add(ahoracad);
	
	    */

		for (Juego juegos: juegosCasino) {
			
			juegos.Jugar();
		
		}
		
		
	for (Juego juegos: juegosCasino) {
			
			juegos.totalApuesta();
		
		}
	}


	static  int cantjugadores(){
		Random aleatorio = new Random();
		return   aleatorio.nextInt(5)+2;
	}
     static  double importeJuego(){
	Random aleatorio = new Random();
		
	double imp = aleatorio.nextDouble()*300.0+10.0;
    double importe = Math.rint(imp*100)/100;
    
    return importe;
    
	}
	
}
