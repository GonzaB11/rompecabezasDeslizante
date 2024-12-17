package juego;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class pantallaDerrota extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallaDerrota window = new pantallaDerrota();
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
	public pantallaDerrota() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("Pantalla Derrota");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JLabel gifLlorando = new JLabel();
	    gifLlorando.setIcon(new ImageIcon(getClass().getResource("/imagenes/perdiste.gif"))); 
	    gifLlorando.setBounds(265, 163, 247, 227);
	    contentPane.add(gifLlorando);
		
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
		volverAJugar.setIcon(new ImageIcon(getClass().getResource("/imagenes/boton.gif")));
		volverAJugar.setHorizontalTextPosition(SwingConstants.CENTER); 
		volverAJugar.setVerticalTextPosition(SwingConstants.CENTER); 
		volverAJugar.setText("Menú principal"); 
		volverAJugar.setFont(new Font("Georgia", Font.BOLD, 20));
		volverAJugar.setForeground(Color.WHITE);
		contentPane.add(volverAJugar);
		
		JButton salir = new JButton();
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		salir.setBounds(460, 428, 286, 100);
		salir.setFont(new Font("Georgia", Font.BOLD, 20));
		salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/boton.gif")));
		salir.setHorizontalTextPosition(SwingConstants.CENTER); 
		salir.setVerticalTextPosition(SwingConstants.CENTER); 
		salir.setText("Salir"); 
		salir.setFont(new Font("Georgia", Font.BOLD, 20));
		salir.setForeground(Color.WHITE);
		contentPane.add(salir);
		
		JLabel titulo = new JLabel("Lo lamento, has perdido!!!");
		titulo.setBounds(56, -12 ,800, 200);
		titulo.setFont(new Font("Georgia", Font.BOLD, 50));
		titulo.setForeground(Color.WHITE);
		contentPane.add(titulo);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(getClass().getResource("/imagenes/perdiste.png")));
		fondo.setBounds(0, 0, 800, 600);
		contentPane.add(fondo);
	}
}
