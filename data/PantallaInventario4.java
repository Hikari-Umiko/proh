package data;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Image;
import com.itextpdf.text.Font;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

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
import java.awt.Color;
import java.awt.Desktop;
public class PantallaInventario4 {

	JFrame frmPantallaInventario4;
	DefaultTableModel model=new DefaultTableModel();
	private JTable tblinve;
	private JTable tblInventario;
	private JTextField txtID;
	private JTextField txtModelo;
	private JTextField txtDiseñador;
	private JTextField txtPrecio;
	private JTextField txtFecha;
	private JTextField txtCantidad;
	Inventario4 in = new Inventario4();
	ArrayList<Inventario4>listaInventario=new ArrayList<Inventario4>();
	Inventario4 x=null;
	ArrayList<Inventario4> lista;
	int fila=0;
	int id=0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInventario4 window = new PantallaInventario4();
					window.frmPantallaInventario4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaInventario4() {
		initialize();
		actualizarTabla();
	}
	 public void actualizarTabla() {
     	DataInventario4 da = new DataInventario4();
     	while(model.getRowCount()>0) {
     		model.removeRow(0);
     	}
	    lista=da.selectInventarios();
	     for (Inventario4 a : lista) {
	    	 
	    	 Object o[]=new Object[6];
	    	 o[0]=a.getIdinventario();
	    	 o[1]=a.getModelo();
	    	 o[2]=a.getCantidad();
	    	 o[3]=a.getDiseñador();
	    	 o[4]=a.getPrecio();
	    	 o[5]=a.getFecha();
	    	 model.addRow(o);
	     }

     }
	private void initialize() {
		frmPantallaInventario4 = new JFrame();
		frmPantallaInventario4.getContentPane().setBackground(new Color(238, 232, 170));
		frmPantallaInventario4.setBounds(100, 100, 800, 592);
		frmPantallaInventario4.setLocationRelativeTo(null);
		frmPantallaInventario4.getContentPane().setLayout(null);
		frmPantallaInventario4.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 226, 1372, 663);
		frmPantallaInventario4.getContentPane().add(scrollPane);

