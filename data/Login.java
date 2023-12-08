package data;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;



public class Login {

    JFrame frmLogin;
	private JTextField txtCorreo;
	private JPasswordField txtPassword;
	private JButton btnIniciar;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_5;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setBackground(new Color(255, 255, 255));
		frmLogin.getContentPane().setBackground(new Color(0, 0, 0));
		frmLogin.setForeground(new Color(0, 0, 0));
		frmLogin.getContentPane().setForeground(new Color(0, 0, 0));
		frmLogin.setBounds(100, 100, 1009, 604);
		frmLogin.setLocationRelativeTo(null);
		frmLogin.getContentPane().setLayout(null);
		
		txtCorreo = new JTextField("Hikari");
		txtCorreo.setBounds(640, 287, 255, 39);
		frmLogin.getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtPassword = new JPasswordField("291107");
		txtPassword.setBounds(640, 382, 255, 39);
		frmLogin.getContentPane().add(txtPassword);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario x=new Usuario();
					x.setCorreo(txtCorreo.getText());
					x.setPassword(encriptarPassword(txtPassword.getText()));
					if(x.insertarUsuario()) {
						JOptionPane.showMessageDialog(null, "BIENVENIDO");
						Barrita b=new Barrita();
						frmLogin.setVisible(false);
						b.frmBarraDeProgreso.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Correo y/o Password incorrecto");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnIniciar.setBounds(707, 466, 109, 39);
		frmLogin.getContentPane().add(btnIniciar);
		
		panel = new JPanel();
		panel.setBounds(10, 10, 975, 547);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 225));
		panel_1.setBounds(472, 0, 503, 547);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblNewLabel_2 = new JLabel("Log In");
		lblNewLabel_2.setFont(new Font("Goudy Old Style", Font.BOLD, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(158, 213, 175, 37);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo :");
		lblNewLabel_3.setFont(new Font("Goudy Old Style", Font.BOLD, 23));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(21, 278, 89, 37);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Contraseña :");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Goudy Old Style", Font.BOLD, 23));
		lblNewLabel_3_1.setBounds(10, 371, 122, 37);
		panel_1.add(lblNewLabel_3_1);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\karla\\Downloads\\aña_resized.png"));
		lblNewLabel_1.setBounds(158, 46, 166, 157);
		panel_1.add(lblNewLabel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 235, 205));
		panel_2.setBounds(108, 258, 301, 279);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\karla\\OneDrive\\Imágenes\\Log2.jpg"));
		lblNewLabel.setBounds(0, 0, 492, 103);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBackground(new Color(0, 255, 255));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(0, 85, 492, 405);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\karla\\Downloads\\Login (3)_compressed.png"));
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\karla\\OneDrive\\Imágenes\\Log2.jpg"));
		lblNewLabel_5.setBounds(0, 489, 492, 58);
		panel.add(lblNewLabel_5);
	}
public ImageIcon cambiar(ImageIcon img, int ancho, int alto) {
    Image imgEscalada = img.getImage().getScaledInstance(ancho,
            alto, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(imgEscalada);
    return image;
}

public String encriptarPassword(String password) {
	MessageDigest md;
	byte[] encoded = null;
	try {
		md = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
		md.update(password.getBytes());
		byte[] digest = md.digest();
		for (byte b : digest) {
			// System.out.print(Integer.toHexString(0xFF & b));
		}
		System.out.println();
		encoded = Base64.encodeBase64(digest);
		// System.out.println(new String(encoded));
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return new String(encoded);
}
	}

