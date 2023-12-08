package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataRegistro {
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
	public boolean insertarCliente(Registro r) {
		try {
			PreparedStatement ps = conectar().prepareStatement("INSERT INTO clientes VALUES(?,?,?,?,?)");
			ps.setInt(1, r.getIdclientes());
			ps.setString(2, r.getNombre());
			ps.setString(3, r.getCorreo());
			ps.setString(4, r.getTelefono());
			ps.setString(5, r.getPago());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