		tblInventario = new JTable();
		tblInventario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblInventario.getSelectedRow();
				x = lista.get(fila);
				txtID.setText("" + x.getIdinventario());
				txtModelo.setText(x.getModelo());
				txtCantidad.setText(x.getCantidad());
				txtDiseñador.setText(x.getDiseñador());
				txtPrecio.setText(x.getPrecio());
				txtFecha.setText(x.getFecha());
				actualizarTabla();
			}
		});
		scrollPane.setViewportView(tblInventario);
		model.addColumn("ID");
		model.addColumn("Modelo");
		model.addColumn("Cantidad");
		model.addColumn("Diseñador");
		model.addColumn("Precio");
		model.addColumn("Fecha");
		tblInventario.setModel(model);
		scrollPane.setViewportView(tblInventario);
		
		txtID = new JTextField();
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtID.getText().length() > 30) {
					e.consume();
				}
			}
		});
		txtID.setBounds(186, 20, 161, 30);
		frmPantallaInventario4.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtModelo.getText().length() > 30) {
					e.consume();
				}
			}
		});
		txtModelo.setBounds(186, 70, 161, 28);
		frmPantallaInventario4.getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		txtDiseñador = new JTextField();
		txtDiseñador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtDiseñador.getText().length() > 30) {
					e.consume();
				}
			}
		});
		txtDiseñador.setBounds(186, 165, 161, 30);
		frmPantallaInventario4.getContentPane().add(txtDiseñador);
		txtDiseñador.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtPrecio.getText().length() > 100) {
					e.consume();
				}
			}
		});
		txtPrecio.setBounds(455, 20, 161, 30);
		frmPantallaInventario4.getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtFecha.getText().length() > 30) {
					e.consume();
				}
			}
		});
		txtFecha.setBounds(455, 70, 161, 28);
		frmPantallaInventario4.getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		txtCantidad.setBounds(186, 117, 161, 28);
		frmPantallaInventario4.getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(21, 21, 45, 30);
		frmPantallaInventario4.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Modelo");
		lblNewLabel_1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(21, 70, 84, 28);
		frmPantallaInventario4.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad");
		lblNewLabel_2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(21, 117, 96, 28);
		frmPantallaInventario4.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Diseñador");
		lblNewLabel_3.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(21, 167, 114, 28);
		frmPantallaInventario4.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Precio");
		lblNewLabel_4.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(373, 20, 72, 30);
		frmPantallaInventario4.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha");
		lblNewLabel_5.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(373, 70, 84, 28);
		frmPantallaInventario4.getContentPane().add(lblNewLabel_5);
		
		JButton btnInsertar = new JButton("");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Inventario4 c = new Inventario4();
					c.setIdinventario(Integer.parseInt(txtID.getText()));
					c.setModelo(txtModelo.getText());
					c.setCantidad(txtCantidad.getText());
					c.setDiseñador(txtDiseñador.getText());
					c.setPrecio(txtPrecio.getText());
					c.setFecha(txtFecha.getText());
					if (c.insertarInventario()) {
						limpiar();
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "Se inserto correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "Error al insertar");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error al insertar");
				}
			}
		});
		btnInsertar.setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/Agregar.png")),85,78));
		btnInsertar.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		btnInsertar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInsertar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnInsertar.setHorizontalAlignment(SwingConstants.CENTER);
		btnInsertar.setBounds(383, 117, 85, 78);
		frmPantallaInventario4.getContentPane().add(btnInsertar);
	
	
		
		JButton btnActualizar = new JButton("");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					in.setIdinventario(Integer.parseInt(txtID.getText()));
					in.setModelo(txtModelo.getText());
					in.setCantidad(txtCantidad.getText());
					in.setDiseñador(txtDiseñador.getText());
					in.setPrecio(txtPrecio.getText());
					in.setFecha(txtFecha.getText());
					if (in.actualizarInventario()) {
						limpiar();
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "Se inserto correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "Error al insertar");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error al insertar");
				}
			}
		});
		btnActualizar.setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/act.png")),85,78));
		btnActualizar.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		btnActualizar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnActualizar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnActualizar.setHorizontalAlignment(SwingConstants.CENTER);
		btnActualizar.setBounds(614, 117, 85, 78);
		frmPantallaInventario4.getContentPane().add(btnActualizar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idinventario = Integer.parseInt(JOptionPane.showInputDialog("Id a Eliminar"));
					in.setIdinventario(idinventario);
					if (in.eliminarInventario()) {
						txtID.setText("" + in.getIdinventario());
						txtModelo.setText(in.getModelo());
						txtCantidad.setText(in.getCantidad());
						txtDiseñador.setText(in.getDiseñador());
						txtPrecio.setText(in.getPrecio());
						txtFecha.setText(in.getFecha());
						limpiar();
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "Se elimino correctamante");
					} else {
						JOptionPane.showMessageDialog(null, "Error al eliminar");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error al eliminar");
				}
			}
		});
		btnEliminar.setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/eliminar.jpg")),85,78));
		btnEliminar.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		btnEliminar.setBounds(498, 117, 85, 78);
		frmPantallaInventario4.getContentPane().add(btnEliminar);
		
		JLabel lblNewLabel_6 = new JLabel("Inventario De Calzado");
		lblNewLabel_6.setFont(new java.awt.Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_6.setBounds(668, 19, 424, 79);
		frmPantallaInventario4.getContentPane().add(lblNewLabel_6);
		
		JButton btnPDF = new JButton("");
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarPDF();
			}
		});
		btnPDF.setIcon(cambiar(new ImageIcon(getClass().getResource("/imagenes/PDF.jpg")),85,78));
		btnPDF.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
		btnPDF.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPDF.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPDF.setHorizontalAlignment(SwingConstants.CENTER);
		btnPDF.setBounds(733, 117, 85, 78);
		frmPantallaInventario4.getContentPane().add(btnPDF);
	}
	public void limpiar() {
		txtID.setText("");
		txtModelo.setText("");
		txtCantidad.setText("");
		txtDiseñador.setText("");
		txtPrecio.setText("");
		txtFecha.setText("");
	}
	public ImageIcon cambiar(ImageIcon img, int ancho, int alto) {
		java.awt.Image imgEscalada = img.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(imgEscalada);
		return image;
	}
	public void generarPDF() {
        try {
               FileOutputStream archivo;
               //RUTA ABSOLUTA
               File file = new File("C:\\Users\\karla\\eclipse-workspace\\Aña\\src\\PDF\\Calzado.pdf");
               //RUTA RELATIVA
//               File file = new File("pdf/reporteUsuario.pdf");
               //JOptionPane.showMessageDialog(frmCrudCelular, "Ruta Path:" + file.getPath());
               //JOptionPane.showMessageDialog(frmCrudCelular, "Ruta Absoluta:" + file.getAbsolutePath());
               //JOptionPane.showMessageDialog(frmCrudCelular, "Ruta Canonica:" + file.getCanonicalPath());
               archivo = new FileOutputStream(file);
               Document doc = new Document();
               PdfWriter.getInstance(doc, archivo);
               doc.open();
              Image img = Image.getInstance("C:\\Users\\karla\\eclipse-workspace\\Aña\\src\\Imagenes\\PDF.jpg");
//               Image img = Image.getInstance(getClass().getResource("/imagenes/logooxxo.png"));
               img.setAlignment(Element.ALIGN_CENTER);
               img.scaleToFit(50, 50);
               doc.add(img);
               Paragraph p = new Paragraph(10);
               Font negrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
               p.add(Chunk.NEWLINE);
               p.add("CONTROL DE INVENTARIO DE CALZADO");
               p.add(Chunk.NEWLINE);
               p.add(Chunk.NEWLINE);
               p.setAlignment(Element.ALIGN_CENTER);
               doc.add(p);
               //Tabla de datos
               PdfPTable tabla = new PdfPTable(5);
               tabla.setWidthPercentage(100);
               PdfPCell c1 = new PdfPCell(new Phrase("ID CALZADO", negrita));
               PdfPCell c2 = new PdfPCell(new Phrase("MODELO", negrita));
               PdfPCell c3 = new PdfPCell(new Phrase("CANTIDAD", negrita));
               PdfPCell c4 = new PdfPCell(new Phrase("DISEÑADOR", negrita));
               PdfPCell c5 = new PdfPCell(new Phrase("PRECIO", negrita));
               PdfPCell c6 = new PdfPCell(new Phrase("FECHA", negrita));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               c2.setHorizontalAlignment(Element.ALIGN_CENTER);
               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
               c4.setHorizontalAlignment(Element.ALIGN_CENTER);
               c5.setHorizontalAlignment(Element.ALIGN_CENTER);
               c6.setHorizontalAlignment(Element.ALIGN_CENTER);
               c1.setBackgroundColor(BaseColor.PINK);
               c2.setBackgroundColor(BaseColor.BLUE);
               c3.setBackgroundColor(BaseColor.ORANGE);
               c4.setBackgroundColor(BaseColor.GREEN);
               c5.setBackgroundColor(BaseColor.RED);
               c5.setBackgroundColor(BaseColor.CYAN);
               tabla.addCell(c1);
               tabla.addCell(c2);
               tabla.addCell(c3);
               tabla.addCell(c4);
               tabla.addCell(c5);
               tabla.addCell(c6);
               //Agregar los registros
               DataInventario4 dc=new DataInventario4();
               listaInventario=dc.selectInventarios();
               for (Inventario4 c : listaInventario) {
                   tabla.addCell("" +c.getIdinventario());
                   tabla.addCell("" + c.getModelo());
                   tabla.addCell("" + c.getCantidad());
                   tabla.addCell("" + c.getDiseñador());
                   tabla.addCell("" + c.getPrecio());
                   tabla.addCell("" + c.getFecha());
               }
               doc.add(tabla);
               Paragraph p1 = new Paragraph(10);
               p1.add(Chunk.NEWLINE);
               p1.add("NÚMERO DE CALZADO: " + listaInventario.size());
               p1.add(Chunk.NEWLINE);
               p1.add(Chunk.NEWLINE);
               p1.setAlignment(Element.ALIGN_RIGHT);
               doc.add(p1);
               doc.close();
               archivo.close();
               Desktop.getDesktop().open(file);
           } catch (FileNotFoundException ex) {
           } catch (DocumentException ex) {
           } catch (IOException ex) {
               JOptionPane.showMessageDialog(frmPantallaInventario4, "" + ex.getMessage());
               //Logger.getLogger(todosPDF.class.getName()).log(Level.SEVERE, null, ex);
           }
   }
}
