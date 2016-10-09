package casinoJuegos;

import java.util.Stack;

public class Jugador {
	int idjugador;
	int cantDejugadas;
    int vidasParaJugar;
    int puntos;
   
	Stack<String> pilaDibujoAhorcado= new Stack<String>();
	public Jugador() {
		super();
		
	}

	public Jugador(int idjugador, int cantDejugadas, int vidasParaJugar) {
		super();
		this.idjugador = idjugador;
		this.cantDejugadas = cantDejugadas;
		this.vidasParaJugar = vidasParaJugar;
	}
	
	public Jugador(int idjugador, int vidasParaJugar, Stack<String> pilaDibujoAhorcado) {
		super();
		this.idjugador = idjugador;
		this.vidasParaJugar = vidasParaJugar;
		this.pilaDibujoAhorcado = pilaDibujoAhorcado;
	}

	public Jugador(int idjugador, int cantDejugadas, int vidasParaJugar, Stack<String> pilaDibujoAhorcado) {
		super();
		this.idjugador = idjugador;
		this.cantDejugadas = cantDejugadas;
		this.vidasParaJugar = vidasParaJugar;
		this.pilaDibujoAhorcado = pilaDibujoAhorcado;
	}

	public Stack<String> getPilaDibujoAhorcado() {
		return pilaDibujoAhorcado;
	}
	public void setPilaDibujoAhorcado(Stack<String> pilaDibujoAhorcado) {
		this.pilaDibujoAhorcado = pilaDibujoAhorcado;
	}
	public int getIdjugador() {
		return idjugador;
	}
	public void setIdjugador(int idjugador) {
		this.idjugador = idjugador;
	}
	public int getCantDejugadas() {
		return cantDejugadas;
	}
	public void setCantDejugadas(int cantDejugadas) {
		this.cantDejugadas = cantDejugadas;
	}
	public int getVidasParaJugar() {
		return vidasParaJugar;
	}
	public void setVidasParaJugar(int vidasParaJugar) {
		this.vidasParaJugar = vidasParaJugar;
	}
	 public int getPuntos() {
			return puntos;
		}

		public void setPuntos(int puntos) {
			this.puntos = puntos;
		}
}
