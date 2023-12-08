package data;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Panel;

public class Barrita {
	JFrame frmBarraDeProgreso;
	private JProgressBar barraProgreso;
	String nombre = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Barrita window = new Barrita();
					window.frmBarraDeProgreso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Barrita() {
		initialize();
		start();
	}

	public void start() {
	
	
		Thread hilo = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i <= 100; i++) {

					barraProgreso.setValue(i);
					try {
						Thread.sleep(18);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (i == 100) {
						Inicio inicio =new Inicio();
						inicio.frmInicio.setVisible(true);
						frmBarraDeProgreso.setVisible(false);
					}
				}
			}
		});
		hilo.start();
	}

	private void initialize() {
		frmBarraDeProgreso = new JFrame();
		frmBarraDeProgreso.getContentPane().setBackground(new Color(255, 228, 225));
		frmBarraDeProgreso.setBounds(100, 100, 450, 300);
		frmBarraDeProgreso.setLocationRelativeTo(null);
		frmBarraDeProgreso.getContentPane().setLayout(null);

		barraProgreso = new JProgressBar();
		barraProgreso.setForeground(new Color(0, 0, 0));
		barraProgreso.setStringPainted(true);
		barraProgreso.setFont(new Font("Tahoma", Font.BOLD, 20));
		barraProgreso.setBounds(46, 97, 0, 45);
		frmBarraDeProgreso.getContentPane().add(barraProgreso);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\karla\\Downloads\\p.gif"));
		lblNewLabel.setBounds(0, 211, 436, 52);
		frmBarraDeProgreso.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\karla\\Downloads\\p.gif"));
		lblNewLabel_1.setBounds(0, 0, 436, 19);
		frmBarraDeProgreso.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\karla\\OneDrive\\Imágenes\\drawing-cartoon-flower-dividing-line-gif-dynamic-map-pink_2733818.png!bw700.gif"));
		lblNewLabel_3.setBounds(0, 24, 436, 200);
		frmBarraDeProgreso.getContentPane().add(lblNewLabel_3);

	}
}