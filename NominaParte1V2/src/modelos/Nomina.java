package modelos;

/**
 * The Class Nomina.
 */
public class Nomina {

	/** The sueldo. */
	private int sueldo;

	/** The dni emp. */
	private String dniEmp;

	/**
	 * Instantiates a new nomina.
	 */
	public Nomina() {

	}

	/**
	 * Instantiates a new nomina.
	 *
	 * @param sueldo the sueldo
	 * @param dniEmp the dni emp
	 */
	public Nomina(int sueldo, String dniEmp) {
		super();
		this.sueldo = sueldo;
		this.dniEmp = dniEmp;
	}

	/**
	 * Gets the sueldo.
	 *
	 * @return the sueldo
	 */
	public int getSueldo() {
		return sueldo;
	}

	/**
	 * Sets the sueldo.
	 *
	 * @param sueldo the new sueldo
	 */
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	/**
	 * Gets the dni emp.
	 *
	 * @return the dni emp
	 */
	public String getDniEmp() {
		return dniEmp;
	}

	/**
	 * Sets the dni emp.
	 *
	 * @param dniEmp the new dni emp
	 */
	public void setDniEmp(String dniEmp) {
		this.dniEmp = dniEmp;
	}

	/** The Constant SUELDO_BASE. */
	private static final int[] SUELDO_BASE = { 50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000,
			230000 };

	/**
	 * Sueldo: metodo que nos calcula el sueldo de un empleado en funcion del anio y la categoria 
	 * que se establezca para el mismo.
	 *
	 * @param anyos     the anyos
	 * @param categoria the categoria
	 * @return the int
	 */
	public int sueldo(int anyos, int categoria) {
		int sueldo;
		sueldo = SUELDO_BASE[categoria - 1] + 5000 * anyos;
		return sueldo;
	}
}
