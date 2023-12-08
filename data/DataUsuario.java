package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataUsuario {
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

	public boolean insertarUsuario(Usuario u) {
		PreparedStatement ps = null;
		try {
			ps = conectar().prepareStatement("INSERT INTO cajero VALUES(null,?,?)");
			ps.setString(1, u.getCorreo());
			ps.setString(2, u.getPassword());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<Usuario> selectUsuarios(){
		ArrayList<Usuario>listaUsuarios=new ArrayList<Usuario>();
		try {
			PreparedStatement ps=conectar().prepareStatement("SELECT * FROM cajero");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Usuario x=new Usuario();
				x.setIdcajero(rs.getInt(1));
				x.setCorreo(rs.getString(2));
				x.setPassword(rs.getString(3));
				listaUsuarios.add(x);
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}

	public boolean login(Usuario x){
		try {
			PreparedStatement ps=conectar().prepareStatement("SELECT * FROM usuario WHERE correo=? AND password=?");
			ps.setString(1,x.getCorreo());
			ps.setString(2,x.getPassword());
			ResultSet rs=ps.executeQuery();
			System.out.println("SQL: "+ps.toString());
			if(rs.next()) {
				x.setIdcajero(rs.getInt(1));
				x.setCorreo(rs.getString(2));
				x.setPassword(rs.getString(4));
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}		
	}
	public boolean eliminarUsuario(int id) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("DELETE FROM cajero WHERE idcajero=?");
			ps.setInt(1,id);
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean actualizarUsuario(Usuario u) {
		PreparedStatement ps;
		try {
			ps = conectar().prepareStatement("UPDATE cajero SET correo=?,password=? WHERE idcajero=?");
			ps.setString(1,u.getCorreo());
			ps.setString(2,u.getPassword());
			ps.setInt(3,u.getIdcajero());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}