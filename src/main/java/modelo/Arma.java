package modelo;

public class Arma {

	private int id;
	private String nombre;
	private int capacidad_danio;
	private String foto;
	
	public Arma() {
		
	}
	
	public Arma(int id, String nombre, int capacidad_danio, String foto) {
		this.id = id;
		this.nombre = nombre;
		this.capacidad_danio = capacidad_danio;
		this.foto = foto;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCapacidad_danio() {
		return capacidad_danio;
	}
	public void setCapacidad_danio(int capacidad_danio) {
		this.capacidad_danio = capacidad_danio;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Escudo [id=" + id + ", nombre=" + nombre + ", capacidad_danio=" + capacidad_danio + ", foto=" + foto
				+ "]";
	}
	
	
}