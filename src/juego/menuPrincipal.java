package juego;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal frame = new menuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("Menú principal");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton modoClasico = new JButton();
		modoClasico.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        TableroDeJuego juego = new TableroDeJuego("numero"); 
		        juego.frameJuego.setVisible(true);
		        dispose();
		    }
		});
		modoClasico.setBounds(250, 160, 286, 100);
		modoClasico.setFont(new Font("Georgia", Font.BOLD, 20));
		modoClasico.setIcon(new ImageIcon(getClass().getResource("/imagenes/boton.gif")));
		modoClasico.setHorizontalTextPosition(SwingConstants.CENTER); 
		modoClasico.setVerticalTextPosition(SwingConstants.CENTER); 
		modoClasico.setText("Modo clásico"); 
		modoClasico.setFont(new Font("Georgia", Font.BOLD, 20));
		modoClasico.setForeground(Color.WHITE);
		contentPane.add(modoClasico);
		
		JButton modoImagenes = new JButton("Modo Imagenes");
		modoImagenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeleccionDeImagenes juego = new SeleccionDeImagenes();
				juego.setVisible(true);
				dispose();
			}
		});
		modoImagenes.setBounds(250, 300, 286, 100);
		modoImagenes.setFont(new Font("Georgia", Font.BOLD, 20));
		modoImagenes.setIcon(new ImageIcon(getClass().getResource("/imagenes/boton.gif")));
		modoImagenes.setHorizontalTextPosition(SwingConstants.CENTER); 
		modoImagenes.setVerticalTextPosition(SwingConstants.CENTER); 
		modoImagenes.setText("Modo imagenes"); 
		modoImagenes.setFont(new Font("Georgia", Font.BOLD, 20));
		modoImagenes.setForeground(Color.WHITE);
		contentPane.add(modoImagenes);
		
		JLabel titulo = new JLabel("Elija su modo de juego preferido");
		titulo.setBounds(140, 37, 594, 43);
		titulo.setFont(new Font("Georgia", Font.BOLD, 30));
		titulo.setForeground(Color.WHITE);
		contentPane.add(titulo);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(getClass().getResource("/imagenes/fondo.png")));
		fondo.setBounds(0, 0, 800, 600);
		contentPane.add(fondo);
		fondo.setBounds(0, 0, 800, 600);
		contentPane.add(fondo);	
	}
}
