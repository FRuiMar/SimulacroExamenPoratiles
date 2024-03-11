package ejemploExamen3.portatiles.entidades;

import java.util.Date;

public class Portatil {

	private int id;
	private String modelo;
	private String sn;
	private int numProcesadores;
	private boolean vendido;
	private Date fechaVenta;
	private int idMarca;
	
	
	
	public Portatil() {
		super();
	}
	
	
	public Portatil(int id, String modelo, String sn, int numProcesadores, boolean vendido, Date fechaVenta,
			int idMarca) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.sn = sn;
		this.numProcesadores = numProcesadores;
		this.vendido = vendido;
		this.fechaVenta = fechaVenta;
		this.idMarca = idMarca;
	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public int getNumProcesadores() {
		return numProcesadores;
	}
	public void setNumProcesadores(int numProcesadores) {
		this.numProcesadores = numProcesadores;
	}
	public boolean isVendido() {
		return vendido;
	}
	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public int getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	
	
	
}
