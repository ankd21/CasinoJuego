package casinoJuegos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Elpunto extends Juego {
	

	public Elpunto() {
		super();
		
	}

	public Elpunto(double importeDeApuesta, String nombreDelJuego) {
		super(importeDeApuesta, nombreDelJuego);
		this.setCantidaDeJugadores(2);
	
	}

	public Elpunto(int cantidaDeJugadores, double importeDeApuesta, String nombreDelJuego) {
		super(cantidaDeJugadores, importeDeApuesta, nombreDelJuego);
		
	}

	public Elpunto(int cantidaDeJugadores, double importeDeApuesta) {
		super(cantidaDeJugadores, importeDeApuesta);
	
	}

	@Override
	public void Jugar() {
		System.out.println("_________________________________El PUNTO___________________________");
		System.out.println("Cantidad jugadores  : |"+this.getCantidaDeJugadores()+"|  Importe de apuesta por cada jugador : $ "  +this.getImporteDeApuesta());
		System.out.println(" ");
		Queue<Jugador>  coladejugador = new LinkedList<Jugador>();
		Queue<Jugador>  jugadoresProcesados = new LinkedList<Jugador>();
	
		Jugador  jugad=new Jugador();
	
		
		for (int i=1;i<=this.getCantidaDeJugadores();i++){
			
			jugad = new Jugador(i,4,0); //i es id de jugador  4 lanzamientos,
			
			coladejugador.add(jugad);
		}
		
		
		 
		Random tiraDado=new Random();
		int lanzamiento_a;
		int lanzamiento_b;
		int lanzamiento_c; 
		Stack<Integer>  pilanum = new Stack<Integer>();
		
		while(!coladejugador.isEmpty()){
			Stack<Integer>  sumpila = new Stack<Integer>();
			jugad=coladejugador.poll();
			System.out.println("jugador   : |"+jugad.getIdjugador()+"|");
			boolean band=false;
			   while(jugad.getCantDejugadas()!=0){
			              lanzamiento_a = (int)(tiraDado.nextDouble() * 6 + 1);
			              lanzamiento_b = (int)(tiraDado.nextDouble() * 6 + 1);
			              lanzamiento_c = (int)(tiraDado.nextDouble() * 6 + 1);
			                   pilanum.add(lanzamiento_a);
			                   pilanum.add(lanzamiento_b);
			                   pilanum.add(lanzamiento_c);
			  
			                   while(!pilanum.isEmpty()){     
			                      if(pilanum.peek()==1 || pilanum.peek()==3 || pilanum.peek()==5)
			                       {
			                        	  if(pilanum.peek()==1){
			                        		  sumpila.push(1);
						                       pilanum.pop();
			                        		
			                        	  }else if (pilanum.peek()==3){
			                        		   sumpila.push(2);
						                       pilanum.pop();
			                        		
			                        	  }else if(pilanum.peek()==5){
			                        		   sumpila.push(4);
						                       pilanum.pop();
			                        	  }
				                      
			                        }else{
			                        	  pilanum.pop();
			                        	
			                        }
			                   }/*fin de mientras*/
			                        
			                        
			                        	
			                    if( lanzamiento_a== lanzamiento_b && lanzamiento_b== lanzamiento_c){
			                           if(lanzamiento_a==2 || lanzamiento_a==4||lanzamiento_a==6){
					                         band=true;
					                      }			                                
			                     }
			                     
			                              
			                        
			                        
			  
			                int sum=0;
			               while(!sumpila.isEmpty()){
										sum=sum+sumpila.pop();
					
			            	}
			               if(sum!=0){
			                  sumpila.push(sum);
			                }
			  
			
			               jugad.setCantDejugadas(jugad.getCantDejugadas()-1);
			               System.out.println("lanzamineto -->"+(jugad.getCantDejugadas()+1)+"  valor de los dados : "+ lanzamiento_a+ "   "+lanzamiento_b+"   "+lanzamiento_c);
			
			}/*fin del  mientras */
			     System.out.println("------------------------------------------------------  ");
			     int sum=0;
			     int prod=0;
				 while(!sumpila.isEmpty()){
						sum=sum+sumpila.pop();
				 }
				 if(band){
    				prod=sum*2;
				    jugad.setPuntos(prod);
				    jugadoresProcesados.add(jugad);
				 }else{
					jugad.setPuntos(sum);
					jugadoresProcesados.add(jugad);
					
				}
			  
			
		}/*fin del mientras */
		
		           /*mostrando  los puntos de los jugaadores */
                   for(Jugador un :jugadoresProcesados){
		                  System.out.println("jugador |"+un.getIdjugador()+"| puntos :" +un.getPuntos());
                   }
		
                   /*buscando los jugador o jugadores  con mayor puntaje*/

                  
                    boolean mayor=true;
	
	                Queue<Jugador>  loserJugadores = new LinkedList<Jugador>();
	                Stack<Jugador> winerPuntajeAlto = new Stack<Jugador>();
		            while(!jugadoresProcesados.isEmpty()){
			
			                 jugad=jugadoresProcesados.poll();
			                if (mayor){
				     			winerPuntajeAlto.push(jugad);
			                    mayor=false;
			                }else if (jugad.getPuntos()>=winerPuntajeAlto.peek().getPuntos()){
				
			                      if (jugad.getPuntos()==winerPuntajeAlto.peek().getPuntos()){
				                     winerPuntajeAlto.push(jugad);
			                       }else{
				                       if(winerPuntajeAlto.size()>=1){
									          while(!winerPuntajeAlto.isEmpty()){
						                         loserJugadores.add(winerPuntajeAlto.pop());
						                       }
					                          winerPuntajeAlto.push(jugad);
					
			         	                }else{
								               	loserJugadores.add(winerPuntajeAlto.pop());
			                                     winerPuntajeAlto.push(jugad);
			    
				                        }
			                      }		
			                 }else{
		                           	loserJugadores.add(jugad);
			                 }
		    }
			
		
				
						
		
		System.out.println("------------------------------------------------------");

		while(! loserJugadores.isEmpty()){
			jugad= loserJugadores.poll();
			System.out.println("Pierde apuesta  jugador : |"+jugad.getIdjugador()+"| puntos :" +jugad.getPuntos());
			
		}
		while(!winerPuntajeAlto.isEmpty()){
			jugad=winerPuntajeAlto.pop();
			System.out.println("GANA APUESTA JUGADOR  : |"+jugad.getIdjugador()+"| puntos :" +jugad.getPuntos());
			
		}
		
		System.out.println("");
		
		System.out.println("_______________________FIN DEL JUEGO PUNTO______________________");
		System.out.println("  ");
		System.out.println("  ");
		System.out.println("  ");
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

