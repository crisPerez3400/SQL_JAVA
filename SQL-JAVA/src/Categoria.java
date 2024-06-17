package SqlJava;

public class Categoria {
	private String categoria;
	private String descripcion;
	
	
	public Categoria(String categoria, String descripcion) {
		this.categoria = categoria;
		this.descripcion = descripcion;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
