package juego;

public class Posicion {
	private int x;
	private int y;
	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setearXY (int fila, int columna ) {
		this.x=fila;
		this.y=columna;
	}
	
	public int obtenerX() {
		return this.x;
	}
	
	public int obtenerY() {
		return this.y;
	}
}
