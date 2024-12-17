package juego;

import java.util.Random;

public class Juego {
	Posicion posicion;
	private int [][] tablero;
	private int [][] tableroOrdenado;
	private int fila;
	private int columna;
	private int cantidadMovimiento;
	private int cantidadMaximaMovimientos;
	private boolean juegoIniciado= false;
	private boolean mezclarSoloUna= false;
	private boolean mezclandoTablero = false;
	
	public Juego() {		
		this.fila=4;
		this.columna=4;
		this.cantidadMovimiento=0;
		this.cantidadMaximaMovimientos= 140;
		tablero= new int [fila][columna];
		tableroOrdenado= new int [fila][columna];
		posicion = new Posicion (0,0);
	}

	public int getValor(int i, int j){
		return tablero[i][j];
	}

	public int obtenerLongitudDeTablero() {
		return this.tablero.length;
	}

	public void asignarElementosAMatriz() {
		int elementoAsignado=0;
		for (int i=0; i < fila; i++) {
			for (int j=0; j < columna; j++) {
				this.tablero[i][j]= elementoAsignado;
				this.tableroOrdenado[i][j]= elementoAsignado++;
			}
		}		
	}

	public void mezclarElementosMatriz() {
		Random random = new Random();
		int movimientos = 70; 
		this.mezclandoTablero = true;
		if (!this.mezclarSoloUna) {
			movimientosRealizadosAlMezclar(random, movimientos); 
		}
		this.mezclarSoloUna=true;
		this.juegoIniciado=true;
		this.mezclandoTablero = false;
	}

	private void movimientosRealizadosAlMezclar(Random random, int movimientos) {
		for (int i = 0; i < movimientos; i++) {
			int direccion= random.nextInt(4);
			switch (direccion) {
			case 0:
				moverAbajo();
				break;
			case 1:
				moverArriba();				
				break;
			case 2:
				moverDerecha();	
				break;
			case 3:
				moverIzquierda();
				break;     
			}  			
		}
	}

	public void encontrarCero() {		
		for (int i= fila-1; i > 0; i--) {
			for (int j= columna-1; j>0; j--){
				if (tablero [i][j]==0) {
					posicion.setearXY(i, j);
				}
			}
		}
	}

	public void moverAbajo() {	
		if (!this.juegoIniciado && !this.mezclandoTablero || posicion.obtenerX() == 3) {
	        return;
	    }	
		int x= posicion.obtenerX();
		int y= posicion.obtenerY();
		tablero[x][y]= tablero [x+1][y];
		tablero [x+1][y]= 0;
		posicion.setearXY(x+1, y); 
		if (this.juegoIniciado) {
			this.cantidadMovimiento++;
		    this.cantidadMaximaMovimientos--;
		}
	}

	public void moverArriba() {
		if (!this.juegoIniciado && !this.mezclandoTablero || posicion.obtenerX() == 0) {
	        return;
	    }
		int x= posicion.obtenerX();
		int y= posicion.obtenerY();
		
		tablero[x][y]= tablero [x-1][y];
		tablero [x-1][y]= 0;
		posicion.setearXY(x-1, y); 
		if (this.juegoIniciado) {
			this.cantidadMovimiento++;
			this.cantidadMaximaMovimientos--;
		}
	}

	public void moverDerecha() {
		if (!this.juegoIniciado && !this.mezclandoTablero || posicion.obtenerY() == 3) {
	        return;
	    }
		int x= posicion.obtenerX();
		int y= posicion.obtenerY();
		tablero[x][y]= tablero [x][y+1];
		tablero [x][y+1]= 0;
		posicion.setearXY(x, y+1); 
		if (this.juegoIniciado) {
			this.cantidadMovimiento++;
			this.cantidadMaximaMovimientos--;
		}
	}

	public void moverIzquierda() {
		if (!this.juegoIniciado && !this.mezclandoTablero || posicion.obtenerY() == 0) {
	        return;
	    }
		int x= posicion.obtenerX();
		int y= posicion.obtenerY();
		tablero[x][y]= tablero [x][y-1];
		tablero [x][y-1]= 0;
		posicion.setearXY(x, y-1); 
		if (this.juegoIniciado) { 
			this.cantidadMovimiento++;
			this.cantidadMaximaMovimientos--;
		}
	}


	public int cantidadMovimientosRealizados() {
		int movimientos= this.cantidadMovimiento;
		return movimientos;
	}
	
	public int cantidadMovimientosDisponibles() {
	   int movimientos= this.cantidadMaximaMovimientos;
	   return movimientos;
	}

	public boolean verficarDerrota() {
		return this.cantidadMaximaMovimientos==0;
	}
	
	public boolean verificarVictoria() {
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				if (tablero [i][j]!= tableroOrdenado[i][j]) {
					return false;
				}
			}
		}
		return true && juegoIniciado==true;
	}
}