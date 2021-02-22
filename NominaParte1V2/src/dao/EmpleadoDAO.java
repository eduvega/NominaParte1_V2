package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelos.Empleado;
import modelos.Nomina;

/**
 * The Class EmpleadoDAO.
 */
public class EmpleadoDAO {

	/** The conexion. */
	private static Connection conexion;

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	public static Connection conectar() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/laboral", "root", "");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conexion;

	}

	/*
	 * Listar empleados.
	 *
	 * @return the list
	 */
	public static List<Empleado> listarEmpleados() {
		Connection conexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Empleado> empleados = new ArrayList<>();

		try {
			conexion = conectar();
			preparedStatement = conexion.prepareStatement("select * from empleados");
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String dni = rs.getString("dni");
				String sexo = rs.getString("sexo");
				int anyos = rs.getInt("anyos");
				int categoria = rs.getInt("categoria");
				empleados.add(new Empleado(nombre, dni, sexo, anyos, categoria));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleados;

	}

	/**
	 * Mostrar salario.
	 *
	 * @param dni the dni
	 * @return the nomina
	 */
	public static Nomina mostrarSalario(String dni) {

		Nomina nom = null;
		try {
			Connection conexion = conectar();
			Statement consulta = conexion.createStatement();
			ResultSet rs = consulta.executeQuery("SELECT * FROM nomina WHERE dni= '" + dni + "'");
			while (rs.next()) {
				nom = new Nomina(rs.getInt(1), rs.getString(2));
			}
			conexion.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return nom;
	}

	/**
	 * Actualizar empleado.
	 *
	 * @param empleado the empleado
	 * @throws SQLException the SQL exception
	 */
	public void actualizarEmpleado(Empleado empleado) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = conectar();
			preparedStatement = connection
					.prepareStatement("update empleados set nombre = ?,sexo= ?, categoria =?, anyos =? where dni = ?;");
			preparedStatement.setString(1, empleado.getNombre());
			preparedStatement.setString(2, empleado.getSexo());
			preparedStatement.setInt(3, empleado.getCategoria());
			preparedStatement.setInt(4, empleado.getAnyos());
			preparedStatement.setString(5, empleado.getDni());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Recoger empleado.
	 *
	 * @param dniEmpleado the dni empleado
	 * @return the empleado
	 */
	public Empleado recogerEmpleado(String dniEmpleado) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Empleado empleado = null;

		try {
			connection = conectar();

			preparedStatement = connection
					.prepareStatement("select nombre, dni, sexo, anyos, categoria from empleados where dni =?");

			preparedStatement.setString(1, dniEmpleado);

			rs = preparedStatement.executeQuery();

			rs.absolute(1);
			String nombre = rs.getString("nombre");
			String dni = rs.getString("dni");
			String sexo = rs.getString("sexo");
			int anyos = rs.getInt("anyos");
			int categoria = rs.getInt("categoria");
			empleado = new Empleado(nombre, dni, sexo, anyos, categoria);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleado;
	}

}
