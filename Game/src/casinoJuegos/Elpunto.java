package casinoJuegos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Elpunto extends Juego {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public Elpunto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Elpunto(double importeDeApuesta, String nombreDelJuego) {
		super(importeDeApuesta, nombreDelJuego);
		// TODO Auto-generated constructor stub
	}

	public Elpunto(int cantidaDeJugadores, double importeDeApuesta, String nombreDelJuego) {
		super(cantidaDeJugadores, importeDeApuesta, nombreDelJuego);
		// TODO Auto-generated constructor stub
	}

	public Elpunto(int cantidaDeJugadores, double importeDeApuesta) {
		super(cantidaDeJugadores, importeDeApuesta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Jugar() {
		System.out.println("_________________________El PUNTO_________________________");
		Queue<Jugador>  coladejugador = new LinkedList<Jugador>();
		Queue<Jugador>  jugadoresProcesados = new LinkedList<Jugador>();
	
		Jugador  jugad=new Jugador();
		
		for (int i=1;i<=this.getCantidaDeJugadores();i++){
			
			jugad = new Jugador(i,4,0);
			System.out.println(i+  "usuario");
			coladejugador.add(jugad);
		}
		
		
		 
		Random tiraDado=new Random();
		int b;
		int a;
		int c; 
		Stack<Integer>  pilanum = new Stack<Integer>();
		
		while(!coladejugador.isEmpty()){
			Stack<Integer>  sumpila = new Stack<Integer>();
			jugad=coladejugador.poll();
			boolean band=false;
			   while(jugad.getCantDejugadas()!=0){
			              a = (int)(tiraDado.nextDouble() * 6 + 1);
			              b = (int)(tiraDado.nextDouble() * 6 + 1);
			              c = (int)(tiraDado.nextDouble() * 6 + 1);
			                   pilanum.add(a);
			                   pilanum.add(b);
			                   pilanum.add(c);
			  
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
			                   }
			                        
			                        
			                        	
			                    if( a== b && b== c){
			                           if(a==2 || a==4||a==6){
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
			System.out.println(a+ "  "+b+"     "+c);
			
			}
			System.out.println("---------------------------------------------------------------  ");
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
			  
			
		}
		
for(Jugador un :jugadoresProcesados){
		System.out.println("jugador |"+un.getIdjugador()+"| puntos :" +un.getPuntos());
}
		














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
			
		
				
			
		
				
			
			
			
		
		System.out.println("----------------------------------------------------------------------");

		while(!winerPuntajeAlto.isEmpty()){
			jugad=winerPuntajeAlto.pop();
			System.out.println("Gana apuesta  jugador |"+jugad.getIdjugador()+"| puntos :" +jugad.getPuntos());
			
		}
		
		while(! loserJugadores.isEmpty()){
			jugad= loserJugadores.poll();
			System.out.println("Pierde apuesta  jugador |"+jugad.getIdjugador()+"| puntos :" +jugad.getPuntos());
			
		}
		
		System.out.println("________________FIN DEL JUEGO PUNTO_________________");
		System.out.println("  ");
		System.out.println("  ");
		System.out.println("  ");
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

	
	
	
	
	
	
	
	
	
	
	
	


	
		
		
	
	
	
	}

