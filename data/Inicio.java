package data;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;

public class Inicio {

	JFrame frmInicio;
	String nombre="";
	private JDesktopPane desktopPane;
	private final JPanel panel = new JPanel();
	private JMenu mnInventario;
	private JMenuItem mntmSacos;

	public Inicio() {
		initialize();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInicio = new JFrame();
		frmInicio.setBounds(100, 100, 450, 300);
		frmInicio.setLocationRelativeTo(null);
		frmInicio.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 228, 225));
		frmInicio.setJMenuBar(menuBar);
		
		mnInventario = new JMenu("Inventario");
		mnInventario.setOpaque(true);
		mnInventario.setBackground(new Color(255, 228, 225));
		mnInventario.setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/Inv.jpg")),85,78));
		mnInventario.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		mnInventario.setHorizontalTextPosition(SwingConstants.CENTER);
		mnInventario.setVerticalTextPosition(SwingConstants.BOTTOM);
		mnInventario.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnInventario);
		
		mntmSacos = new JMenuItem("Sacos");
		mntmSacos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaInventario c=new PantallaInventario();
				c.frmPantallaInventario.setVisible(true);
			}
		});
		mntmSacos.setOpaque(true);
		mntmSacos.setBackground(new Color(255, 228, 225));
		mntmSacos.setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/saco.jpg")),85,78));
		mntmSacos.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		mntmSacos.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmSacos.setVerticalTextPosition(SwingConstants.BOTTOM);
		mntmSacos.setHorizontalAlignment(SwingConstants.CENTER);
		mnInventario.add(mntmSacos);
		
		JMenuItem mntmVestidos = new JMenuItem("Vestidos");
		mntmVestidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaInventario2 c=new PantallaInventario2();
				c.frmPantallaInventario2.setVisible(true);
			}
		});
		mntmVestidos .setOpaque(true);
		mntmVestidos .setBackground(new Color(255, 228, 225));
		mntmVestidos .setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/vestido.jpg")),85,78));
		mntmVestidos .setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		mntmVestidos .setHorizontalTextPosition(SwingConstants.CENTER);
		mntmVestidos .setVerticalTextPosition(SwingConstants.BOTTOM);
		mntmVestidos .setHorizontalAlignment(SwingConstants.CENTER);
		mnInventario.add(mntmVestidos);
		
		JMenuItem mntmConjuntos = new JMenuItem("Conjuntos");
		mntmConjuntos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaInventario3 c=new PantallaInventario3();
				c.frmPantallaInventario3.setVisible(true);
			}
		});
		mntmConjuntos .setOpaque(true);
		mntmConjuntos .setBackground(new Color(255, 228, 225));
		mntmConjuntos .setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/Conju.jpeg")),85,78));
		mntmConjuntos .setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		mntmConjuntos .setHorizontalTextPosition(SwingConstants.CENTER);
		mntmConjuntos .setVerticalTextPosition(SwingConstants.BOTTOM);
		mntmConjuntos .setHorizontalAlignment(SwingConstants.CENTER);
		mnInventario.add(mntmConjuntos);
		
		JMenuItem mntmCalzado = new JMenuItem("Calzado");
		mntmCalzado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaInventario4 c=new PantallaInventario4();
				c.frmPantallaInventario4.setVisible(true);
			}
		});
		mntmCalzado .setOpaque(true);
		mntmCalzado .setBackground(new Color(255, 228, 225));
		mntmCalzado .setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/Calzado.jpg")),85,78));
		mntmCalzado .setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		mntmCalzado .setHorizontalTextPosition(SwingConstants.CENTER);
		mntmCalzado .setVerticalTextPosition(SwingConstants.BOTTOM);
		mntmCalzado .setHorizontalAlignment(SwingConstants.CENTER);
		mnInventario.add(mntmCalzado);
		
		JMenuItem mntmParaguas = new JMenuItem("Paraguas");
		mntmParaguas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaInventario5 c=new PantallaInventario5();
				c.frmPantallaInventario5.setVisible(true);
			}
		});
		mntmParaguas .setOpaque(true);
		mntmParaguas .setBackground(new Color(255, 228, 225));
		mntmParaguas .setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/Para.jpeg")),85,78));
		mntmParaguas .setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		mntmParaguas .setHorizontalTextPosition(SwingConstants.CENTER);
		mntmParaguas .setVerticalTextPosition(SwingConstants.BOTTOM);
		mntmParaguas .setHorizontalAlignment(SwingConstants.CENTER);
		mnInventario.add(mntmParaguas);
		
		JMenu mnRegistros = new JMenu("Registros");
		mnRegistros.setOpaque(true);
		mnRegistros.setBackground(new Color(255, 228, 225));
		mnRegistros.setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/Rg.png")),85,78));
		mnRegistros.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		mnRegistros.setHorizontalTextPosition(SwingConstants.CENTER);
		mnRegistros.setVerticalTextPosition(SwingConstants.BOTTOM);
		mnRegistros.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnRegistros);
		
		JMenuItem mntmClientes = new JMenuItem("Registro Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaRegistro c=new PantallaRegistro();
				c.frmPantallaRegistro.setVisible(true);
			}
		});
		mntmClientes.setOpaque(true);
		mntmClientes.setBackground(new Color(255, 228, 225));
		mntmClientes.setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/cl.png")),85,78));
		mntmClientes.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		mntmClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmClientes.setVerticalTextPosition(SwingConstants.BOTTOM);
		mntmClientes.setHorizontalAlignment(SwingConstants.CENTER);
		mnRegistros.add(mntmClientes);
		
		JMenuItem mntmDiseñadores = new JMenuItem("Registro Diseñadores");
		mntmDiseñadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaRegistroD c=new PantallaRegistroD();
				c.frmPantallaRegistroD.setVisible(true);
			}
		});
		mntmDiseñadores.setOpaque(true);
		mntmDiseñadores.setBackground(new Color(255, 228, 225));
		mntmDiseñadores.setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/Diseñad.jpg")),85,78));
		mntmDiseñadores.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		mntmDiseñadores.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmDiseñadores.setVerticalTextPosition(SwingConstants.BOTTOM);
		mntmDiseñadores.setHorizontalAlignment(SwingConstants.CENTER);
		mnRegistros.add(mntmDiseñadores);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBackground(new Color(255, 228, 225));
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaClientes c=new PantallaClientes();
				c.frmPantallaClientes.setVisible(true);
			}
		});
		btnClientes.setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/Clien.png")),85,78));
		btnClientes.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		btnClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnClientes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnClientes.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(btnClientes);
		
		JButton btnDiseñadores = new JButton("Diseñadores");
		btnDiseñadores.setBackground(new Color(255, 228, 225));
		btnDiseñadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaDiseñador c=new PantallaDiseñador();
				c.frmPantallaDiseñador.setVisible(true);
			}
		});
		btnDiseñadores.setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/Dis.jpg")),85,78));
		btnDiseñadores.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		btnDiseñadores.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDiseñadores.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDiseñadores.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(btnDiseñadores);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(255, 228, 225));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login c=new Login();
				c.frmLogin.setVisible(true);
				frmInicio.setVisible(false);
			}
		});
		btnSalir.setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/images - 2023-12-05T105052.631.jpeg")),85,78));
		btnSalir.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalir.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(btnSalir);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(10, 845, 1089, 0);
		frmInicio.getContentPane().add(desktopPane_1);
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, -51, 1563, 896);
		frmInicio.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\karla\\OneDrive\\Imágenes\\ini.jpg"));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(114, -23, 1542, 819);
		panel.add(lblNewLabel_1);
	}
	public ImageIcon cambiar(ImageIcon img, int ancho, int alto) {
		java.awt.Image imgEscalada = img.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(imgEscalada);
		return image;
	}
}
