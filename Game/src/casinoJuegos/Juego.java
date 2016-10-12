package casinoJuegos;

public abstract class Juego {
	private int cantidaDeJugadores;//, valor por defecto uno.
	private double  importeDeApuesta; //valor por defecto diez.
	private String nombreDelJuego;// valor por defecto “Indefinido”
	
	public Juego() {
		super();
		this.cantidaDeJugadores = 1;
		this.importeDeApuesta = 10.0;
		this.nombreDelJuego = "Indefinido";
	}
	
	public Juego(int cantidaDeJugadores, double importeDeApuesta, String nombreDelJuego) {
		super();
		this.cantidaDeJugadores = cantidaDeJugadores;
		this.importeDeApuesta = importeDeApuesta;
		this.nombreDelJuego = nombreDelJuego;
	}

	public Juego(int cantidaDeJugadores, double importeDeApuesta) {
		super();
		this.cantidaDeJugadores = cantidaDeJugadores;
		this.importeDeApuesta = importeDeApuesta;
	}


	public Juego(double importeDeApuesta, String nombreDelJuego) {
		super();
		this.importeDeApuesta = importeDeApuesta;
		this.nombreDelJuego = nombreDelJuego;
	}

	public int getCantidaDeJugadores() {
		return cantidaDeJugadores;
	}

	public void setCantidaDeJugadores(int cantidaDeJugadores) {
		this.cantidaDeJugadores = cantidaDeJugadores;
	}

	public double getImporteDeApuesta() {
		return importeDeApuesta;
	}

	public void setImporteDeApuesta(double importeDeApuesta) {
		this.importeDeApuesta = importeDeApuesta;
	}

	public String getNombreDelJuego() {
		return nombreDelJuego;
	}

	public void setNombreDelJuego(String nombreDelJuego) {
		this.nombreDelJuego = nombreDelJuego;
	}

	public abstract void Jugar();
	public abstract double totalApuesta();
	public abstract double totalPremio();
	public abstract double totalComicion();

}
