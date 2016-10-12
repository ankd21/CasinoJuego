package casinoJuegos;

//import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;


public class Craps  extends Juego{



	


	public Craps() {
		super();
		
	}

	public Craps(int cantidaDeJugadores, double importeDeApuesta, String nombreDelJuego) {
		super(cantidaDeJugadores, importeDeApuesta, nombreDelJuego);
		
	}

	public Craps(double importeDeApuesta, String nombreDelJuego) {
		super(importeDeApuesta, nombreDelJuego);
		this.setCantidaDeJugadores(1);
	
	}

	public Craps(int cantidaDeJugadores, double importeDeApuesta) {
		super(cantidaDeJugadores, importeDeApuesta);
		
	}

	



















	public void JugarListaCraps(LinkedList<Jugador> listjugadores){
		
		int tiraDadoUno,tiraDadoDos;
	
		
		Random tiraDado = new Random();
		Random sigueAleatorioBoolean = new Random();
		int sumaDado;
		boolean bandera;
	    Jugador unjugador;
	   
	    
	    
		while(listjugadores.isEmpty()!=true){
		   bandera=true;
		   while(bandera &&listjugadores.isEmpty()!=true){
			  
			   tiraDadoUno=(int)(tiraDado.nextDouble() * 6 + 1);
			   tiraDadoDos=(int)(tiraDado.nextDouble() * 6 + 1);
			   
			   sumaDado=tiraDadoUno+tiraDadoDos; 
				  unjugador= listjugadores.peek();
				  
				 if(unjugador.getCantDejugadas() > 0 && sumaDado==7 ){ 
					    System.out.println("El jugador: " +unjugador.getIdjugador()+" TIRO : "+ tiraDadoUno+"+"+tiraDadoUno+"= "+sumaDado+"  PERDIO SU APUESTA !! abandona.. ");
					    listjugadores.poll();
				 }else if((sumaDado==7 ||sumaDado==11 )&& unjugador.getCantDejugadas() ==0){
		    	  unjugador= listjugadores.peek();
		    	 
		    	        if(sigueAleatorioBoolean.nextBoolean()==true){
		    		     System.out.println("El jugador: " +unjugador.getIdjugador()+" TIRO : "+ tiraDadoUno+"+"+tiraDadoUno+"= "+sumaDado+"   GANA SU APUESTA !! y sigue " );
		    	         unjugador=listjugadores.poll();
		    	         listjugadores.addLast(unjugador);
		    	   	  
				    	  bandera=true;  
		    	         }else{
		    		          System.out.println("El jugador: " +unjugador.getIdjugador()+" TIRO : "+ tiraDadoUno+"+"+tiraDadoUno+"= "+sumaDado+"   GANA SU APUESTA !! y se retira");
		    		          unjugador=listjugadores.poll();
		    		          bandera=false;  
		    	         }
		    	  
		    
		    	
		         }else if(sumaDado==2||sumaDado==3 ||sumaDado==12){
		    	   unjugador= listjugadores.peek();
		    	    System.out.println("El jugador: " +unjugador.getIdjugador()+" TIRO : "+ tiraDadoUno+"+"+tiraDadoUno+"= "+sumaDado+"  PERDIO SU APUESTA !! abandona.. ");
		    	    listjugadores.poll();
		    		bandera=false;  
		       }else {
		    	  unjugador= listjugadores.peek();
		    	   System.out.println("El jugador: " +unjugador.getIdjugador()+" TIRO : "+ tiraDadoUno+"+"+tiraDadoUno+"= "+sumaDado+"  SIGUE TIRANDO!! .. ");
		    	   unjugador=listjugadores.poll();
		    	   unjugador.setCantDejugadas(1);
		    	   listjugadores.addFirst(unjugador);
		    	   JugarListaCraps(listjugadores);
		    	  
		      }
		      
		      
		      
		    	  
		   }//end while 2
		   
		
		}//end while 1
		
		
		}
	@Override
	public void Jugar() {
		System.out.println("____________________INCIO DEL JUEGO CRAPS_________________________");
		System.out.println("cantidad de jugadores : |"+this.getCantidaDeJugadores()+ "| importe de apuesta por jugador :"+this.getImporteDeApuesta());
		System.out.println("");System.out.println("");
	
		LinkedList<Jugador> listaDejugadoresCrap= new LinkedList<Jugador>();
				 
		 for (int i=1; i<= this.getCantidaDeJugadores();i++){
			    Jugador unjugador = new Jugador(i,0); // i es id de jugador , 0  es cantidad de jugadas 
				listaDejugadoresCrap.add(unjugador);
				
			}
		 
		 
	
		
		JugarListaCraps(listaDejugadoresCrap);
		
		
		System.out.println("");System.out.println("");
		System.out.println("____________________FIN  DEL JUEGO CRAPS_________________________");
	}


	@Override
	public double totalApuesta() {
		
		 return  this.getCantidaDeJugadores()*this.getImporteDeApuesta();
	}


	@Override
	public double totalPremio() {
	
		return totalApuesta()-totalComicion();
	}


	@Override
	public double totalComicion() {
		
		int comicion=24;//% de comicion
		return totalApuesta()*comicion/100;
	}

}
