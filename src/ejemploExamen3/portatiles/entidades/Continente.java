package ejemploExamen3.portatiles.entidades;

public class Continente {

	private int id;
	private String descripcion;
	
	
	
	public Continente() {
		super();
	}
	
	
	
	public Continente(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
