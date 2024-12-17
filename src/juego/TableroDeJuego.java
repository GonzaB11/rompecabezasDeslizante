package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableroDeJuego {
    public JFrame frameJuego;
	private Juego miJuego;
    private JLabel cantMov;
    private JPanel panelTablero;
    private  ImageIcon [] imagenes = new ImageIcon [16];
    private static String nombreDeImagen;
    private JLabel movimientosRestantes;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new TableroDeJuego(nombreDeImagen).frameJuego.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TableroDeJuego(String nombre) {
    	this.nombreDeImagen= nombre;
        miJuego = new Juego();
        cargarImagenesAlTablero();
        initialize();
    }

    private void initialize() {
        frameJuego = new JFrame();
        frameJuego.setTitle("Rompecabezas deslizante");
        frameJuego.setBounds(100, 100, 800, 600);
        frameJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameJuego.getContentPane().setLayout(null);
        JPanel panelControles = new JPanel();
        panelControles.setBounds(0, 0, 285, 561);
        frameJuego.getContentPane().add(panelControles);
        panelControles.setBackground(Color.BLACK);
        panelControles.setLayout(null);

        panelTablero = new JPanel();
        panelTablero.setBounds(288, 0, 496, 561);
        frameJuego.getContentPane().add(panelTablero);
        panelTablero.setLayout(new GridLayout(0, 4, 0, 0));

        miJuego.asignarElementosAMatriz();
        crearBotonesPanelTablero();
        
        JButton botonMezclar = crearBotonesDePanelDeControl("Mezclar", "/imagenes/mezclar.png", 8, 163, 270, 77);
        botonMezclar.setHorizontalTextPosition(SwingConstants.CENTER); 
        botonMezclar.setVerticalTextPosition(SwingConstants.CENTER);   
        botonMezclar.setText("Mezclar"); 
        botonMezclar.setFont(new Font("Georgia", Font.BOLD, 20));
        botonMezclar.setForeground(Color.WHITE);
        botonMezclar.addActionListener(e -> {
        	miJuego.mezclarElementosMatriz();
        	actualizarPosicionDeLosBotones();
        });
        panelControles.add(botonMezclar);

        JButton arriba =  crearBotonesDePanelDeControl(null, "/imagenes/flechaArr.jpg", 121, 299, 40, 80);
        JButton abajo =  crearBotonesDePanelDeControl(null, "/imagenes/flechaAbj.jpg", 121, 379, 40, 80);
        JButton derecha =  crearBotonesDePanelDeControl(null, "/imagenes/flechaDer.jpg", 161, 358, 80, 40);
        JButton izquierda =  crearBotonesDePanelDeControl(null, "/imagenes/flechaIzq.jpg", 41, 358, 80, 40);

        panelControles.add(arriba);
        panelControles.add(abajo);
        panelControles.add(derecha);
        panelControles.add(izquierda);

        cantMov = new JLabel("Movimientos: " + miJuego.cantidadMovimientosRealizados());
        cantMov.setBounds(55, 20, 208, 40);
        cantMov.setFont(new Font("Georgia", Font.BOLD, 20));
        cantMov.setForeground(Color.WHITE);
        panelControles.add(cantMov);
        
        movimientosRestantes = new JLabel("Disponibles: " + miJuego.cantidadMovimientosDisponibles());
        movimientosRestantes.setBounds(55, 71, 187, 24);
        movimientosRestantes.setFont(new Font("Georgia", Font.BOLD, 20));
        movimientosRestantes.setForeground(Color.WHITE);
        panelControles.add(movimientosRestantes);
        
        arriba.addActionListener(crearMovimientoListener("ARRIBA"));
        abajo.addActionListener(crearMovimientoListener("ABAJO"));
        derecha.addActionListener(crearMovimientoListener("DERECHA"));
        izquierda.addActionListener(crearMovimientoListener("IZQUIERDA"));

        asignarAccionesConTeclado(panelControles, "UP", crearMovimientoListener("ARRIBA"));
        asignarAccionesConTeclado(panelControles, "DOWN", crearMovimientoListener("ABAJO"));
        asignarAccionesConTeclado(panelControles, "LEFT", crearMovimientoListener("IZQUIERDA"));
        asignarAccionesConTeclado(panelControles, "RIGHT", crearMovimientoListener("DERECHA"));  
    }
    
    private JButton crearBotonesDePanelDeControl(String text, String iconPath, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setIcon(new ImageIcon(getClass().getResource(iconPath)));
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Georgia", Font.BOLD, 24));
        button.setForeground(Color.BLACK);
        return button;
    }

    private void actualizarPosicionDeLosBotones() { 
        for (int i = 0; i < miJuego.obtenerLongitudDeTablero(); i++) {
            for (int j = 0; j < miJuego.obtenerLongitudDeTablero(); j++) {
                int valor = miJuego.getValor(i, j);
                JButton boton = (JButton) panelTablero.getComponent(i * miJuego.obtenerLongitudDeTablero() + j);
                boton.setIcon(imagenes[valor]);
            }
        }
        cantMov.setText("Movimientos: " + miJuego.cantidadMovimientosRealizados());
        movimientosRestantes.setText("Disponibles: " + miJuego.cantidadMovimientosDisponibles());
    }

    private void crearBotonesPanelTablero() {
        for (int i = 0; i < miJuego.obtenerLongitudDeTablero(); i++) {
            for (int j = 0; j < miJuego.obtenerLongitudDeTablero(); j++) {
                int valor = miJuego.getValor(i, j);
                JButton boton = new JButton();
                boton.setIcon(imagenes[valor]);
                boton.setPreferredSize(new Dimension(124, 140));
                panelTablero.add(boton); 
            }
        }
    }
    
    public void chequeoDerrota() {
    	if(miJuego.verficarDerrota()) {
    		pantallaDerrota perdiste = new pantallaDerrota();
    		perdiste.setVisible(true);
    		this.frameJuego.dispose();
    	}
    }
   
    public void chequeoVictoria() {
    	if(miJuego.verificarVictoria()) {
    		pantallaVictoria ganaste = new pantallaVictoria();
    		ganaste.setVisible(true);
    		this.frameJuego.dispose();
    	}
    }
    
    private ActionListener crearMovimientoListener(String direccion) {
    	return e -> {
    		switch (direccion) {
    		case "ARRIBA": miJuego.moverArriba(); break;
    		case "ABAJO": miJuego.moverAbajo(); break;
    		case "IZQUIERDA": miJuego.moverIzquierda(); break;
    		case "DERECHA": miJuego.moverDerecha(); break;
    		}
    		actualizarPosicionDeLosBotones(); 
    		chequeoVictoria();
    		chequeoDerrota();
    	};
    }

    @SuppressWarnings("serial")
    private void asignarAccionesConTeclado(JPanel panel, String keyStroke, ActionListener action) {
    	InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    	ActionMap actionMap = panel.getActionMap();
    	inputMap.put(KeyStroke.getKeyStroke(keyStroke), keyStroke);
    	actionMap.put(keyStroke, new AbstractAction() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			action.actionPerformed(e);
    		}
    	});
    }
    
    private void cargarImagenesAlTablero() {
        int botonAncho = 124; 
        int botonAlto = 140;

        for (int i = 0; i < imagenes.length; i++) {
            ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/imagenes/" + nombreDeImagen + i + ".png"));
            Image imagen = iconoOriginal.getImage();
            Image imagenEscalada = imagen.getScaledInstance(botonAncho, botonAlto, Image.SCALE_SMOOTH);
            imagenes[i] = new ImageIcon(imagenEscalada);
        }
    }
}


