package data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaUsuario {

	private JFrame frame;
	private JTextField txtCorreo;
	private JTextField txtPassword;
	private JLabel txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaUsuario window = new PantallaUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtCorreo = new JTextField();
		txtCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCorreo.getText().length() > 30) {
					e.consume();
				}
			}
		});
		txtCorreo.setBounds(68, 78, 96, 19);
		frame.getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtPassword.getText().length() > 100) {
					e.consume();
				}
			}
		});
		txtPassword.setBounds(68, 145, 96, 19);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("c");
		lblNewLabel.setBounds(10, 81, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("p");
		lblNewLabel_1.setBounds(10, 148, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnInsertar = new JButton("New button");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Usuario c = new Usuario();
				
					c.setCorreo(txtCorreo.getText());
					c.setPassword(encriptarPassword(txtPassword.getText()));
					if (c.insertarUsuario()) {
						JOptionPane.showMessageDialog(null, "Se inserto correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "Error al insertar");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error al insertar");
				}
			}
		});
		btnInsertar.setBounds(267, 161, 85, 21);
		frame.getContentPane().add(btnInsertar);
		
		txtID = new JLabel("New label");
		txtID.setBounds(74, 33, 45, 13);
		frame.getContentPane().add(txtID);
	}
	public String encriptarPassword(String password) {
		MessageDigest md;
		byte[]encoded = null;
		try {
			md=MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
			md.update(password.getBytes());
			byte[] digest = md.digest();
			for (byte b : digest) {
				//System.out.print(Integer.toHexString(0xFF & b));
			}
			System.out.println();
			encoded = Base64.encodeBase64(digest);
			//System.out.println(new String(encoded));
		}catch (NoSuchAlgorithmException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(encoded);
	}
}
