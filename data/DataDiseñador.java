package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataDiseñador {
	Connection cx;
	
	public Connection conectar() {
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas", "root", "");
			System.out.println("CONEXION EXITOSA");

		} catch (SQLException e) {
			System.out.println("FALLO CONEXION");
			e.printStackTrace();
		}
		return cx;
	}
	public  ArrayList<Diseñador> selectDiseñadores(){
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Diseñador> listaClientes=new ArrayList<Diseñador>();
				try {
					ps=conectar().prepareStatement("SELECT * FROM diseñador");
					rs=ps.executeQuery();
					while(rs.next()) {
						Diseñador c=new Diseñador();
						c.setIddiseñador(rs.getInt(1));
						c.setNombre(rs.getString(2));
						c.setFecha(rs.getString(3));
						listaClientes.add(c);
					}
				}catch  (Exception e) {
					e.printStackTrace();
				}
				return listaClientes;
	}
}
