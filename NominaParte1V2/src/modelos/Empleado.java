package modelos;

/**
 * The Class Empleado.
 */
public class Empleado {

	/** The sexo. */
	private String nombre, dni, sexo;

	/** The anyos. */
	private int categoria, anyos;

	/**
	 * Instantiates a new empleado.
	 */
	public Empleado() {

	}

	/**
	 * Instantiates a new empleado.
	 *
	 * @param nombre    the nombre
	 * @param dni       the dni
	 * @param sexo      the sexo
	 * @param categoria the categoria
	 * @param anyos     the anyos
	 */
	public Empleado(String nombre, String dni, String sexo, int categoria, int anyos) {
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
		this.categoria = categoria;
		this.anyos = anyos;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Sets the dni.
	 *
	 * @param dni the new dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Gets the sexo.
	 *
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * Sets the sexo.
	 *
	 * @param sexo the new sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * Gets the categoria.
	 *
	 * @return the categoria
	 */
	public int getCategoria() {
		return categoria;
	}

	/**
	 * Sets the categoria.
	 *
	 * @param categoria the new categoria
	 */
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	/**
	 * Gets the anyos.
	 *
	 * @return the anyos
	 */
	public int getAnyos() {
		return anyos;
	}

	/**
	 * Sets the anyos.
	 *
	 * @param anyos the new anyos
	 */
	public void setAnyos(int anyos) {
		this.anyos = anyos;
	}

}
