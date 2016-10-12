package casinoJuegos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
//import java.util.Random;




public class Main {
	public static ArrayList<Juego> juegosCasino = new ArrayList<Juego>();
	public static void main(String[] args) {
		
		
	  
	    
		
		         
	//	cantjugadoresAhorcado();
			
		Juego elpunto = new Elpunto(cantjugadores(), importeJuego(), " EL Punto");
		Juego crap = new Craps(cantjugadores() ,importeJuego(),"Craps");
		Juego ahoracad = new Ahorcado(cantjugadoresAhorcado(),modoJugador(),importeJuego());		
		juegosCasino.add(elpunto);
		juegosCasino.add(crap);
		juegosCasino.add(ahoracad);
	
	    

		for (Juego juegos: juegosCasino) {
			
		juegos.Jugar();
		
		}
		
		
	     for (Juego juegos: juegosCasino) {
			
			System.out.println("total apuesta  del juego "+juegos.getNombreDelJuego()+":  $"+juegos.totalApuesta() );
			System.out.println("total comicion  del juego "+juegos.getNombreDelJuego()+":  $"+juegos.totalComicion() );
			System.out.println("total premio  del juego "+juegos.getNombreDelJuego()+":  $"+juegos.totalPremio() );
			System.out.println("---------------------------------------------------------");
		
		}
	     
	     
	     double totaldeApuesta=0.0;
	     double totaldeComicion=0.0;
	    double totalPremio=0.0;
	     for (Juego juegos: juegosCasino) {
				
	    	 totaldeApuesta=totaldeApuesta+juegos.totalApuesta();
		      totaldeComicion= totaldeComicion+juegos.totalComicion();
		     totalPremio= totalPremio+juegos.totalPremio();
				
			
		}
	     
	        System.out.println("total apuesta en Casino "+totaldeApuesta);
			System.out.println("total comicion  en Casino "+   totaldeComicion);
			System.out.println("total premio  en casino "+  totalPremio);
			System.out.println("---------------------------------------------------------");
	     
	}


	
	
	
	static  int cantjugadores(){
		Random aleatorio = new Random();
		return   aleatorio.nextInt(5)+2;
	}
	static  int cantjugadoresAhorcado(){
		Random aleatorio = new Random();
		return   aleatorio.nextInt(3)+1;
	}
	
	static  String modoJugador(){
		
		Random aleatorio = new Random();
		String modo="";
		if(aleatorio.nextBoolean())
			modo="principiante";
		else{
			
			modo="avanzado";
		}
			
		return   modo;
	}
     static  double importeJuego(){
	Random aleatorio = new Random();
		
	double imp = aleatorio.nextDouble()*300.0+10.0;
    double importe = Math.rint(imp*100)/100;
    
    return importe;
    
	}
	
}
