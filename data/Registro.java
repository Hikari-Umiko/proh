package data;

public class Registro {
int idclientes;
String nombre;
String correo;
String telefono;
String pago;
DataRegistro ct=new DataRegistro();

public boolean insertarCliente() {
	if (ct.insertarCliente(this)) {
		return true;
	} else {
		return false;
	}
}

public int getIdclientes() {
	return idclientes;
}

public void setIdclientes(int idclientes) {
	this.idclientes = idclientes;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getCorreo() {
	return correo;
}

public void setCorreo(String correo) {
	this.correo = correo;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getPago() {
	return pago;
}

public void setPago(String pago) {
	this.pago = pago;
}


}
