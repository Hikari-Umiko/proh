package data;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Desktop;

public class PantallaClientes {

	JFrame frmPantallaClientes;
	private JTable tblClientes;
	DefaultTableModel model=new DefaultTableModel();
	Clientes x=null;
	ArrayList<Clientes> lista;
	int fila=0;
	int id=0;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JButton btnPDF;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	ArrayList<Clientes>listaClientes=new ArrayList<Clientes>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaClientes window = new PantallaClientes();
					window.frmPantallaClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaClientes() {
		initialize();
		actualizarTabla();
		
	}
        public void actualizarTabla() {
        	DataClientes da = new DataClientes();
        	while(model.getRowCount()>0) {
        		model.removeRow(0);
        	}
	    lista=da.selectClientes();
	     for (Clientes a : lista) {
	    	 
	    	 Object o[]=new Object[5];
	    	 o[0]=a.getIdclientes();
	    	 o[1]=a.getNombre();
	    	 o[2]=a.getTelefono();
	    	 o[3]=a.getCorreo();
	    	 o[4]=a.getPago();
	    	 model.addRow(o);
	     }

        }

	private void initialize() {
		frmPantallaClientes = new JFrame();
		frmPantallaClientes.getContentPane().setForeground(new Color(0, 0, 0));
		frmPantallaClientes.setBounds(100, 100, 873, 578);
		frmPantallaClientes.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 101, 629, 419);
		frmPantallaClientes.getContentPane().add(scrollPane);
		
		tblClientes = new JTable();
		tblClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane.setViewportView(tblClientes);
				model.addColumn("ID");
				model.addColumn("Nombre");
				model.addColumn("Correo");
				model.addColumn("Telefono");
				model.addColumn("Pago");
				tblClientes.setModel(model);
		scrollPane.setViewportView(tblClientes);
		
		btnPDF = new JButton("");
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
		btnPDF.setBounds(733, 121, 102, 97);
		frmPantallaClientes.getContentPane().add(btnPDF);
		
		lblNewLabel = new JLabel("Registro De Clientes");
		lblNewLabel.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(103, 10, 543, 81);
		frmPantallaClientes.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		panel.setBounds(0, 0, 859, 541);
		frmPantallaClientes.getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 204));
		panel_1.setBounds(76, 88, 694, 453);
		panel.add(panel_1);
		
		
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
               File file = new File("C:\\Users\\karla\\eclipse-workspace\\Aña\\src\\PDF\\Clientes.pdf");
               //RUTA RELATIVA
             //file = new File("/Aña/src/PDF/Clientes.pdf");
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
               p.add("CONTROL DE CLIENTES");
               p.add(Chunk.NEWLINE);
               p.add(Chunk.NEWLINE);
               p.setAlignment(Element.ALIGN_CENTER);
               doc.add(p);
               //Tabla de datos
               PdfPTable tabla = new PdfPTable(5);
               tabla.setWidthPercentage(100);
               PdfPCell c1 = new PdfPCell(new Phrase("ID CLIENTE", negrita));
               PdfPCell c2 = new PdfPCell(new Phrase("NOMBRE", negrita));
               PdfPCell c3 = new PdfPCell(new Phrase("CORREO", negrita));
               PdfPCell c4 = new PdfPCell(new Phrase("TELEFONO", negrita));
               PdfPCell c5 = new PdfPCell(new Phrase("PAGO", negrita));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               c2.setHorizontalAlignment(Element.ALIGN_CENTER);
               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
               c4.setHorizontalAlignment(Element.ALIGN_CENTER);
               c5.setHorizontalAlignment(Element.ALIGN_CENTER);
               c1.setBackgroundColor(BaseColor.PINK);
               c2.setBackgroundColor(BaseColor.BLUE);
               c3.setBackgroundColor(BaseColor.ORANGE);
               c4.setBackgroundColor(BaseColor.GREEN);
               c5.setBackgroundColor(BaseColor.RED);
               tabla.addCell(c1);
               tabla.addCell(c2);
               tabla.addCell(c3);
               tabla.addCell(c4);
               tabla.addCell(c5);
               //Agregar los registros
               DataClientes dc=new DataClientes();
               listaClientes=dc.selectClientes();
               for (Clientes c : listaClientes) {
                   tabla.addCell("" +c.getIdclientes());
                   tabla.addCell("" + c.getNombre());
                   tabla.addCell("" + c.getCorreo());
                   tabla.addCell("" + c.getTelefono());
                   tabla.addCell("" + c.getPago());
               }
               doc.add(tabla);
               Paragraph p1 = new Paragraph(10);
               p1.add(Chunk.NEWLINE);
               p1.add("NÚMERO DE CLIENTES: " + listaClientes.size());
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
               JOptionPane.showMessageDialog(frmPantallaClientes, "" + ex.getMessage());
               //Logger.getLogger(todosPDF.class.getName()).log(Level.SEVERE, null, ex);
           }
   }
}