package casinoJuegos;

//import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;


public class Craps  extends Juego{

	
	int IdJugador;
	int Cantjugadas;


	public Craps(double importeDeApuesta, String nombreDelJuego, int idJugador) {
		super(importeDeApuesta, nombreDelJuego);
		IdJugador = idJugador;
	}


	public Craps() {
		super();
		
	}

	public Craps(int cantidaDeJugadores, double importeDeApuesta, String nombreDelJuego) {
		super(cantidaDeJugadores, importeDeApuesta, nombreDelJuego);
		
	}

	public Craps(double importeDeApuesta, String nombreDelJuego) {
		super(importeDeApuesta, nombreDelJuego);
	
	}

	public Craps(int cantidaDeJugadores, double importeDeApuesta) {
		super(cantidaDeJugadores, importeDeApuesta);
		
	}

	














	@Override
	public void totalApuesta() {

		
	}

	@Override
	public void totalPremio() {
		
	}

	@Override
	public void totalComicion() {
		
		
	}



	public int getIdJugador() {
		return IdJugador;
	}


	public void setIdJugador(int idJugador) {
		IdJugador = idJugador;
	}

	public int getCantjugadas() {
		return Cantjugadas;
	}

	public void setCantjugadas(int cantjugadas) {
		Cantjugadas = cantjugadas;
	}



	public void JugarListaCraps(LinkedList<Craps> lcraps){
		int tiraDadoUno,tiraDadoDos;
	
		
		Random tiraDado = new Random();
		Random sigeOnosigue = new Random();
		int sumaDado;
		boolean bandera;
	    Craps unCraps;
		while(lcraps.isEmpty()!=true){
		   bandera=true;
		   while(bandera &&lcraps.isEmpty()!=true){
			  
			   tiraDadoUno=(int)(tiraDado.nextDouble() * 6 + 1);
			   tiraDadoDos=(int)(tiraDado.nextDouble() * 6 + 1);
			   
			   sumaDado=tiraDadoUno+tiraDadoDos; 
				  unCraps= lcraps.peek();
				  
				 if(unCraps.getCantjugadas() > 0 && sumaDado==7 ){ 
					    System.out.println("jugador: " +unCraps.getIdJugador()+" TIRO : "+ tiraDadoUno+"+"+tiraDadoUno+"= "+sumaDado+"  PERDIO SU APUESTA !! abandona.. "+"____________________________"+ unCraps.getIdJugador()+" ___jugadas"+unCraps.getCantjugadas());
					    lcraps.poll();
				 }else if((sumaDado==7 ||sumaDado==11 )&& unCraps.getCantjugadas() ==0){
		    	  unCraps= lcraps.peek();
		    	 
		    	        if(sigeOnosigue.nextBoolean()==true){
		    		     System.out.println("jugador: " +unCraps.getIdJugador()+" TIRO : "+ tiraDadoUno+"+"+tiraDadoUno+"= "+sumaDado+"   GANA SU APUESTA !! y sigue " );
		    	         unCraps=lcraps.poll();
		    	         lcraps.addLast(unCraps);
		    	   	  
				    	  bandera=true;  
		    	         }else{
		    		          System.out.println("jugador: " +unCraps.getIdJugador()+" TIRO : "+ tiraDadoUno+"+"+tiraDadoUno+"= "+sumaDado+"   GANA SU APUESTA !! y se retira"+"____________________________"+ unCraps.getIdJugador()+" ___jugadas"+unCraps.getCantjugadas());
		    		          unCraps=lcraps.poll();
		    		          bandera=false;  
		    	         }
		    	  
		    
		    	
		         }else if(sumaDado==2||sumaDado==3 ||sumaDado==12){
		    	   unCraps= lcraps.peek();
		    	    System.out.println("jugador: " +unCraps.getIdJugador()+" TIRO : "+ tiraDadoUno+"+"+tiraDadoUno+"= "+sumaDado+"  PERDIO SU APUESTA !! abandona.. "+"____________________________"+ unCraps.getIdJugador());
		    	    lcraps.poll();
		    		bandera=false;  
		       }else {
		    	  unCraps= lcraps.peek();
		    	   System.out.println("jugador: " +unCraps.getIdJugador()+" TIRO : "+ tiraDadoUno+"+"+tiraDadoUno+"= "+sumaDado+"  SIGUE TIRANDO!! .. ");
		    	   unCraps=lcraps.poll();
		    	   unCraps.setCantjugadas(1);
		    	   lcraps.addFirst(unCraps);
		    	   JugarListaCraps(lcraps);
		    	  
		      }
		      
		      
		      
		    	  
		   }//end while 2
		   
		
		}//end while 1
		 
	
		}
	@Override
	public void Jugar() {
		
		Random m = new Random();
		LinkedList<Craps> listaDejugadoresCraps= new LinkedList<Craps>();
		
		for (int i=1; i<= this.getCantidaDeJugadores();i++){
			
			Craps uno= new Craps((m.nextDouble()*10.0+10.0),this.getNombreDelJuego(),i);
			listaDejugadoresCraps.add(uno);
			
		}
		
		
		JugarListaCraps(listaDejugadoresCraps);
		
		
		  
		
	}

}
