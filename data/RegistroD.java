package data;

public class RegistroD {
int iddiseñador;
String nombre;
String fecha;

DataRegistroD ct=new DataRegistroD();

public boolean insertarDiseñador() {
	if (ct.insertarDiseñador(this)) {
		return true;
	} else {
		return false;
	}
}

public int getIddiseñador() {
	return iddiseñador;
}

public void setIddiseñador(int iddiseñador) {
	this.iddiseñador = iddiseñador;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getFecha() {
	return fecha;
}

public void setFecha(String fecha) {
	this.fecha = fecha;
}


}
