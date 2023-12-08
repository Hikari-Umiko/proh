package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataInventario3 {
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
	public boolean insertarInventario(Inventario3 i) {
		try {
			PreparedStatement ps = conectar().prepareStatement("INSERT INTO inventario3 VALUES(?,?,?,?,?,?)");
			ps.setInt(1, i.getIdinventario());
			ps.setString(2, i.getModelo());
			ps.setString(3, i.getCantidad());
			ps.setString(4, i.getDiseñador());
			ps.setString(5, i.getPrecio());
			ps.setString(6, i.getFecha());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<Inventario3> selectInventarios(){
		ArrayList<Inventario3>listaInventario=new ArrayList<Inventario3>();
		try {
			PreparedStatement ps=conectar().prepareStatement("SELECT * FROM inventario3");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Inventario3 x=new Inventario3();
				x.setIdinventario(rs.getInt(1));
				x.setModelo(rs.getString(2));
				x.setCantidad(rs.getString(3));
				x.setDiseñador(rs.getString(4));
				x.setPrecio(rs.getString(5));
				x.setFecha(rs.getString(6));
				listaInventario.add(x);
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listaInventario;
	}
	public boolean eliminarInventario(int idinventario) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("DELETE FROM inventario3 WHERE idinventario=?");
			ps.setInt(1,idinventario);
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean actualizarInventario(Inventario3 i) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("UPDATE inventario3 SET modelo=?,cantidad=?,diseñador=?,precio=?,fecha=? WHERE idinventario=?");
			ps.setString(1,i.getModelo());
			ps.setString(2,i.getCantidad());
			ps.setString(3,i.getDiseñador());
			ps.setString(4,i.getPrecio());
			ps.setString(5,i.getFecha());
			ps.setInt(6,i.getIdinventario());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
