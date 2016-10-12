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
	
	}

	public Ahorcado( String modo,double importeDeApuesta,String nombreDelJuego) {
		super(importeDeApuesta, nombreDelJuego);
		this.modo = "principiante";
		this.setCantidaDeJugadores(1);
	}

	public Ahorcado(int cantidaDeJugadores, double importeDeApuesta, String nombreDelJuego) {
		super(cantidaDeJugadores, importeDeApuesta, nombreDelJuego);
		
	}

	public Ahorcado(int cantidaDeJugadores, double importeDeApuesta) {
		super(cantidaDeJugadores, importeDeApuesta);
	}

	public Ahorcado(int cantidaDeJugadores,String modo, double importeDeApuesta) {
		super(cantidaDeJugadores, importeDeApuesta);
		this.modo = modo;
		this.setNombreDelJuego("Ahorcado");
	}
	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
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
	
		ArrayList<Character> letralist= new ArrayList<Character>();//creo un array de lista para almacenar letra oculta
		

		//cargando palabra con _ oculta
		for(int i=0;i<palabraAjugar.length();i++){letralist.add('-');}
		
		
		
		
		
		
		String letraGenerada="";
		boolean band=true;
		ArrayList<Character> mostrarpalabraenCurso;
		
		Jugador unJugador = new Jugador();
		
		boolean banderaGanador=true;
		//.....;........................
		if (this.getModo()=="principiante"){
			 System.out.println(" "); System.out.println(" ");
			System.out.println("======================AHORCADO MODO PRINCIPIANTE===================");
		for(int i=1;i<=this.getCantidaDeJugadores();i++){
              System.out.println("cantidad  de jugadores :"+i);
			
			unjugador = new Jugador(i,0,7);
		listajugadores.add(unjugador);
		}
		}else{
			 System.out.println(" "); System.out.println(" ");
				
			System.out.println("================AHORCADO MODO AVANZADO=================");
			for(int i=1;i<=this.getCantidaDeJugadores();i++){
	              System.out.println("cantidad  de jugadores :"+i);
				
				unjugador = new Jugador(i,0,7);
			listajugadores.add(unjugador);
			}
			
			
		}
		System.out.print("cantidad de caracter es "+ palabraAjugar.length());
		System.out.print("  letras es "+ palabraAjugar +" ");
		
		
		 AleatorioSinRepetir aleato = new  AleatorioSinRepetir(0,25);
		for(int i=0;i<palabraAjugar.length();i++){System.out.print(letralist.get(i));}//muestras la letra oculta
		
		System.out.println(" ");
		
	
		
		/*System.out.println(Character.toString(palabraAjugar.charAt(2)));
	String m = Character.toString(palabraAjugar.charAt(2));
		
		
		System.out.println("existe letra :"+existeletra(palabraAjugar,palabraAjugar));*/
		
		
		
		while(!listajugadores.isEmpty()){
			
			 unJugador=listajugadores.poll();
			 			
			 if(unJugador.getVidasParaJugar()!=0){
				     letraGenerada= abecedario[aleato.generar()];
					     if(existeletra(palabraAjugar,letraGenerada) ==1){///________________________________________1
						
						       System.out.println("jugador :|" +unJugador.getIdjugador() +"| asigno  '"+letraGenerada+"'  correcta ! " );
						       
             			      mostrarListaCaracter(remplazarLetraEncontrada(palabraAjugar,letraGenerada,letralist));
             		    	 
             			     System.out.println("------------------------------------------------------------------");	 
             			     boolean bandera=true;
             			              if (letraEsAdivinada(letralist,palabraAjugar)){
             			            	  bandera=false;
		                                          System.out.println(" GANA JUGADOR :   "+unJugador.getIdjugador()+" felicitaciones !!");
		
		                                     while(!listajugadores.isEmpty()){
			                                     System.out.println(" El jugador :  "+listajugadores.poll().getIdjugador()+ " pierde su juego");
			
			
		                                     }
	           
		                                }
             			      
             			    
             		         while(bandera==true ){
                          	        letraGenerada=abecedario[aleato.generar()];//si letra  existe vuelvo a tirar
	                                     if(existeletra(palabraAjugar,letraGenerada) ==1){
	                                    	                   System.out.println("jugador :|" +unJugador.getIdjugador() +"| asigno  '"+letraGenerada+"'  correcta ! " );
	                                                            
		                 			                            mostrarListaCaracter(remplazarLetraEncontrada(palabraAjugar,letraGenerada,letralist));
		                 			                            System.out.println(" ");
		                 			                            if (letraEsAdivinada(letralist,palabraAjugar)){
	                 				                            System.out.println(" GANA JUGADOR :   "+unJugador.getIdjugador()+" felicitaciones !!1");
	                 				                           bandera=false;
	                 				                              while(!listajugadores.isEmpty()){
	                 					                                System.out.println(" El jugador :  "+listajugadores.poll().getIdjugador()+ " pierde su juego");
	                 					
	                 					
	                 				                                }
	                 			           
		                 			                            }
	                 			                           
		                 			                           System.out.println("------------------------------------------------------------------");	 
             			      
	                                      }else if(existeletra(palabraAjugar,letraGenerada) ==2){
	                                    	  
	                                    	  bandera=false;
	                                    	    System.out.println(" GANA JUGADOR :   "+unJugador.getIdjugador()+" felicitaciones !!");
	      	                 				
 				                                while(!listajugadores.isEmpty()){
 					                                System.out.println(" El jugador :  "+listajugadores.poll().getIdjugador()+ " pierde su juego");
 					
 					
 				                                }
	                                    	  
	                                    	  
	                                    	  
	                                    	  
	                                    	  
	                                      }else{
	                                    	  bandera=false;
	                                    	 
	                                     	 

	             					    	 
	                    		        	  System.out.println(" Jugador   |"+ unJugador.getIdjugador()+"|   asigno : '"+ letraGenerada + "'  incorrecta !");
	                    		        	  
	                    		        	  
	                    		        	  
	                    		        	  
	                    		        	  
	                    		        	  
	                    		    
	                    		        	  if(this.getModo().equals("principiante")){
	                    		        		  int i=0;
	                    		        		  while(this.getCantidaDeJugadores()>i && unJugador.getVidasParaJugar()!=0){
	                    		        			  i++;
	                    		        			  System.out.println("quitando vida.");
	                                             unJugador.setVidasParaJugar(unJugador.getVidasParaJugar()-1);
	                                           //  System.out.println("pierde  vida   cant restantes :"+ unJugador.getVidasParaJugar());
	                           	
	                       		                  Stack<String> pilacopi = unJugador.getPilaDibujoAhorcado();
	                         	                      pilacopi.push(dibujoahorcado[unJugador.getVidasParaJugar()]);//voy dibujando el ahoracado
	                       		
	                       		                  unJugador.setVidasParaJugar(unJugador.getVidasParaJugar());
	                       		                  Stack<String> agrega = mostrarPilaDeVida(pilacopi);
	                       		                  unJugador.setPilaDibujoAhorcado(agrega);
	                       		        
	                       		                 
	                    		        		  }
	                    		        		  listajugadores.addFirst(unJugador);
	                    		        	  }else{
	                    		        		  int i=0;
	                    		        		  while(2>i && unJugador.getVidasParaJugar()!=0){
	                    		        			  i++;
	                    		        			  System.out.println("quitando vida.");
	                                             unJugador.setVidasParaJugar(unJugador.getVidasParaJugar()-1);
	                                        
	                           	
	                       		                  Stack<String> pilacopi = unJugador.getPilaDibujoAhorcado();
	                         	                      pilacopi.push(dibujoahorcado[unJugador.getVidasParaJugar()]);//voy dibujando el ahoracado
	                       		
	                       		                  unJugador.setVidasParaJugar(unJugador.getVidasParaJugar());
	                       		                  Stack<String> agrega = mostrarPilaDeVida(pilacopi);
	                       		                  unJugador.setPilaDibujoAhorcado(agrega);
	                    		        		  }	       if (!listajugadores.isEmpty()){
	                   		        	    	   LinkedList<Jugador> listaAux= new LinkedList<Jugador>();
	                 		        			  
	                		        	    	   while(!listajugadores.isEmpty()){
	                		        	    	   
	                		        			  Jugador unoJ =new Jugador();
	                		        			  
	                		        			  unoJ=listajugadores.poll();
	                		        			  System.out.println("quitando vida a  jugador"+unoJ.getIdjugador());
	                		        			  unoJ.setVidasParaJugar(unoJ.getVidasParaJugar()-1);
	                		        			  Stack<String> pilacopi =   unoJ.getPilaDibujoAhorcado();
	                     	                      pilacopi.push(dibujoahorcado[  unoJ.getVidasParaJugar()]);//voy dibujando el ahoracado
	                   		
	                     	                     unoJ.setVidasParaJugar(  unoJ.getVidasParaJugar());
	                   		                    Stack<String> agrega = mostrarPilaDeVida(pilacopi);
	                   		                 unoJ.setPilaDibujoAhorcado(agrega);
	                   		                    listaAux.addLast(unoJ);
	                		        	        }
	                		        	    	   
	                		        	    	 while(!listaAux.isEmpty()){
	                		        	    		 Jugador unoJ =new Jugador();
	                		        	    		 
	                		        	    		 unoJ=listaAux.poll();
	                		        	    		 
	                		        	    		 if(unoJ.getVidasParaJugar()!=0){
	                		        	    		 listajugadores.addLast(unoJ);
	                		        	    		 }else{
	                		        	    			 
	                		        	    			 
	                		        	    			 System.out.println(" jugador   |"+unoJ.getIdjugador() +"| -----PIERDE JUEGO-----!!	por otro jugador " );
	                		        	    		 }
	                		        	    		 
	                		        	    	 }  
	                        			  
	                        			
	                		        			  
	                		        		  }
	                    		        		  
	                    		        		  
	                    		        		  listajugadores.addFirst(unJugador);
	                    		        	  }
	                       		                  
	                       		                  
	                       		                  if(listajugadores.peekFirst().getVidasParaJugar()==0 && !listajugadores.isEmpty()){
	                    	                       System.out.println(" Jugador   |"+ unJugador.getIdjugador()+"|    -----------PIERDE JUEGO----- (GAME OVER)  !!!");
	                    	                       listajugadores.poll();
	                    	
	                                              }else{
	                    	
	                     	                         listajugadores.addLast(listajugadores.poll());
	                                              }
	                    		        	
	                    		        	
	                    		        	
	                    		        	
	                    		        	
	                    		        	
	                    					     
	                                                                 
	                                     
	                                     
             		         }
             			      

	                   	}//fin de segundo while
             		         
             		         
				}else if (existeletra(palabraAjugar,letraGenerada) ==2){
					    	 
					
					 System.out.println(" GANA JUGADOR :   "+unJugador.getIdjugador()+" felicitaciones !!");
        				
                      while(!listajugadores.isEmpty()){
                          System.out.println(" El jugador :  "+listajugadores.poll().getIdjugador()+ " pierde su juego");


                      }
					
					     
		        }else {
					    	 
		        	  System.out.println(" Jugador   |"+ unJugador.getIdjugador()+"|   asigno : '"+ letraGenerada + "'  incorrecta !");
		        	  
		        	  
		        	  
		        	  
		        	  
		        	  
		    
		        	  if(this.getModo().equals("principiante")){
		        		  int i=0;
		        		  while(this.getCantidaDeJugadores()>i && unJugador.getVidasParaJugar()!=0){
		        			  i++;
		        			  System.out.println("quitando vida.");
                         unJugador.setVidasParaJugar(unJugador.getVidasParaJugar()-1);
                       //  System.out.println("pierde  vida   cant restantes :"+ unJugador.getVidasParaJugar());
       	
   		                  Stack<String> pilacopi = unJugador.getPilaDibujoAhorcado();
     	                      pilacopi.push(dibujoahorcado[unJugador.getVidasParaJugar()]);//voy dibujando el ahoracado
   		
   		                  unJugador.setVidasParaJugar(unJugador.getVidasParaJugar());
   		                  Stack<String> agrega = mostrarPilaDeVida(pilacopi);
   		                  unJugador.setPilaDibujoAhorcado(agrega);
   		        
   		                 
		        		  }
		        		  listajugadores.addFirst(unJugador);
		        	  }else{//avanzado
		        		  
		        		  int i=0;
		        		  while(2>i && unJugador.getVidasParaJugar()!=0){
		        			  i++;
		        			  System.out.println("quitando vida.");
                         unJugador.setVidasParaJugar(unJugador.getVidasParaJugar()-1);
                       //  System.out.println("pierde  vida   cant restantes :"+ unJugador.getVidasParaJugar());
       	
   		                  Stack<String> pilacopi = unJugador.getPilaDibujoAhorcado();
     	                      pilacopi.push(dibujoahorcado[unJugador.getVidasParaJugar()]);//voy dibujando el ahoracado
   		
   		                  unJugador.setVidasParaJugar(unJugador.getVidasParaJugar());
   		                  Stack<String> agrega = mostrarPilaDeVida(pilacopi);
   		                  unJugador.setPilaDibujoAhorcado(agrega);
		        		  }
		        		  
		        	
		        		  
		        	       if (!listajugadores.isEmpty()){
		        	    	   LinkedList<Jugador> listaAux= new LinkedList<Jugador>();
		        			  
		        	    	   while(!listajugadores.isEmpty()){
		        	    	   
		        			  Jugador unoJ =new Jugador();
		        			  
		        			  unoJ=listajugadores.poll();
		        			  System.out.println("quitando vida a  jugador"+unoJ.getIdjugador());
		        			  unoJ.setVidasParaJugar(unoJ.getVidasParaJugar()-1);
		        			  Stack<String> pilacopi =   unoJ.getPilaDibujoAhorcado();
     	                      pilacopi.push(dibujoahorcado[  unoJ.getVidasParaJugar()]);//voy dibujando el ahoracado
   		
     	                     unoJ.setVidasParaJugar(  unoJ.getVidasParaJugar());
   		                    Stack<String> agrega = mostrarPilaDeVida(pilacopi);
   		                 unoJ.setPilaDibujoAhorcado(agrega);
   		                    listaAux.addLast(unoJ);
		        	        }
		        	    	   
		        	    	 while(!listaAux.isEmpty()){
		        	    		 Jugador unoJ =new Jugador();
		        	    		 
		        	    		 unoJ=listaAux.poll();
		        	    		 
		        	    		 if(unoJ.getVidasParaJugar()!=0){
		        	    		 listajugadores.addLast(unoJ);
		        	    		 }else{
		        	    			 
		        	    			 
		        	    			 System.out.println(" jugador   |"+unoJ.getIdjugador() +"| -----PIERDE JUEGO-----!!	por otro jugador " );
		        	    		 }
		        	    		 
		        	    	 }  
        			  
        			
		        			  
		        		  }
		        		  
		        		  
		        		  listajugadores.addFirst(unJugador);
		        		  
		        	  }
   		                  
   		                  
   		                  if(listajugadores.peekFirst().getVidasParaJugar()==0 && !listajugadores.isEmpty()){
	                       System.out.println(" Jugador   |"+ unJugador.getIdjugador()+"|    -----------PIERDE JUEGO----- (GAME OVER)  !!!");
	                       listajugadores.poll();
	
                          }else{
	
 	                         listajugadores.addLast(listajugadores.poll());
                          }
		        	
		        	
		        	
		        	
		        	
		        	
					     }
			
			 
			 
			 
			 }//fin del if 	 
					    	 

			 System.out.println("------------------------------------------------------------------");	 
		
		}// fin del while de lista
		
		
		
		
		
		
		
		
		

	
	

		
		
		System.out.println("");System.out.println("");
		
		System.out.println("============================FIN AHORACADO==========================");
		System.out.println("");
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
		
		
		//System.out.println(palabradivinada.get(i)+" _______"+palabraGenerada.charAt(i));
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
			
			
			
		}else {
			if (palabrageneradAleatoria.equals(letrasGeneradaAleatoria)){
		
			
			valor=2;
			}	
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
		palabra.add("OFTALMOLOGO");
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
