package casinoJuegos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;

public class Ahorcado extends Juego {
 
      String modo;
      String [] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M","N","O","P","Q","R","S","T","U","V","W", "X","Y","Z","-2" };
      String [] dibujoahorcado= {"------_------", "      |     ", "     (o)     ","    /{ }\\   ", "     / \\    ", "     | |    ", "   --   --   " };
	
		 AleatorioSinRepetir aleato = new  AleatorioSinRepetir(0,25);

		 AleatorioSinRepetir aleatorioPalabrInteger = new  AleatorioSinRepetir(0,this.obtenerListaDepalabras().size()-1);
	
      public Ahorcado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ahorcado(double importeDeApuesta, String nombreDelJuego) {
		super(importeDeApuesta, nombreDelJuego);
		// TODO Auto-generated constructor stub
	}

	public Ahorcado(int cantidaDeJugadores, double importeDeApuesta, String nombreDelJuego) {
		super(cantidaDeJugadores, importeDeApuesta, nombreDelJuego);
		// TODO Auto-generated constructor stub
	}

	public Ahorcado(int cantidaDeJugadores, double importeDeApuesta) {
		super(cantidaDeJugadores, importeDeApuesta);
		// TODO Auto-generated constructor stub
	}
	public Ahorcado(int cantidaDeJugadores,String modo, double importeDeApuesta) {
		super(cantidaDeJugadores, importeDeApuesta);
		this.modo = modo;
		// TODO Auto-generated constructor stub
	}
	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

