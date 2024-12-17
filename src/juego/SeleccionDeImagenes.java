package juego;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeleccionDeImagenes extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionDeImagenes frame = new SeleccionDeImagenes();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeleccionDeImagenes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("Seleccionar imagenes");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton nobara = new JButton("New button");
		nobara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableroDeJuego juego = new TableroDeJuego("nobara"); 
		        juego.frameJuego.setVisible(true);
		        dispose();
			}
		});
		nobara.setBounds(0, 0, 395, 280);
		nobara.setIcon(new ImageIcon(getClass().getResource("/imagenes/nobara.png")));
		nobara.setHorizontalTextPosition(SwingConstants.CENTER); 
		nobara.setVerticalTextPosition(SwingConstants.CENTER); 
		nobara.setText("Nobara"); 
		nobara.setFont(new Font("Georgia", Font.BOLD, 20));
        nobara.setForeground(Color.BLACK);
		contentPane.add(nobara);
		
		JButton itadori = new JButton("New button");
		itadori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableroDeJuego juego = new TableroDeJuego("itadori"); 
				juego.frameJuego.setVisible(true);
		        dispose();
			}
		});
		itadori.setBounds(394, 0, 395, 280);
		itadori.setIcon(new ImageIcon(getClass().getResource("/imagenes/itadori.png")));
		itadori.setHorizontalTextPosition(SwingConstants.CENTER); 
		itadori.setVerticalTextPosition(SwingConstants.CENTER); 
		itadori.setText("Itadori"); 
        itadori.setFont(new Font("Georgia", Font.BOLD, 20));
        itadori.setForeground(Color.BLACK);
		contentPane.add(itadori);
		
		JButton megumi = new JButton("New button");
		megumi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableroDeJuego juego = new TableroDeJuego("fushiguro"); 
		        juego.frameJuego.setVisible(true);
		        dispose();
			}
		});
		megumi.setBounds(394, 281, 395, 280);
		megumi.setIcon(new ImageIcon(getClass().getResource("/imagenes/fushiguro.png")));
		megumi.setHorizontalTextPosition(SwingConstants.CENTER); 
        megumi.setVerticalTextPosition(SwingConstants.CENTER); 
		megumi.setText("Megumi"); 
        megumi.setFont(new Font("Georgia", Font.BOLD, 20));
        megumi.setForeground(Color.BLACK);
		contentPane.add(megumi);
		
		JButton gojo = new JButton("New button");
		gojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableroDeJuego juego = new TableroDeJuego("gojo"); 
		        juego.frameJuego.setVisible(true);
		        dispose();
			}
		});
		gojo.setBounds(0, 281, 395, 280);
		gojo.setIcon(new ImageIcon(getClass().getResource("/imagenes/gojo.png")));
		gojo.setHorizontalTextPosition(SwingConstants.CENTER); 
        gojo.setVerticalTextPosition(SwingConstants.CENTER); 
		gojo.setText("Gojo"); 
        gojo.setFont(new Font("Georgia", Font.BOLD, 20));
        gojo.setForeground(Color.BLACK);
		contentPane.add(gojo);
	}
}