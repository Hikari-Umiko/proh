package data;

public class Usuario {
	int idcajero;
	String correo;
	String password;
	DataUsuario du = new DataUsuario();

	public Usuario() {

	}

	public boolean insertarUsuario() {
		if (du.insertarUsuario(this)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean login() {
		if (du.login(this)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean eliminarUsuario() {
		if (du.eliminarUsuario(this.getIdcajero())) {
			return true;
		} else {
			return false;
		}
	}
	public boolean actualizarUsuario() {
		if(du.actualizarUsuario(this)) {
			return true;
		}else {
			return false;
		}
	}

	public int getIdcajero() {
		return idcajero;
	}

	public void setIdcajero(int idcajero) {
		this.idcajero = idcajero;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
