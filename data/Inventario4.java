package data;

public class Inventario4 {
	int idinventario;
	String modelo;
	String cantidad;
	String diseñador;
	String precio;
	String fecha;
	DataInventario4 in = new DataInventario4();

	public Inventario4() {

	}

	public boolean insertarInventario() {
		if (in.insertarInventario(this)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean eliminarInventario() {
		if (in.eliminarInventario(this.getIdinventario())) {
			return true;
		} else {
			return false;
		}
	}
	public boolean actualizarInventario() {
		if(in.actualizarInventario(this)) {
			return true;
		}else {
			return false;
		}
	}

	public int getIdinventario() {
		return idinventario;
	}

	public void setIdinventario(int idinventario) {
		this.idinventario = idinventario;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getDiseñador() {
		return diseñador;
	}

	public void setDiseñador(String diseñador) {
		this.diseñador = diseñador;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}





	}
