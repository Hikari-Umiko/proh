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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaDiseñador {

	JFrame frmPantallaDiseñador;
	private JTable tblDiseñador;
	DefaultTableModel model=new DefaultTableModel();
	Diseñador x=null;
	ArrayList<Diseñador> lista;
	int fila=0;
	int id=0;
	private JPanel panel;
	private JButton btnPDF;
	ArrayList<Diseñador>listaDiseñadores=new ArrayList<Diseñador>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaDiseñador window = new PantallaDiseñador();
					window.frmPantallaDiseñador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaDiseñador() {
		initialize();
        actualizarTabla();
		
	}
        public void actualizarTabla() {
        	DataDiseñador da = new DataDiseñador();
        	while(model.getRowCount()>0) {
        		model.removeRow(0);
        	}
        	lista=da.selectDiseñadores();
   	     for (Diseñador a : lista) {
   	    	 
   	    	 Object o[]=new Object[3];
   	    	 o[0]=a.getIddiseñador();
   	    	 o[1]=a.getNombre();
   	    	 o[2]=a.getFecha();
   	    	 model.addRow(o);
   	     }
        }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPantallaDiseñador = new JFrame();
		frmPantallaDiseñador.setBounds(100, 100, 754, 457);
		frmPantallaDiseñador.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Diseñadores");
		lblNewLabel.setFont(new java.awt.Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(201, 26, 300, 57);
		frmPantallaDiseñador.getContentPane().add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		panel.setBounds(0, 0, 740, 420);
		frmPantallaDiseñador.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 158, 555, 252);
		panel.add(scrollPane);
		
		tblDiseñador = new JTable();
		tblDiseñador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane.setViewportView(tblDiseñador);
		model.addColumn("ID");
		model.addColumn("Nombre");
		model.addColumn("Fecha De Ingreso");
		tblDiseñador.setModel(model);
		scrollPane.setViewportView(tblDiseñador);
		
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
		btnPDF.setBounds(613, 191, 95, 85);
		panel.add(btnPDF);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 204));
		panel_1.setBounds(71, 82, 596, 338);
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
               File file = new File("C:\\Users\\karla\\eclipse-workspace\\Aña\\src\\PDF\\Diseñadores.pdf");
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
               p.add("CONTROL DE DISEÑADORES");
               p.add(Chunk.NEWLINE);
               p.add(Chunk.NEWLINE);
               p.setAlignment(Element.ALIGN_CENTER);
               doc.add(p);
               //Tabla de datos
               PdfPTable tabla = new PdfPTable(5);
               tabla.setWidthPercentage(100);
               PdfPCell c1 = new PdfPCell(new Phrase("ID DISEÑADOR", negrita));
               PdfPCell c2 = new PdfPCell(new Phrase("NOMBRE", negrita));
               PdfPCell c3 = new PdfPCell(new Phrase("FECHA DE INGRESO", negrita));
               PdfPCell c4 = new PdfPCell(new Phrase("", negrita));
               PdfPCell c5 = new PdfPCell(new Phrase("", negrita));
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
               DataDiseñador dc=new DataDiseñador();
               listaDiseñadores=dc.selectDiseñadores();
               for (Diseñador c : listaDiseñadores) {
                   tabla.addCell("" +c.getIddiseñador());
                   tabla.addCell("" + c.getNombre());
                   tabla.addCell("" + c.getFecha());
                   tabla.addCell("");
                   tabla.addCell("");
               }
               doc.add(tabla);
               Paragraph p1 = new Paragraph(10);
               p1.add(Chunk.NEWLINE);
               p1.add("NÚMERO DE DISEÑADORES: " + listaDiseñadores.size());
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
               JOptionPane.showMessageDialog(frmPantallaDiseñador, "" + ex.getMessage());
               //Logger.getLogger(todosPDF.class.getName()).log(Level.SEVERE, null, ex);
           }
   }
}
