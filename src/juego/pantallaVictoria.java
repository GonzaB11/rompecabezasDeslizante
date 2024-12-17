package juego;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class pantallaVictoria extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallaVictoria window = new pantallaVictoria();
					window.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pantallaVictoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("Pantalla victoria");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel gifFeliz = new JLabel();
	    gifFeliz.setIcon(new ImageIcon(getClass().getResource("/imagenes/ganaste.gif"))); 
	    gifFeliz.setBounds(137, 149, 510, 255);
	    contentPane.add(gifFeliz);
		
		JButton volverAJugar = new JButton();
		volverAJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal menu = new menuPrincipal();
				menu.setVisible(true);
				dispose();
			}
		});
		volverAJugar.setBounds(40, 428, 286, 100);
		volverAJugar.setFont(new Font("Georgia", Font.BOLD, 20));
		volverAJugar.setIcon(new ImageIcon(getClass().getResource("/imagenes/botonVictoria.gif")));
		volverAJugar.setHorizontalTextPosition(SwingConstants.CENTER); 
		volverAJugar.setVerticalTextPosition(SwingConstants.CENTER); 
		volverAJugar.setText("Menú principal"); 
		volverAJugar.setFont(new Font("Georgia", Font.BOLD, 20));
		volverAJugar.setForeground(Color.BLACK);
		contentPane.add(volverAJugar);
		
		JButton salir = new JButton();
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		salir.setBounds(460, 428, 286, 100);
		salir.setFont(new Font("Georgia", Font.BOLD, 20));
		salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/botonVictoria.gif")));
		salir.setHorizontalTextPosition(SwingConstants.CENTER); 
		salir.setVerticalTextPosition(SwingConstants.CENTER); 
		salir.setText("Salir"); 
		salir.setFont(new Font("Georgia", Font.BOLD, 20));
		salir.setForeground(Color.BLACK);
		contentPane.add(salir);
		
		JLabel titulo = new JLabel("Felicidades, has ganado!!!");
		titulo.setBounds(55, -17 ,800, 200);
		titulo.setFont(new Font("Georgia", Font.BOLD, 50));
		titulo.setForeground(Color.WHITE);
		contentPane.add(titulo);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(getClass().getResource("/imagenes/pantallaGanaste.png")));
		fondo.setBounds(0, 0, 800, 600);
		contentPane.add(fondo);
	}
}
