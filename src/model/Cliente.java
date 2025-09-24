package model;

public class Cliente {

	private Long id;
	private String nombre;
	private String apellido;

	public Cliente(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Cliente() {
	}

	public void validar() {
		if (nombre == null || nombre.isBlank())
			throw new IllegalArgumentException("Nombre inválido");
		if (apellido == null || apellido.isBlank())
			throw new IllegalArgumentException("Apellido inválido");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
