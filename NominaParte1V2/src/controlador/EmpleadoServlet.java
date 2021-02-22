package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpleadoDAO;
import dao.NominaDAO;
import modelos.Empleado;
import modelos.Nomina;

/**
 * Servlet implementation class EmpleadoServlet.
 */
@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new empleado servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpleadoServlet() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");
		if (accion == null) {
			accion = "index";
		}
		try {
			switch (accion) {
			case "lista":
				listarEmpleado(request, response);
				break;
			case "salario":
				paginaSalario(request, response);
				break;
			case "editar":
				mostrarFormulario(request, response);
				break;
			case "index":
				request.getRequestDispatcher("index.html").forward(request, response);
				break;

			}
		} catch (Exception e) {
			System.out.println(e);
			request.getRequestDispatcher("index.html").forward(request, response);
		}

	}

	/**
	 * Do post.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");

		try {
			switch (accion) {

			case "lista":
				listarEmpleado(request, response);
				break;
			case "salario":
				recogerSalario(request, response);
				break;
			case "editar":
				actualizarEmpleado(request, response);
				break;

			}
		} catch (Exception e) {
			System.out.println(e);
			request.getRequestDispatcher("index.html").forward(request, response);
		}

	}

	// Metodos

	/**
	 * Listar empleado: metodo que muestra todos los empleados que existen en la
	 * BBDD
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws SQLException     the SQL exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	private void listarEmpleado(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Empleado> listaEmpleado = EmpleadoDAO.listarEmpleados();
		request.setAttribute("listaEmpleado", listaEmpleado);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/lista.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Mostrar formulario: metodo que reocoge los datos del empleado que se va a
	 * editar y lo muestra en la pagina jsp
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dni = request.getParameter("dni");
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		Empleado empleado = empleadoDAO.recogerEmpleado(dni);

		request.setAttribute("empleado", empleado);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/formulario.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * Actualizar empleado: Metodo que actualiza el empleado que vamos a editar.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 * @throws SQLException     the SQL exception
	 */
	private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String nombre = request.getParameter("nombre");
		String dni = request.getParameter("dni");
		String sexo = request.getParameter("sexo");
		String anyosStr = request.getParameter("anyos");
		String categoriaStr = request.getParameter("categoria");

		int anyos = Integer.parseInt(anyosStr);
		int categoria = Integer.parseInt(categoriaStr);
		Empleado empleado = new Empleado(nombre, dni, sexo, anyos, categoria);
		Nomina nomina = new Nomina();
		int sueldo = nomina.sueldo(anyos, categoria);
		nomina.setSueldo(sueldo);
		nomina.setDniEmp(dni);

		NominaDAO nomDAO = new NominaDAO();
		EmpleadoDAO empDAO = new EmpleadoDAO();

		nomDAO.actualizarNomina(nomina);
		empDAO.actualizarEmpleado(empleado);

		listarEmpleado(request, response);
	}

	/**
	 * Recoger salario: metodo que recoge de la BBDD el salario segun el dni
	 * introducido
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	private void recogerSalario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dni = request.getParameter("dni");
		Nomina nomina = new Nomina();
		NominaDAO nominaDAO = new NominaDAO();

		nomina = nominaDAO.mostrarSalario(dni);

		if (nomina == null) {
			String jspSalario = "/WEB-INF/pages/mostrarSalario.jsp";
			request.getRequestDispatcher(jspSalario).forward(request, response);
		}

		request.setAttribute("dni", nomina.getDniEmp());
		request.setAttribute("sueldo", nomina.getSueldo());
		request.setAttribute("cabecera", "Sueldo anual");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/mostrarSalario.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Pagina salario: Metodo que nos muestra el salario en la pagina jsp
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	private void paginaSalario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/mostrarSalario.jsp");
		dispatcher.forward(request, response);

	}

}
