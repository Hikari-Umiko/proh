package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class DataClientes {
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
	
	public  ArrayList<Clientes> selectClientes(){
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Clientes> listaClientes=new ArrayList<Clientes>();
				try {
					ps=conectar().prepareStatement("SELECT * FROM clientes");
					rs=ps.executeQuery();
					while(rs.next()) {
						Clientes c=new Clientes();
						c.setIdclientes(rs.getInt(1));
						c.setNombre(rs.getString(2));
						c.setCorreo(rs.getString(3));
						c.setTelefono(rs.getString(4));
						c.setPago(rs.getString(5));
						listaClientes.add(c);
					}
				}catch  (Exception e) {
					e.printStackTrace();
				}
				return listaClientes;
	}
	public boolean cargarClientes(Clientes c){
		PreparedStatement ps=null;
		ResultSet rs=null;
				try {
					ps=conectar().prepareStatement("SELECT * FROM clientes WHERE idclientes=?");
					ps.setInt(1, c.getIdclientes());
					rs=ps.executeQuery();
					if(rs.next()) {
						c.setNombre(rs.getString(2));
						c.setCorreo(rs.getString(3));
						c.setTelefono(rs.getString(4));
						c.setPago(rs.getString(5));
						return true;
					}else {
						return false;
					}
					
				}catch  (Exception e) {
					e.printStackTrace();
					return false;
				}
	}
	
	public boolean eliminarClientes(int idclientes) {
		PreparedStatement ps=null;
		try {
			Clientes x=new Clientes();
			x.setIdclientes(idclientes);
			if (x.cargarClientes()) {
				ps=conectar().prepareStatement("DELETE FROM clientes WHERE idclientes=?");
				ps.setInt(1, idclientes);
				ps.execute();
				return true;
			}else {
				return false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean actualizarClientes(Clientes c) {
		PreparedStatement ps=null;
		try {
			Clientes x=new Clientes();
			x.setIdclientes(c.getIdclientes());
			if (x.cargarClientes()) {
				ps=conectar().prepareStatement("UPDATE clientes SET nombre=?,correo=?,telefono=?,pago=?"
						+" WHERE idcelular=?");
				ps.setString(1, c.getNombre());
				ps.setString(2, c.getCorreo());
				ps.setString(3, c.getTelefono());
				ps.setString(4, c.getPago());
				ps.setInt(5, c.getIdclientes());
				ps.execute();
				return true;
			}else {
				return false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