	@Override
	public void totalApuesta() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void totalPremio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void totalComicion() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see casinoJuegos.Juego#Jugar()
	 */
	@Override
	public void Jugar() {
		
	Random aleatorio = new Random();
		
	
	Stack<String> pilaDibujoAhorcado= new Stack<String>();
		
	
		Jugador unjugador ;
		LinkedList<Jugador> listajugadores= new LinkedList<Jugador>();
		
	
		
		String palabraAjugar= this.obtenerListaDepalabras().get(((int)(aleatorio.nextDouble() *  this.obtenerListaDepalabras().size()+ 0)));
	
		ArrayList<Character> letralist= new ArrayList<Character>();//creo un array de lista para almacenar letra
		

		//cargando palabra con _
		for(int i=0;i<palabraAjugar.length();i++){letralist.add('-');}
		
		
		
		
		
		
		String letraGenerada="";
		boolean band=true;
		ArrayList<Character> mostrarpalabraenCurso;
		
		Jugador unjugad = new Jugador();
		
		boolean banderaGanador=true;
		//.....;........................
		if (this.getModo()=="principiante"){
			System.out.println("____________AHORCADO MODO PRINCIPIANTE____________");
		for(int i=0;i<this.getCantidaDeJugadores();i++){
              System.out.println("cantidad  de jugadores :"+(i+1));
			
			unjugador = new Jugador(i+1,0,7);
		listajugadores.add(unjugador);
		}
		}else{
			System.out.println("____________AHORCADO MODO AVANZADO____________");
			
			
			int al = (int)(aleatorio.nextDouble() * this.getCantidaDeJugadores() + 1);
			System.out.println("aleatorio" +al);
			for(int i=0;i<this.getCantidaDeJugadores();i++){
				
				unjugador = new Jugador(i,0,4);
				listajugadores.add(unjugador);
			}
			
		}
		System.out.print("cantidad de caracter es "+ palabraAjugar.length());
		System.out.print("  letras es "+ palabraAjugar +" ");
		
		
		 AleatorioSinRepetir aleato = new  AleatorioSinRepetir(0,25);
		for(int i=0;i<palabraAjugar.length();i++){System.out.print(letralist.get(i));}//muestras la letra oculta
		
		System.out.println(" ");
		
		
		while(!listajugadores.isEmpty()){
			//unjugad=listajugadores.peek();
			 unjugad=listajugadores.poll();
			 
			// System.out.println(" Jugador----------------------------   |"+ unjugad.getIdjugador()+"|   vidaa :"+  unjugad.getVidasParaJugar());
			
			 if(unjugad.getVidasParaJugar()!=0){
		                      
				
		                 		 letraGenerada= abecedario[aleato.generar()];


		                 		if(existeletra(palabraAjugar,letraGenerada) ==1){//si letra  existe en la   palabra vuelvo a tirar
		                 		
		                 			System.out.println("jugador- :" +unjugad.getIdjugador() +" asigno "+letraGenerada );
		                 			mostrarListaCaracter(remplazarLetraEncontrada(palabraAjugar,letraGenerada,letralist));
		                 			System.out.println(" ");
		                 			if (letraEsAdivinada(letralist,palabraAjugar)){
		                 				System.out.println(" GANA JUGADOR :   "+unjugad.getIdjugador()+" felicitaciones !!");
		                 				
		                 				while(!listajugadores.isEmpty()){
		                 					System.out.println(" El jugador :  "+listajugadores.poll().getIdjugador()+ " pierde su juego");
		                 					
		                 					
		                 				}
		                 			           
		                 			           
		                 			}
		                 			 band=true;
		                 			
		          		                          while(band==true &&!listajugadores.isEmpty()){
		          		                                   	        letraGenerada=lanzaUnaLetraOpalabraCompleta();//si letra  existe vuelvo a tirar
		          		       	                                     if(existeletra(palabraAjugar,letraGenerada) ==1){
		          		       		
		          		       	                                     System.out.println("jugador-+ :" +unjugad.getIdjugador() +" asigno "+letraGenerada );
		          		      		                 			     mostrarListaCaracter(remplazarLetraEncontrada(palabraAjugar,letraGenerada,letralist));
		          		      		                 			     System.out.println(" ");
		          		      		                 			if (letraEsAdivinada(letralist,palabraAjugar)){
		          		  		                 				System.out.println(" GANA JUGADOR :   "+unjugad.getIdjugador()+" felicitaciones !!");
		          		  		                 				
		          		  		                 				while(!listajugadores.isEmpty()){
		          		  		                 					System.out.println(" El jugador :  "+listajugadores.poll().getIdjugador()+ " pierde su juego");
		          		  		                 					
		          		  		                 					
		          		  		                 				}
		          		  		                 			           
		          		  		                 			           
		          		  		                 			}
		          		       		
		          		       	                                      }else if (existeletra(palabraAjugar,letraGenerada)==2){
		          		       	                                    	System.out.println(" GANA JUGADOR :   "+unjugad.getIdjugador()+" felicitaciones !!");
				          		  		                 				
				          		  		                 				while(!listajugadores.isEmpty()){
				          		  		                 					System.out.println(" El jugador :  "+listajugadores.poll().getIdjugador()+ " pierde su juego");
				          		  		                 					
				          		  		                 					
				          		  		                 				}
				          		  		                 			           
		          		       	                                    	  
		          		       	                                      }else{//la letra no existe
		          		       	                                    	  
		          		       	                                    	       band=false;
		          		       	                                    		  
		          		       	                                    	         System.out.println(" Jugador   |"+ unjugad.getIdjugador()+"|   asigno :"+ letraGenerada);
		          		       						                
		          		       		    		                                  unjugad.setVidasParaJugar(	unjugad.getVidasParaJugar()-1);
		          		       					                                  System.out.println("pierde un punto cant "+ unjugad.getVidasParaJugar());
		          		       				                   	
		          		       				               		                  Stack<String> pilacopi = unjugad.getPilaDibujoAhorcado();
		          		       		  		               	                      pilacopi.push(dibujoahorcado[unjugad.getVidasParaJugar()]);//voy dibujando el ahoracado
		          		       				               		
		          		       				               		                  unjugad.setVidasParaJugar(unjugad.getVidasParaJugar());
		          		       				               		                  Stack<String> agrega = mostrarPilaDeVida(pilacopi);
		          		       				               		                  unjugad.setPilaDibujoAhorcado(agrega);
		          		       				               		        
		          		       				               		                  listajugadores.addFirst(unjugad);
		          		       	                                    		  
		          		       	                                    	
		          		       	                                    	        
		          		       	                                    	  
		          		       	                                                     if(listajugadores.peekFirst().getVidasParaJugar()==0){
		          		       	   		                    	                              //System.out.println(" Jugador   |"+ unjugad.getIdjugador()+"|   pierde juego ");
		          		       	   		                    	                                 System.out.println(" Jugador   |"+ unjugad.getIdjugador()+"|    -----------PIERDE JUEGO----- (GAME OVER)  !!!");
		          		       	   		                    	                              listajugadores.poll();
		          		       	   		                    	
		          		       	   		                                               }else{
		          		       	   		               		
		          		       	   		                     	                            listajugadores.addLast(listajugadores.poll());
		          		       	   		                                               }
		          		       	                                    	  
		          		       	                                    	  
		          		       	                                           }
		          		       	                                      
		          		        	   
		          		        	   
		          		        	 
		          		        	 
		          		        	   
		          		                                  }
		                 			
		                 			
		                 			
		                 			
		                 		}else if (existeletra(palabraAjugar,letraGenerada) ==2){
		                 			
		                 			
	  		                 				System.out.println(" GANA JUGADOR :   "+unjugad.getIdjugador()+" felicitaciones !!");
	  		                 				
	  		                 				while(!listajugadores.isEmpty()){
	  		                 					System.out.println(" El jugador :  "+listajugadores.poll().getIdjugador()+ " pierde su juego");
	  		                 					
	  		                 					
	  		                 			      }
		                 		
			                     }else{
		                 			
		                 			   System.out.println(" Jugador   |"+ unjugad.getIdjugador()+"|   asigno :"+ letraGenerada);
						                
	    		                       unjugad.setVidasParaJugar(	unjugad.getVidasParaJugar()-1);
				                       System.out.println("pierde un punto cant "+ unjugad.getVidasParaJugar());
			                   	
			               		       Stack<String> pilacopi = unjugad.getPilaDibujoAhorcado();
	  		               	           pilacopi.push(dibujoahorcado[unjugad.getVidasParaJugar()]);//voy dibujando el ahoracado
			               		
			               		        unjugad.setVidasParaJugar(unjugad.getVidasParaJugar());
			               		       Stack<String> agrega = mostrarPilaDeVida(pilacopi);
			               		        unjugad.setPilaDibujoAhorcado(agrega);
			               		        
			               		     listajugadores.addFirst(unjugad);
		                 			
			                         if(listajugadores.peekFirst().getVidasParaJugar()==0){
	                    	                System.out.println(" Jugador   |"+ unjugad.getIdjugador()+"|    -----------PIERDE JUEGO----- (GAME OVER)  !!!");
	                    	                   listajugadores.poll();
	                    	
	                                 }else{
	               		
	                     	               listajugadores.addLast(listajugadores.poll());
	                                 }
	               	                 	
			               		     
		                 		       }
		                 		  
		                 		System.out.println("--------------------------------------------------------------------------");
		               
		                       //listajugadores.add(unjugad);
		
		}
		
			
			
			
	}	//end of While
			
	
		
		}
		
		

	
	
	
	
	
String lanzaUnaLetraOpalabraCompleta(){
		String enviar="";
		Random aleator =new Random();
		

			if(aleator.nextBoolean()==false){
			     enviar= this.obtenerListaDepalabras().get(aleatorioPalabrInteger.generar());
			}else{
				enviar= abecedario[aleato.generar()];
				 
				
			}
			
		return enviar;
		
	}
		


	

	
	

	
	
	
	
	
	
	
	
	
boolean letraEsAdivinada(ArrayList<Character> palabradivinada, String palabraGenerada ){
	
	boolean band=true;
	for (int i=0;i<palabradivinada.size();i++){
	if(palabradivinada.get(i)!=palabraGenerada.charAt(i)){
		
		band=false;
	}
	
	}
	
		
	return band;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	int existeletra(String palabrageneradAleatoria,String letrasGeneradaAleatoria ){
		
		//debuelve  1 si es una letras existe en la palabra a adivinar en este caso sigue asignando
		//devuelve  2 si la  palabra es igual  a la que se debe adivinar en este caso el jugador gana!
		//devuelve 0 si la palabra  o letra no existe
		int valor=0;
		
		if (letrasGeneradaAleatoria.length()==1){
						
			for(int i =0; i<palabrageneradAleatoria.length()&& valor!=1; i++){
				String convertidostr=Character.toString(palabrageneradAleatoria.charAt(i));
			
				if (convertidostr.equals(letrasGeneradaAleatoria)){
								
					valor= 1;
				}		
			
			}
			
			
			
		}else if (palabrageneradAleatoria.equals(letrasGeneradaAleatoria)){
			
			valor=2;
			
		}
		
			
	
		return valor;
		
		
	}
	
					
	ArrayList<Character>   remplazarLetraEncontrada(String palabraJugada,String letra,ArrayList<Character> aConvertir ){
		for(int i=0;i<palabraJugada.length();i++){
			
			if(palabraJugada.charAt(i)== (char)letra.charAt(0)){
				aConvertir.remove(i);
				aConvertir.add(i, (char)letra.charAt(0));
								
			}
					
		}
		return aConvertir;
	}			
					
	
	
	void mostrarListaCaracter(ArrayList<Character> aConvertir ){
		for(int i=0; i<aConvertir.size();i++){
					System.out.print(aConvertir.get(i));
		}
		System.out.println(" ");
		
	}
	Stack<String> mostrarPilaDeVida(Stack<String> pilapasada){
		
		
	
		Stack<String> pilaLlenar = new Stack<String>();
		while(!pilapasada.isEmpty()){
			
			String mostra=pilapasada.pop();
			System.out.println(mostra);
			pilaLlenar .add(mostra);
			
		}
		
	while(!pilaLlenar.isEmpty()){
			
			pilapasada.add(pilaLlenar.pop());
			
		}
return pilapasada;		
	}
	

	public ArrayList<String> obtenerListaDepalabras(){
		
		ArrayList<String> palabra = new ArrayList<String>();
		
		
		palabra.add("ARBOL");
		palabra.add("AUTO");
		palabra.add("PERRO");
		palabra.add("GATO");
		palabra.add("ABUELO");
		palabra.add("COMPUTADORA");
		palabra.add("CELULAR");
		palabra.add("ESPEJO");
		palabra.add("GUITARRA");
		palabra.add("MICROFONO");
		palabra.add("TECLADO");
		palabra.add("PROGRAMACION");
		palabra.add("ARGENTINA");
		palabra.add("PARLANTES");
		palabra.add("COCINA");
		palabra.add("MOTOCICLETA");
		palabra.add("BICICLETA");
		palabra.add("ELEFANTE");
		palabra.add("GALLINA");
		palabra.add("DINOSAURIO");
		palabra.add("INTERNET");
		palabra.add("CUADERNO");
		palabra.add("LAPICERA");
		palabra.add("MOCHILA");
		palabra.add("LIBRO");
		palabra.add("BIBLIOTECA");
		palabra.add("ARBOL");
		palabra.add("NIRVANA");
		palabra.add("ZORRO");
		palabra.add("ODONTOLOGO");
		palabra.add("AFTALMOLOGO");
		palabra.add("PROFESOR");
		palabra.add("CARGADOR");
		palabra.add("FARMACIA");
		palabra.add("GRAVEDAD");
		palabra.add("HOLOCAUSTO");
		palabra.add("HUMORISTA");
		palabra.add("BIBLIA");
		palabra.add("BOTELLA");
		palabra.add("CERVEZA");
		palabra.add("FERNET");
		palabra.add("ABOGADO");
		palabra.add("ADULTERIO");
		palabra.add("DESCUBRIMIENTO");
		palabra.add("DICCIONARIO");
		palabra.add("INFIERNO");
		palabra.add("KIWIS");
		palabra.add("MARCADOR");
		palabra.add("CALCULADORA");
		palabra.add("MATEMATICA");
		palabra.add("BIOLOGIA");
		palabra.add("INFORMATICA");
		palabra.add("APLICACIONES");
		palabra.add("TEOREMAS");
		palabra.add("CONJUNTOS");
		palabra.add("FUNCIONES");
		palabra.add("PROGRAMACION");
		palabra.add("PROYECTO");
		palabra.add("EJERCICIO");
		palabra.add("SIMETRIA");
		palabra.add("REFLEXIVA");
		palabra.add("MULTIGRAFO");
		palabra.add("PSEUDOGRAFO");
		palabra.add("CANONICO");
		palabra.add("AVENIDA");
//		palabra.add("ARBOL");
//		palabra.add("ARBOL");
//		palabra.add("ARBOL");
//		palabra.add("ARBOL");

		
		
		
		
		return palabra;
	}

}
