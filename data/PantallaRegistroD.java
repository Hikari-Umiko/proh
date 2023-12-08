package data;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PantallaRegistroD {

	 JFrame frmPantallaRegistroD;
	 private JTextField txtID;
	 private JTextField txtNombre;
	 private JTextField txtInformacion;
	 private JTextField txtFecha;
	 private JPanel panel;
	 private JLabel lblNewLabel_4;
	 private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaRegistroD window = new PantallaRegistroD();
					window.frmPantallaRegistroD.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaRegistroD() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPantallaRegistroD= new JFrame();
		frmPantallaRegistroD.setBounds(100, 100, 376, 337);
		frmPantallaRegistroD.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 83, 45, 13);
		frmPantallaRegistroD.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 131, 73, 13);
		frmPantallaRegistroD.getContentPane().add(lblNewLabel_1);
		
		JButton btnInsertar = new JButton("");
		btnInsertar.setBounds(220, 100, 85, 77);
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RegistroD c = new RegistroD();
					c.setIddiseñador(Integer.parseInt(txtID.getText()));
					c.setNombre(txtNombre.getText());
					c.setFecha(txtFecha.getText());
					if (c.insertarDiseñador()) {
						limpiar();
						JOptionPane.showMessageDialog(null, "Se inserto correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "Error al insertar");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error al insertar");
				}
			}
		});
		btnInsertar.setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/Registra.jpeg")),85,78));
		btnInsertar.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		btnInsertar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInsertar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnInsertar.setHorizontalAlignment(SwingConstants.CENTER);
		frmPantallaRegistroD.getContentPane().add(btnInsertar);
		
		panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		panel.setBounds(0, 0, 362, 300);
		frmPantallaRegistroD.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel_4 = new JLabel("Registro Diseñadores");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(28, 5, 298, 54);
		panel.add(lblNewLabel_4);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 204));
		panel_1.setBounds(55, 69, 251, 162);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(40, 107, 96, 19);
		panel_1.add(txtFecha);
		txtFecha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtFecha.getText().length() > 30) {
					e.consume();
				}
			}
		});
		txtFecha.setColumns(10);
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(40, 57, 96, 19);
		panel_1.add(txtNombre);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNombre.getText().length() > 30) {
					e.consume();
				}
			}
		});
		txtNombre.setColumns(10);
		
		txtID = new JTextField();
		txtID.setBounds(40, 10, 96, 19);
		panel_1.add(txtID);
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtID.getText().length() > 30) {
					e.consume();
				}
			}
		});
		txtID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha");
		lblNewLabel_3.setBounds(10, 177, 53, 13);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\karla\\Downloads\\p.gif"));
		lblNewLabel_2.setBounds(0, 231, 362, 69);
		panel.add(lblNewLabel_2);
	}
	public void limpiar() {
		txtID.setText("");
		txtNombre.setText("");
		txtFecha.setText("");
	}
	public ImageIcon cambiar(ImageIcon img, int ancho, int alto) {
		java.awt.Image imgEscalada = img.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(imgEscalada);
		return image;
	}
}
