package data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;

public class PantallaRegistro {

	JFrame frmPantallaRegistro;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtPago;
	private JButton btnRegistrar;
	private JTextField txtID;
	private JLabel lblNewLabel_4;
	private JPanel panel;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaRegistro window = new PantallaRegistro();
					window.frmPantallaRegistro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPantallaRegistro = new JFrame();
		frmPantallaRegistro.setForeground(new Color(255, 255, 255));
		frmPantallaRegistro.setBackground(new Color(255, 255, 204));
		frmPantallaRegistro.setBounds(100, 100, 450, 300);
		frmPantallaRegistro.setLocationRelativeTo(null);
		frmPantallaRegistro.getContentPane().setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNombre.getText().length() > 30) {
					e.consume();
				}
			}
		});
		txtNombre.setBounds(91, 58, 96, 19);
		frmPantallaRegistro.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCorreo.getText().length() > 30) {
					e.consume();
				}
			}
		});
		txtCorreo.setBounds(91, 90, 96, 19);
		frmPantallaRegistro.getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtTelefono.getText().length() > 10) {
					e.consume();
				}
			}
		});
		txtTelefono.setBounds(91, 125, 96, 19);
		frmPantallaRegistro.getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 61, 71, 13);
		frmPantallaRegistro.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Correo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 93, 71, 13);
		frmPantallaRegistro.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 128, 71, 13);
		frmPantallaRegistro.getContentPane().add(lblNewLabel_2);
		
		btnRegistrar = new JButton("");
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Registro c = new Registro();
					c.setIdclientes(Integer.parseInt(txtID.getText()));
					c.setNombre(txtNombre.getText());
					c.setCorreo(txtCorreo.getText());
					c.setTelefono(txtTelefono.getText());
					c.setPago(txtPago.getText());
					if (c.insertarCliente()) {
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
		btnRegistrar.setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/Registro.jpg")),85,78));
		btnRegistrar.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		btnRegistrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRegistrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		btnRegistrar.setBounds(256, 81, 123, 113);
		frmPantallaRegistro.getContentPane().add(btnRegistrar);
		
		txtPago = new JTextField();
		txtPago.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtPago.getText().length() > 100) {
					e.consume();
				}
			}
		});
		txtPago.setBounds(91, 162, 96, 19);
		frmPantallaRegistro.getContentPane().add(txtPago);
		txtPago.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Pago");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 165, 71, 13);
		frmPantallaRegistro.getContentPane().add(lblNewLabel_3);
		
		txtID = new JTextField();
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtID.getText().length() > 100) {
					e.consume();
				}
			}
		});
		txtID.setBounds(91, 29, 96, 19);
		frmPantallaRegistro.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 32, 71, 13);
		frmPantallaRegistro.getContentPane().add(lblNewLabel_4);
		
		panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		panel.setForeground(new Color(255, 255, 204));
		panel.setBounds(0, 0, 436, 263);
		frmPantallaRegistro.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel_5 = new JLabel("Registro Clientes");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(207, 29, 219, 38);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\karla\\Downloads\\p.gif"));
		lblNewLabel_6.setBounds(0, 198, 436, 65);
		panel.add(lblNewLabel_6);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 204));
		panel_1.setBounds(65, 66, 314, 197);
		panel.add(panel_1);
	}
	public void limpiar() {
		txtID.setText("");
		txtNombre.setText("");
		txtCorreo.setText("");
		txtTelefono.setText("");
		txtPago.setText("");
	}
	public ImageIcon cambiar(ImageIcon img, int ancho, int alto) {
		java.awt.Image imgEscalada = img.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(imgEscalada);
		return image;
	}
}
